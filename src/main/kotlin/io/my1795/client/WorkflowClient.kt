package io.my1795.client

import io.ktor.client.call.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.my1795.config.RestClient
import io.my1795.model.Workflow
import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject
import kotlinx.coroutines.runBlocking


@ApplicationScoped
class WorkflowClient {
 

    @Inject
    lateinit var restClient : RestClient


    fun getWorkflow(workflowId: String, b: Boolean): Workflow? {
        var workflow : Workflow?
        runBlocking {
            val result = restClient.get("workflow/$workflowId?includeTasks=$b")
             workflow =  if (result.status.isSuccess()) result.body() else throw Exception(result.bodyAsText())
        }
        return workflow!!
    }

    fun searchV2(searchQuery: String): Any {
        return Any();
    }
}