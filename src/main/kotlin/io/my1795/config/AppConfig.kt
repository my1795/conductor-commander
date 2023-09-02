package io.my1795.config

import io.quarkus.runtime.annotations.StaticInitSafe
import io.smallrye.config.ConfigMapping
import io.smallrye.config.WithDefault


@ConfigMapping(prefix = "server")
@StaticInitSafe
interface AppConfig {
    @WithDefault("localhost")
    fun host(): String
    @WithDefault("8080")
    fun port(): Int
}
