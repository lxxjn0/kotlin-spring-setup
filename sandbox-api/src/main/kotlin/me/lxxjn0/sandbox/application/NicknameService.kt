package me.lxxjn0.sandbox.application

import me.lxxjn0.sandbox.annotation.Slf4j
import me.lxxjn0.sandbox.annotation.Slf4j.Companion.log
import me.lxxjn0.sandbox.persistance.NicknameRepository
import me.lxxjn0.sandbox.ui.dto.NicknameCreateRequest
import org.springframework.stereotype.Service

@Slf4j
@Service
class NicknameService(private val repository: NicknameRepository) {
    fun findByUserName(userName: String) =
        repository.findByUserName(userName)
            ?.also { log.info("[NicknameService] 닉네임 조회 - id: ${it.id}, userName: ${it.userName}, nickname: ${it.nickname}") }
            ?: throw IllegalArgumentException("${userName}에 해당하는 닉네임이 존재하지 않습니다.")

    fun save(request: NicknameCreateRequest) =
        repository.save(request.toNickname())
            .also { log.info("[NicknameService] 닉네임 생성 - id: ${it.id}, userName: ${it.userName}, nickname: ${it.nickname}") }
}
