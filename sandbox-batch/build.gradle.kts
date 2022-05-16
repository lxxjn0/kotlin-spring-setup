import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    kotlin(Plugins.SPRING)
    kotlin(Plugins.JPA)

    id(Plugins.SPRING_BOOT)
}

tasks.getByName<Jar>("jar") {
    enabled = false
}

tasks.getByName<BootJar>("bootJar") {
    enabled = true
}

dependencies {
    implementation(project(Projects.SANDBOX_CORE))
    implementation(project(Projects.SANDBOX_COMMON))

    implementation(Dependencies.SpringBoot.STARTER_BATCH)
}
