import org.jetbrains.kotlin.gradle.utils.extendsFrom

plugins {
    kotlin("jvm") version "1.8.22"
    kotlin("plugin.allopen") version "1.8.22"
    id("io.quarkus")
}

repositories {
    mavenCentral()
    mavenLocal()
}

val quarkusPlatformGroupId: String by project
val quarkusPlatformArtifactId: String by project
val quarkusPlatformVersion: String by project
val ktor_version: String by project

dependencies {
    implementation(enforcedPlatform("${quarkusPlatformGroupId}:${quarkusPlatformArtifactId}:${quarkusPlatformVersion}"))
    implementation("io.quarkus:quarkus-picocli")
    annotationProcessor("info.picocli:picocli-codegen:4.7.4")
    implementation("io.quarkus:quarkus-kotlin")
    implementation("io.quarkus:quarkus-arc")
    //conductor
    implementation("com.netflix.conductor:conductor-common:3.3.6")
    implementation("com.netflix.conductor:conductor-client:3.3.6")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.11.4")
    implementation("com.google.guava:guava:30.0-jre")
    implementation("cglib:cglib:3.3.0")
    implementation("com.sun.jersey:jersey-client:1.19.4")
    implementation("javax.ws.rs:javax.ws.rs-api:2.0.1")
    implementation("org.glassfish.jersey.core:jersey-common:2.22.2")

}

group = "io.my1795"
version = "1.0.0-SNAPSHOT"



java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

tasks.withType<Test> {
    systemProperty("java.util.logging.manager", "org.jboss.logmanager.LogManager")
}
allOpen {
    annotation("jakarta.ws.rs.Path")
    annotation("jakarta.enterprise.context.ApplicationScoped")
    annotation("io.quarkus.test.junit.QuarkusTest")
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions.jvmTarget = JavaVersion.VERSION_17.toString()
    kotlinOptions.javaParameters = true
}
