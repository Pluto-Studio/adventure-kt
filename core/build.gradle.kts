plugins {
    id("maven-publish")
}

kotlin {
    jvmToolchain(8)
}

java {
    withSourcesJar()
}

publishing {
    repositories {
        maven {
            name = "nostal"
            url = uri(
                if (version.toString().endsWith("SNAPSHOT")) {
                    "https://maven.nostal.ink/repository/maven-snapshots/"
                } else {
                    "https://maven.nostal.ink/repository/maven-releases/"
                }
            )
            credentials(PasswordCredentials::class)
        }
    }

    publications.create<MavenPublication>("maven") {
        from(components["java"])
    }
}
