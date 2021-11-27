package dev.fractallove.fracbot.extensions

import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.event
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand
import com.kotlindiscord.kord.extensions.types.respond
import dev.fractallove.fracbot.gw2api.Gw2ApiClient
import dev.kord.core.Kord

class DailyFractalsExtension : Extension() {

    override val name = "DailyFractals"

    override suspend fun setup() {
        publicSlashCommand {
            name = "daily"
            description = "Lists all daily fractals"
            action {
                respond {
                   content = "Test"
                }
            }
        }

    }

    fun fetchDailyFractals() {

    }

    fun fetchDailyFractalsForDate(apiClient: Gw2ApiClient) {

    }

}