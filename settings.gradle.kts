plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}
rootProject.name = "adventurekt"
include("core")
include("paper-bundle")
include("paper-spacefree")
include("velocity-bundle")