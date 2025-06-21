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
    exclude("META-INF/maven/**")
    exclude("META-INF/services/**")
    exclude("META-INF/versions/**")
    exclude("META-INF/kotlin-stdlib-jdk8.kotlin_module")
    exclude("META-INF/kotlin-stdlib-jdk7.kotlin_module")
    exclude("META-INF/kotlin-stdlib.kotlin_module")
    exclude("com/**")
    exclude("kotlin/**")
    exclude("net/**")
    exclude("org/**")
}