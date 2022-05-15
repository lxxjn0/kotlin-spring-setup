package me.lxxjn0.sandbox

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SandboxWebApplication

fun main(args: Array<String>) {
    runApplication<SandboxWebApplication>(*args)
}
