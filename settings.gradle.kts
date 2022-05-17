rootProject.name = "kotlin-sandbox"

pluginManagement {
    repositories {
        gradlePluginPortal()
    }
}

include(
    ":sandbox-api",
    ":sandbox-batch",
    ":sandbox-common",
    ":sandbox-core",
    ":sandbox-web",
    ":modules:sandbox-aws-s3",
    ":modules:sandbox-open-feign",
    ":modules:sandbox-web-client",
)
