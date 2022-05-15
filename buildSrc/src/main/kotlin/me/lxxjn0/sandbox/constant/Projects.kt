package me.lxxjn0.sandbox.constant

object Projects {
    const val SANDBOX_CORE = ":sandbox-core"
    const val SANDBOX_FEIGN_MODULE = ":sandbox-feign-module"
    const val SANDBOX_WEB = ":sandbox-web"

    val SPRING_PROJECTS = listOf(
        SANDBOX_CORE,
        SANDBOX_FEIGN_MODULE,
        SANDBOX_WEB,
    )
}
