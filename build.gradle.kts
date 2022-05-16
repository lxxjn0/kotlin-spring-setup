import org.jetbrains.kotlin.gradle.plugin.KotlinPlatformJvmPlugin
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    kotlin(Plugins.JVM) version Versions.KOTLIN
    kotlin(Plugins.SPRING) version Versions.KOTLIN apply false
    kotlin(Plugins.JPA) version Versions.KOTLIN apply false

    id(Plugins.SPRING_BOOT) version Versions.SPRING_BOOT apply false
    id(Plugins.SPRING_DEPENDENCY_MANAGEMENT) version Versions.SPRING_DEPENDENCY_MANAGEMENT apply false
    id(Plugins.KTLINT) version Versions.KTLINT
    id(Plugins.KTLINT_IDEA) version Versions.KTLINT
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

allprojects {
    apply {
        plugin<JavaLibraryPlugin>()
        plugin<KotlinPlatformJvmPlugin>()
        plugin(Plugins.IDEA)
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
        plugin<JavaLibraryPlugin>()
        plugin<KotlinPlatformJvmPlugin>()
        plugin(Plugins.SPRING_BOOT)
        plugin(Plugins.SPRING_DEPENDENCY_MANAGEMENT)
        plugin(Plugins.IDEA)
    }

    dependencies {
        implementation(Dependencies.SpringBoot.STARTER_WEB)
        implementation(Dependencies.SpringBoot.STARTER_DATA_JPA)

        implementation(Dependencies.Kotlin.REFLECT)
//        implementation(Dependencies.Kotlin.STDLIB_JDK8)

        implementation(Dependencies.JACKSON_MODULE_KOTLIN)

        annotationProcessor(Dependencies.SpringBoot.CONFIGURATION_PROCESSOR)

        testImplementation(Dependencies.SpringBoot.STARTER_TEST)

        runtimeOnly(Dependencies.Database.H2)
    }

    tasks.getByName<Jar>("jar") {
        enabled = false
    }

    tasks.getByName<BootJar>("bootJar") {
        enabled = true
    }
}
