package me.lxxjn0.sandbox.config

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@EnableBatchProcessing
@ComponentScan(basePackages = ["me.lxxjn0.sandbox"])
@Configuration
class SandboxBatchConfiguration
