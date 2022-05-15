package me.lxxjn0.sandbox

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SandboxCoreApplication

fun main(args: Array<String>) {
    runApplication<SandboxCoreApplication>(*args)
}
