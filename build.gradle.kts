plugins {
    kotlin("jvm") version "1.9.0"
    // shadow
    id("com.github.johnrengelman.shadow") version "7.1.2"
    application
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    // Spigot api
    maven(url = "https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
}

val exposedVersion: String by project

dependencies {
    implementation("net.dv8tion:JDA:5.0.0-beta.18") {
        exclude(module = "java-opus")
    }
    implementation("org.spigotmc:spigot-api:1.20.2-R0.1-SNAPSHOT")

    // Add mysql stuff
    implementation("mysql:mysql-connector-java:8.0.28")
    implementation("org.xerial:sqlite-jdbc:3.44.1.0")

    implementation("org.jetbrains.exposed:exposed-core:$exposedVersion")
    implementation("org.jetbrains.exposed:exposed-crypt:$exposedVersion")
    implementation("org.jetbrains.exposed:exposed-jdbc:$exposedVersion")
    implementation("org.jetbrains.exposed:exposed-java-time:$exposedVersion")


}

tasks.build {
    dependsOn(tasks.shadowJar)
}

tasks.shadowJar {
    minimize()
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(8)
}

application {
    mainClass.set("MainKt")
}