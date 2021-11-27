package dev.fractallove.fracbot.gw2api

import dev.fractallove.fracbot.models.FractalAchievement
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.features.*
import io.ktor.client.request.*
import io.ktor.http.*
import java.net.URL

class Gw2ApiClient {

    private val apiEndpoint = "https://api.guildwars2.com/v2/"
    private val httpClient: HttpClient = HttpClient(CIO) {
        engine {

        }
        defaultRequest {
            header("X-Schema-Version", "2021-11-26T00:00:00Z")
            header("Accept-Language", "en")
        }
    }

    suspend fun fetchDailyFractalAchievements() : Array<FractalAchievement> {
        var url = Url(apiEndpoint + "achievements/daily")

        return arrayOf()
    }

}