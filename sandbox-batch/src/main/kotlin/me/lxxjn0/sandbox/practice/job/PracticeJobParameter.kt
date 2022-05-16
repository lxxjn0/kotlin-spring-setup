package me.lxxjn0.sandbox.practice.job

import org.springframework.batch.core.configuration.annotation.JobScope
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import kotlin.properties.Delegates

@JobScope
@Component
class PracticeJobParameter {
    @set:Value("#{jobParameters['chunkSize']}")
    var chunkSize by Delegates.notNull<Int>()

    @Value("#{jobParameters['target']}")
    lateinit var target: String
}
