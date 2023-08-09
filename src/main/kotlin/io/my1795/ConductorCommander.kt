package io.my1795

import com.netflix.conductor.client.http.TaskClient
import io.my1795.metadata.TitleCapitalizer
import jakarta.inject.Inject
import picocli.CommandLine
import picocli.CommandLine.Command
import java.util.concurrent.Callable
import kotlin.system.exitProcess


@Command(
    name = "checksum", mixinStandardHelpOptions = true, version = ["checksum 4.0"],
    description = ["Prints the checksum (SHA-256 by default) of a file to STDOUT."]
)
class ConductorCommander : Callable<Int> {

    @CommandLine.Parameters(index = "0", description = ["The file whose checksum to calculate."])
    lateinit var capitalized: String
    var taskClient = TaskClient()
    @Inject
    lateinit var titleCapitalizer: TitleCapitalizer
    override fun call(): Int {
        println(titleCapitalizer.capitalize(capitalized))
        var search = taskClient.search(capitalized).results
        println("working taskClient: ${search}")
        return 0
    }
}

fun main(args: Array<String>): Unit = exitProcess(CommandLine(ConductorCommander()).execute(*args))