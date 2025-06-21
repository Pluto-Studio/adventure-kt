plugins {
    id("com.gradleup.shadow") version "9.0.0-beta16"
}

repositories {
    mavenCentral()
}

dependencies {
    compileOnly(libs.velocity.api)

    implementation(project(":core"))

    annotationProcessor(libs.velocity.api)
}

kotlin {
    jvmToolchain(21)
}

tasks.build {
    dependsOn(tasks.shadowJar)
}

tasks.shadowJar {
    archiveClassifier.set("")
}