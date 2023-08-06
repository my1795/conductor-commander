package io.my1795.config

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import jakarta.annotation.PostConstruct
import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject
import jakarta.inject.Singleton

@Singleton
class RestClient {
    var client: HttpClient = HttpClient(CIO)

    @Inject
    lateinit var config : AppConfig

    var mainUrl = URLBuilder()

    @PostConstruct
    fun init(){
        mainUrl.protocol = URLProtocol.HTTP
        mainUrl.host = config.host()
        mainUrl.port = config.port()
    }
    suspend fun get(resource: String) : HttpResponse {
        mainUrl.appendPathSegments(resource)
       return  client.get(mainUrl.build())
    }
}