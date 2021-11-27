package dev.fractallove.fracbot

import com.kotlindiscord.kord.extensions.ExtensibleBot
import com.kotlindiscord.kord.extensions.utils.env
import dev.kord.common.entity.Snowflake
import dev.kord.core.Kord
import dev.kord.gateway.Intents
import kotlinx.coroutines.delay
import dev.fractallove.fracbot.extensions.DailyFractalsExtension
import dev.fractallove.fracbot.models.enums.Fractals

suspend fun main() {

    Fractals.AETHERBLADE.getFractal()

    val TEST_SERVER_ID = Snowflake(
        env("TEST_SERVER").toLong()
    )

    val TOKEN = env("TOKEN")

    val bot = ExtensibleBot(TOKEN) {
        applicationCommands {
            enabled = true
        }

        extensions {
            add(::DailyFractalsExtension)
        }
    }

    bot.findExtension<DailyFractalsExtension>()?.fetchDailyFractals()

    bot.start()


}

