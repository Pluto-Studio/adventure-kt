plugins {
    id("com.gradleup.shadow") version "9.0.0-beta16"
}

dependencies {
    compileOnly(libs.paper.api)
    implementation(project(":core"))
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