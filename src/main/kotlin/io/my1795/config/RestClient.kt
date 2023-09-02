package io.my1795.config

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import jakarta.annotation.PostConstruct
import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject
import kotlinx.serialization.json.Json

@ApplicationScoped
class RestClient {
    var client: HttpClient = HttpClient(CIO) {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
            })
        }
    }

    @Inject
    lateinit var config : AppConfig

    var mainUrl = URLBuilder()

    @PostConstruct
    fun init(){
        mainUrl.protocol = URLProtocol.HTTP
        mainUrl.host = config.host()
        mainUrl.port = config.port()
        mainUrl.appendPathSegments("api")
    }
    suspend fun get(resource: String) : HttpResponse {
        mainUrl.appendEncodedPathSegments(resource)
       return  client.get(mainUrl.build())
    }
}