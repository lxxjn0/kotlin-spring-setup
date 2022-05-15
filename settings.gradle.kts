rootProject.name = "kotlin-sandbox"

pluginManagement {
    repositories {
        gradlePluginPortal()
    }
}

include(
    ":sandbox-core",
    ":sandbox-feign-module",
    ":sandbox-web",
)
