import org.jetbrains.kotlin.gradle.plugin.KotlinPlatformJvmPlugin
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    kotlin(Plugins.JVM) version Versions.KOTLIN
    kotlin(Plugins.SPRING) version Versions.KOTLIN apply false
    kotlin(Plugins.JPA) version Versions.KOTLIN apply false

    id(Plugins.KSP) version Versions.KSP
    id(Plugins.SPRING_BOOT) version Versions.SPRING_BOOT apply false
    id(Plugins.SPRING_DEPENDENCY_MANAGEMENT) version Versions.SPRING_DEPENDENCY_MANAGEMENT apply false
    id(Plugins.KTLINT) version Versions.KTLINT
    id(Plugins.KTLINT_IDEA) version Versions.KTLINT
}

buildscript {
    dependencies {
        classpath(kotlin(Plugins.GRADLE_PLUGIN, Versions.KOTLIN))
    }
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

allprojects {
    apply {
        plugin<JavaLibraryPlugin>()
        plugin<KotlinPlatformJvmPlugin>()
    }

    repositories {
        mavenCentral()
    }

    configurations {
        compileOnly {
            extendsFrom(configurations.annotationProcessor.get())
        }
    }
}

subprojects {
    apply {
        plugin<JavaLibraryPlugin>()
        plugin<KotlinPlatformJvmPlugin>()
        plugin(Plugins.KSP)
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "17"
        }
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }
}

configure(Projects.SPRING_PROJECTS.map { project(it) }) {
    apply {
        plugin(Plugins.KSP)
        plugin(Plugins.SPRING_BOOT)
        plugin(Plugins.SPRING_DEPENDENCY_MANAGEMENT)
    }

    dependencies {
        implementation(Dependencies.SpringBoot.Starter.WEB)
        implementation(Dependencies.SpringBoot.Starter.DATA_JPA)
        implementation(Dependencies.SpringBoot.Starter.LOG4J2)

        implementation(Dependencies.Kotlin.REFLECT)
        implementation(Dependencies.Kotlin.STDLIB_JDK8)
        implementation(Dependencies.Kotlin.KSP)

        implementation(Dependencies.JACKSON_MODULE_KOTLIN)
        implementation(Dependencies.Database.MARIADB)

        ksp(Dependencies.SpringBoot.CONFIGURATION_PROCESSOR)

        testImplementation(Dependencies.SpringBoot.Starter.TEST)
    }

    configurations {
        all {
            exclude(Plugins.SPRING_BOOT, "spring-boot-starter-logging")
        }
    }

    tasks.getByName<Jar>("jar") {
        enabled = false
    }

    tasks.getByName<BootJar>("bootJar") {
        enabled = true
    }
}
