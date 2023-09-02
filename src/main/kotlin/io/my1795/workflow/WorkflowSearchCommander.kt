package io.my1795.workflow

import io.my1795.client.WorkflowClient
import io.my1795.model.Workflow
import jakarta.inject.Inject
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import picocli.CommandLine.Command
import picocli.CommandLine.Option


@Command(name = "search", aliases = ["s"],description = arrayOf("uses searchV2 of conductor to search workflows"))
class WorkflowSearchCommander : Runnable {
    val json = Json { prettyPrint = true }

    @Option(names = ["-q","--query"])
     var searchQuery : String? = null

    @Option(names = ["-id","--workflowId"])
     var workflowId : String? = null

    @Inject
    lateinit var workflowClient : WorkflowClient

    override fun run() {
        workflowId?.let {
            val workflow =  workflowClient.getWorkflow(workflowId!!,true)
            println(json.encodeToString(workflow))
        }
        searchQuery?.let {
            println("test")
        }


    }
}