package io.my1795.workflow

import picocli.CommandLine.Command

@Command(name = "workflow", aliases = ["wf","w"],description = arrayOf("manages workflow resources"), subcommands = [WorkflowSearchCommander::class])
class WorkflowCommander : Runnable {
    override fun run() {

    }
}