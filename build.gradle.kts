import org.jetbrains.kotlin.gradle.plugin.KotlinPlatformJvmPlugin
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin(me.lxxjn0.sandbox.constant.Plugins.JVM) version me.lxxjn0.sandbox.constant.Versions.KOTLIN
    kotlin(me.lxxjn0.sandbox.constant.Plugins.SPRING) version me.lxxjn0.sandbox.constant.Versions.KOTLIN
    kotlin(me.lxxjn0.sandbox.constant.Plugins.JPA) version me.lxxjn0.sandbox.constant.Versions.KOTLIN

    id(me.lxxjn0.sandbox.constant.Plugins.SPRING_BOOT) version me.lxxjn0.sandbox.constant.Versions.SPRING_BOOT
    id(me.lxxjn0.sandbox.constant.Plugins.SPRING_DEPENDENCY_MANAGEMENT) version me.lxxjn0.sandbox.constant.Versions.SPRING_DEPENDENCY_MANAGEMENT
    id(me.lxxjn0.sandbox.constant.Plugins.KTLINT) version me.lxxjn0.sandbox.constant.Versions.KTLINT
    id(me.lxxjn0.sandbox.constant.Plugins.KTLINT_IDEA) version me.lxxjn0.sandbox.constant.Versions.KTLINT
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

allprojects {
    repositories {
        mavenCentral()
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

configure(allprojects) {
    apply {
        plugin<JavaLibraryPlugin>()
        plugin<KotlinPlatformJvmPlugin>()
        plugin(me.lxxjn0.sandbox.constant.Plugins.SPRING_BOOT)
        plugin(me.lxxjn0.sandbox.constant.Plugins.SPRING_DEPENDENCY_MANAGEMENT)
    }

    configurations {
        compileOnly {
            extendsFrom(configurations.annotationProcessor.get())
        }
    }

    dependencies {
        implementation(me.lxxjn0.sandbox.constant.Dependencies.SpringBoot.STARTER_WEB)
        implementation(me.lxxjn0.sandbox.constant.Dependencies.SpringBoot.STARTER_DATA_JPA)

        implementation(me.lxxjn0.sandbox.constant.Dependencies.Kotlin.REFLECT)
        implementation(me.lxxjn0.sandbox.constant.Dependencies.Kotlin.STDLIB_JDK8)

        implementation(me.lxxjn0.sandbox.constant.Dependencies.JACKSON_MODULE_KOTLIN)

        annotationProcessor(me.lxxjn0.sandbox.constant.Dependencies.SpringBoot.CONFIGURATION_PROCESSOR)

        testImplementation(me.lxxjn0.sandbox.constant.Dependencies.SpringBoot.STARTER_TEST)
    }
}
