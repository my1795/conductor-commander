package io.my1795

import io.my1795.metadata.TitleCapitalizer
import jakarta.inject.Inject
import picocli.CommandLine
import picocli.CommandLine.Command
import java.io.File
import java.io.IOException
import java.io.UncheckedIOException
import java.math.BigInteger
import java.nio.file.Files
import java.security.MessageDigest
import java.util.concurrent.Callable
import kotlin.system.exitProcess


@Command(name = "checksum", mixinStandardHelpOptions = true, version = ["checksum 4.0"],
        description = ["Prints the checksum (SHA-256 by default) of a file to STDOUT."])
class Checksum : Callable<Int> {

    @CommandLine.Parameters(index = "0", description = ["The file whose checksum to calculate."])
    lateinit var capitalized: String
    @Inject
    lateinit var titleCapitalizer: TitleCapitalizer
    override fun call(): Int {
        println(titleCapitalizer.capitalize(capitalized))
        return 0
    }
}

fun main(args: Array<String>) : Unit = exitProcess(CommandLine(Checksum()).execute(*args))