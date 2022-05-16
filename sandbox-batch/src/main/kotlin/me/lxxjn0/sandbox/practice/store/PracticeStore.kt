package me.lxxjn0.sandbox.practice.store

import org.springframework.batch.core.configuration.annotation.JobScope
import org.springframework.stereotype.Component

@JobScope
@Component
class PracticeStore(val store: MutableList<String> = mutableListOf()) {
    fun add(data: List<String>) = store.addAll(data)
}
