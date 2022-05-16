object Plugins {
    const val JVM = "jvm"
    const val SPRING = "plugin.spring"
    const val JPA = "plugin.jpa"
    const val SPRING_BOOT = "org.springframework.boot"
    const val SPRING_DEPENDENCY_MANAGEMENT = "io.spring.dependency-management"
    const val KTLINT = "org.jlleitschuh.gradle.ktlint"
    const val KTLINT_IDEA = "org.jlleitschuh.gradle.ktlint-idea"
    const val KSP = "com.google.devtools.ksp"
    const val GRADLE_PLUGIN = "gradle-plugin"
}

object Versions {
    const val KOTLIN = "1.6.21"
    const val SPRING_BOOT = "2.6.7"
    const val SPRING_DEPENDENCY_MANAGEMENT = "1.0.11.RELEASE"
    const val KTLINT = "10.3.0"
    const val KSP = "1.6.21-1.0.5"
}

object Dependencies {
    object SpringBoot {
        const val STARTER_WEB = "org.springframework.boot:spring-boot-starter-web"
        const val STARTER_DATA_JPA = "org.springframework.boot:spring-boot-starter-data-jpa"
        const val STARTER_LOG4J2 = "org.springframework.boot:spring-boot-starter-log4j2"
        const val STARTER_BATCH = "org.springframework.boot:spring-boot-starter-batch"
        const val CONFIGURATION_PROCESSOR = "org.springframework.boot:spring-boot-configuration-processor"
        const val STARTER_TEST = "org.springframework.boot:spring-boot-starter-test"
    }

    object Kotlin {
        const val REFLECT = "org.jetbrains.kotlin:kotlin-reflect"
        const val STDLIB_JDK8 = "org.jetbrains.kotlin:kotlin-stdlib-jdk8"
        const val KSP = "com.google.devtools.ksp:symbol-processing-api:${Versions.KSP}"
    }

    object Database {
        const val H2 = "com.h2database:h2"
    }

    const val JACKSON_MODULE_KOTLIN = "com.fasterxml.jackson.module:jackson-module-kotlin"
}

object Projects {
    const val SANDBOX_BATCH = ":sandbox-batch"
    const val SANDBOX_COMMON = ":sandbox-common"
    const val SANDBOX_CORE = ":sandbox-core"
    const val SANDBOX_WEB = ":sandbox-web"

    object Modules {
        const val SANDBOX_AWS_S3 = ":modules:sandbox-aws-s3"
        const val SANDBOX_OPENFEIGN = ":modules:sandbox-open-feign"
        const val SANDBOX_WEBCLIENT = ":modules:sandbox-web-client"
    }

    val SPRING_PROJECTS = listOf(
        SANDBOX_BATCH,
        SANDBOX_COMMON,
        SANDBOX_CORE,
        SANDBOX_WEB,
        Modules.SANDBOX_AWS_S3,
        Modules.SANDBOX_OPENFEIGN,
        Modules.SANDBOX_WEBCLIENT,
    )
}
