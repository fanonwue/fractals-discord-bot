package dev.fractallove.fracbot

import java.io.FileInputStream
import java.net.URI
import java.nio.file.Path
import java.util.*
import java.util.stream.Stream
import kotlin.io.path.exists
import kotlin.io.path.notExists

@Deprecated("needs to be rewritten")
class Config() {
    val properties: Properties?

    init {
        val defaultProps = readPropertiesFile(
            Path.of(Config::class.java.getResource("/default-config.properties").toURI())
        );
        val userProps = readPropertiesFile(Path.of("config.properties"));

        properties = mergeProperties(defaultProps, userProps)
    }

    private fun readPropertiesFile(path: Path) : Properties {
        val propsFile = path;
        val props = Properties()
        if (propsFile.notExists()) return props
        FileInputStream(propsFile.toFile()).use {
            props.load(it)
        }
        return props
    }


    private fun mergeProperties(vararg properties: Properties) : Properties {
        val props = Properties()
        properties.forEach { props.putAll(it) }
        return props
    }
}