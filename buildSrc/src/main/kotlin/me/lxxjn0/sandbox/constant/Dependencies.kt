package me.lxxjn0.sandbox.constant

object Dependencies {
    object SpringBoot {
        const val STARTER_WEB = "org.springframework.boot:spring-boot-starter-web"
        const val STARTER_DATA_JPA = "org.springframework.boot:spring-boot-starter-data-jpa"
        const val CONFIGURATION_PROCESSOR = "org.springframework.boot:spring-boot-configuration-processor"
        const val STARTER_TEST = "org.springframework.boot:spring-boot-starter-test"
    }

    object Kotlin {
        const val REFLECT = "org.jetbrains.kotlin:kotlin-reflect"
        const val STDLIB_JDK8 = "org.jetbrains.kotlin:kotlin-stdlib-jdk8"
    }

    const val JACKSON_MODULE_KOTLIN = "com.fasterxml.jackson.module:jackson-module-kotlin"
}
