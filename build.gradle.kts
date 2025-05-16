plugins {
    kotlin("jvm") version "2.0.10"
}

allprojects {
    apply(plugin = "org.jetbrains.kotlin.jvm")
    apply(plugin = "java")

    group = "plutoproject.adventurekt"
    version = "2.0.0"

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
