package me.lxxjn0.sandbox.application

import me.lxxjn0.sandbox.domain.User
import me.lxxjn0.sandbox.persistance.UserRepository
import me.lxxjn0.sandbox.ui.dto.UserCreateRequest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class UserService(private val repository: UserRepository) {
    fun findById(id: Long) =
        repository.findByIdOrNull(id)
            ?.toUser()
            ?: throw IllegalArgumentException("${id}에 해당하는 유저가 존재하지 않습니다.")

    fun save(request: UserCreateRequest): User {
        return repository.save(request.toUser())
            .toUser()
    }
}
