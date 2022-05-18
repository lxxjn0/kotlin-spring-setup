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
        object Starter {
            const val WEB = "org.springframework.boot:spring-boot-starter-web"
            const val DATA_JPA = "org.springframework.boot:spring-boot-starter-data-jpa"
            const val LOG4J2 = "org.springframework.boot:spring-boot-starter-log4j2"
            const val BATCH = "org.springframework.boot:spring-boot-starter-batch"
            const val TEST = "org.springframework.boot:spring-boot-starter-test"
            const val VALIDATION = "org.springframework.boot:spring-boot-starter-validation"
        }

        const val CONFIGURATION_PROCESSOR = "org.springframework.boot:spring-boot-configuration-processor"
    }

    object Kotlin {
        const val REFLECT = "org.jetbrains.kotlin:kotlin-reflect"
        const val STDLIB_JDK8 = "org.jetbrains.kotlin:kotlin-stdlib-jdk8"
        const val KSP = "com.google.devtools.ksp:symbol-processing-api:${Versions.KSP}"
    }

    object Database {
        const val H2 = "com.h2database:h2"
        const val MYSQL = "mysql:mysql-connector-java"
        const val MARIADB = "org.mariadb.jdbc:mariadb-java-client"
    }

    const val JACKSON_MODULE_KOTLIN = "com.fasterxml.jackson.module:jackson-module-kotlin"
}

object Projects {
    const val APP_API = ":sandbox-app-api"
    const val APP_BATCH = ":sandbox-app-batch"
    const val APP_SERVICE = ":sandbox-app-service"
    const val CORE_WEB = ":sandbox-core-web"
    const val DOMAIN = ":sandbox-domain"

    object Modules {
        const val SANDBOX_AWS_S3 = ":modules:sandbox-aws-s3"
        const val SANDBOX_OPEN_FEIGN = ":modules:sandbox-open-feign"
        const val SANDBOX_WEB_CLIENT = ":modules:sandbox-web-client"
    }

    object Clients {
        const val SANDBOX_API = ":clients:sandbox-api-client"
    }

    val SPRING_PROJECTS = listOf(
        APP_API,
        APP_BATCH,
        APP_SERVICE,
        CORE_WEB,
        DOMAIN,
        Modules.SANDBOX_AWS_S3,
        Modules.SANDBOX_OPEN_FEIGN,
        Modules.SANDBOX_WEB_CLIENT,
        Clients.SANDBOX_API,
    )
}
