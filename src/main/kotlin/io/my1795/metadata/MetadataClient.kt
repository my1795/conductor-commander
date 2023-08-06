package io.my1795.metadata

import io.ktor.client.statement.*
import io.my1795.config.RestClient
import jakarta.annotation.PostConstruct
import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject
import kotlinx.coroutines.runBlocking
import picocli.CommandLine

@ApplicationScoped
@CommandLine.Command(name = "metadata",  aliases = ["md"], mixinStandardHelpOptions = true)
class MetadataClient : Runnable{
    @Inject
    lateinit var restClient : RestClient

    fun getWorkflowsMD() : String {
       var res =  runBlocking {
            restClient.get("api/metadata/workflow").bodyAsText()
        }
        return res
    }

    override fun run() {
        println(getWorkflowsMD())
    }
}