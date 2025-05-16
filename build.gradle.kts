plugins {
    kotlin("jvm") version "2.0.10"
}

allprojects {
    apply(plugin = "org.jetbrains.kotlin.jvm")
    apply(plugin = "java")

    group = "ink.pmc"
    version = "1.0-SNAPSHOT"

    repositories {
        mavenCentral()
    }

    dependencies {
        api(rootProject.libs.adventure.api)
        api(rootProject.libs.adventure.text.minimessage)
        api(rootProject.libs.adventure.text.serializer.gson)
        api(rootProject.libs.adventure.text.serializer.legacy)
        api(rootProject.libs.adventure.text.serializer.plain)
        api(rootProject.libs.adventure.text.serializer.ansi)
    }
}
