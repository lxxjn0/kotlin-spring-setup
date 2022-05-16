package me.lxxjn0.sandbox.practice.job

import me.lxxjn0.sandbox.practice.store.PracticeStore
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory
import org.springframework.batch.core.configuration.annotation.JobScope
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory
import org.springframework.batch.core.configuration.annotation.StepScope
import org.springframework.batch.item.ItemProcessor
import org.springframework.batch.item.ItemWriter
import org.springframework.batch.item.support.ListItemReader
import org.springframework.batch.repeat.RepeatStatus
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.stream.IntStream

@Configuration
class PracticeBatch(
    val jobBuilderFactory: JobBuilderFactory,
    val stepBuilderFactory: StepBuilderFactory,
    val jobParameter: PracticeJobParameter,
    val store: PracticeStore,
) {
    @Bean(JOB_NAME)
    fun job() = jobBuilderFactory.get(JOB_NAME)
        .start(practiceStep())
        .next(printDataStep())
        .build()

    @JobScope
    @Bean("${JOB_NAME}_practiceStep")
    fun practiceStep() = stepBuilderFactory.get("${JOB_NAME}_practiceStep")
        .chunk<String, String>(jobParameter.chunkSize)
        .reader(practiceReader())
        .processor(practiceProcessor())
        .writer(practiceWriter())
        .build()

    @StepScope
    @Bean("${JOB_NAME}_practiceReader")
    fun practiceReader() = IntStream.range(0, 100)
        .mapToObj { it.toString() }
        .toList()
        .let { ListItemReader(it) }

    @StepScope
    @Bean("${JOB_NAME}_practiceProcessor")
    fun practiceProcessor() = ItemProcessor<String, String> { "data_${it}" }

    @StepScope
    @Bean("${JOB_NAME}_practiceWriter")
    fun practiceWriter() = ItemWriter<String> { store.add(it) }

    @JobScope
    @Bean("${JOB_NAME}_printDataStep")
    fun printDataStep() = stepBuilderFactory.get("${JOB_NAME}_printDataStep")
        .tasklet { _, _ ->
            println("[PracticeBatch] target: ${jobParameter.target}")
            store.store.forEach { println(it) }

            RepeatStatus.FINISHED
        }
        .build()

    companion object {
        const val JOB_NAME = "PracticeBatch"
    }
}
