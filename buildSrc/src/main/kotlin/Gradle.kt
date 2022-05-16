object Plugins {
    const val JVM = "jvm"
    const val SPRING = "plugin.spring"
    const val JPA = "plugin.jpa"
    const val SPRING_BOOT = "org.springframework.boot"
    const val SPRING_DEPENDENCY_MANAGEMENT = "io.spring.dependency-management"
    const val KTLINT = "org.jlleitschuh.gradle.ktlint"
    const val KTLINT_IDEA = "org.jlleitschuh.gradle.ktlint-idea"
    const val IDEA = "idea"
}

object Versions {
    const val KOTLIN = "1.6.21"
    const val SPRING_BOOT = "2.6.7"
    const val SPRING_DEPENDENCY_MANAGEMENT = "1.0.11.RELEASE"
    const val KTLINT = "10.3.0"
}

object Dependencies {
    object SpringBoot {
        const val STARTER_WEB = "org.springframework.boot:spring-boot-starter-web"
        const val STARTER_DATA_JPA = "org.springframework.boot:spring-boot-starter-data-jpa"
        const val CONFIGURATION_PROCESSOR = "org.springframework.boot:spring-boot-configuration-processor"
        const val STARTER_TEST = "org.springframework.boot:spring-boot-starter-test"
    }

    object Kotlin {
        const val REFLECT = "org.jetbrains.kotlin:kotlin-reflect"
//        const val STDLIB_JDK8 = "org.jetbrains.kotlin:kotlin-stdlib-jdk8"
    }

    object Database {
        const val H2 = "com.h2database:h2"
    }

    const val JACKSON_MODULE_KOTLIN = "com.fasterxml.jackson.module:jackson-module-kotlin"
}

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
