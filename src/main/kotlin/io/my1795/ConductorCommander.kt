package io.my1795

import picocli.CommandLine.Command
import picocli.CommandLine.Parameters
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.coroutines.*
import java.lang.Runnable

@Command(name = "config", mixinStandardHelpOptions = true)
class ConductorCommander : Runnable {

    @Parameters(paramLabel = "<name>", defaultValue = "picocli", description = ["Get Configuration"])
    var name: String? = null
    override fun run() {

    }
}