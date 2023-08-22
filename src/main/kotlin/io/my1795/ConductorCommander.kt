package io.my1795

import io.my1795.workflow.WorkflowCommander
import io.quarkus.picocli.runtime.annotations.TopCommand
import picocli.CommandLine
import picocli.CommandLine.Command
import java.util.concurrent.Callable
import kotlin.system.exitProcess


@Command(
    name = "cnd", mixinStandardHelpOptions = true, version = ["conductor-commander 1.0.1"],
    description = ["Netflix Conductor Commander"], subcommands = [WorkflowCommander::class]
)
@TopCommand
class ConductorCommander : Callable<Int> {
    override fun call(): Int {
        return 0
    }
}

fun main(args: Array<String>): Unit = exitProcess(CommandLine(ConductorCommander()).execute(*args))