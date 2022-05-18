rootProject.name = "kotlin-sandbox"

pluginManagement {
    repositories {
        gradlePluginPortal()
    }
}

include(
    ":sandbox-app-api",
    ":sandbox-app-batch",
    ":sandbox-app-service",
    ":sandbox-core-web",
    ":sandbox-domain",
    ":modules:sandbox-aws-s3",
    ":modules:sandbox-open-feign",
    ":modules:sandbox-web-client",
    ":clients:sandbox-api-client",
)
