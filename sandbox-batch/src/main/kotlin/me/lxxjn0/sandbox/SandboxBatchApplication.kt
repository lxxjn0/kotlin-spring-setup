package me.lxxjn0.sandbox

import me.lxxjn0.sandbox.config.SandboxBatchConfiguration
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Import
import kotlin.system.exitProcess

@SpringBootApplication(scanBasePackages = ["me.lxxjn0.sandbox"])
@Import(SandboxBatchConfiguration::class)
class SandboxBatchApplication

fun main(vararg args: String) {
    exitProcess(SpringApplication.exit(runApplication<SandboxBatchApplication>(*args)))
}
