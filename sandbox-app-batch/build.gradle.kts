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
    implementation(project(Projects.DOMAIN))
    implementation(project(Projects.CORE_WEB))

    implementation(Dependencies.SpringBoot.Starter.BATCH)
}
