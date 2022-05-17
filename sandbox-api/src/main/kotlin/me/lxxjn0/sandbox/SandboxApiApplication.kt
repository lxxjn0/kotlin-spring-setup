package me.lxxjn0.sandbox

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = ["me.lxxjn0.sandbox"])
class SandboxApiApplication

fun main(vararg args: String) {
    runApplication<SandboxApiApplication>(*args)
}
