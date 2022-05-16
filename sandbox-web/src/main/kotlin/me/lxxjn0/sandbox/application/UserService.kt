package me.lxxjn0.sandbox.application

import me.lxxjn0.sandbox.annotation.Slf4j
import me.lxxjn0.sandbox.annotation.Slf4j.Companion.log
import me.lxxjn0.sandbox.domain.User
import me.lxxjn0.sandbox.persistance.UserRepository
import me.lxxjn0.sandbox.ui.dto.UserCreateRequest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Slf4j
@Service
class UserService(private val repository: UserRepository) {
    fun findById(id: Long) =
        repository.findByIdOrNull(id)
            ?.also { log.info("[UserService.findById] 유저 조회 - id: ${it.id}, name: ${it.name}, age: ${it.age}") }
            ?: throw IllegalArgumentException("${id}에 해당하는 유저가 존재하지 않습니다.")

    fun save(request: UserCreateRequest): User =
        repository.save(request.toUser())
            .also { log.info("[UserService.findById] 유저 생성 - id: ${it.id}, name: ${it.name}, age: ${it.age}") }
}
