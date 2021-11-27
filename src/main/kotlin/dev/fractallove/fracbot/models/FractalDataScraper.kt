package dev.fractallove.fracbot.models

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.features.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import org.jsoup.parser.ParseSettings
import org.jsoup.parser.Tag
import java.net.URL
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException
import java.util.*

class FractalDataScraper {
    private val httpClient: HttpClient = HttpClient(CIO) {
        engine {  }
    }

    suspend fun fetchFractals() : Array<Fractal> {
        val url = Url("https://wiki.guildwars2.com/wiki/Fractals_of_the_Mists")
        var response = httpClient.get<HttpResponse>(url)
        var document = Jsoup.parse(response.receive<String>())
        println(document.data())

        val element = document.body().getElementById("List_of_fractals")
        val table = element?.parent()?.nextElementSiblings()?.find {
            Tag.valueOf("table", ParseSettings.htmlDefault).equals(it.tag())
        }

        val rows = table?.child(0)?.children()

        rows?.removeFirst()

        return rows?.map {
            parseRow(it)
        }?.toTypedArray() ?: emptyArray()
    }

    private suspend fun parseRow(row: Element) : Fractal {
        val children = row.children()

        return Fractal(
            id = children[0].ownText().toInt(),
            name = normaliseName(children[1].text()),
            scales = getScales(children[5].ownText()),
            dateAdded = getDate(children[6].text())
        )
    }

    private suspend fun normaliseName(name: String) : String {
        return name.replace("Fractal", "").trim()
    }

    private suspend fun getScales(value: String) : IntArray {
        if (!value.contains(',')) return IntArray(0)
        return value.split(',').map {
            it.trim().toInt()
        }.toIntArray()
    }

    private suspend fun getDate(value: String) : LocalDate? {
        return try {
            val formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy").withLocale(Locale.US)
            LocalDate.parse(value, formatter)
        } catch (e: DateTimeParseException) {
            null;
        }
    }
}