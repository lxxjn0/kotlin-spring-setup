import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    kotlin(Plugins.SPRING)

    id(Plugins.SPRING_BOOT)
}

tasks.getByName<Jar>("jar") {
    enabled = true
}

tasks.getByName<BootJar>("bootJar") {
    enabled = false
}
