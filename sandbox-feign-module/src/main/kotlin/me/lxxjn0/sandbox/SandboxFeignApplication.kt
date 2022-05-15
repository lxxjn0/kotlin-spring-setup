package me.lxxjn0.sandbox

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SandboxFeignApplication

fun main(args: Array<String>) {
    runApplication<SandboxFeignApplication>(*args)
}
