package me.lxxjn0.sandbox.ui

import me.lxxjn0.sandbox.annotation.Slf4j
import me.lxxjn0.sandbox.annotation.Slf4j.Companion.log
import me.lxxjn0.sandbox.application.NicknameService
import me.lxxjn0.sandbox.ui.dto.NicknameCreateRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI

@Slf4j
@RestController
class NicknameController(private val nicknameService: NicknameService) {
    @GetMapping(value = ["/nicknames"])
    @ResponseStatus(HttpStatus.OK)
    fun showByUserName(@RequestParam userName: String) =
        nicknameService.findByUserName(userName)
            .also { log.info("[NicknameController.showByUserName] 닉네임 조회 - id: ${it.id}, userName: ${it.userName}, nickname: ${it.nickname}") }

    @PostMapping(value = ["/nicknames"])
    fun create(@RequestBody request: NicknameCreateRequest): ResponseEntity<Unit> {
        log.info("[NicknameController.create] 닉네임 생성 요청 - request: ${request}")

        return nicknameService.save(request)
            .also { log.info("[NicknameController.create] 닉네임 조회 - id: ${it.id}, userName: ${it.userName}, nickname: ${it.nickname}") }
            .let { ResponseEntity.created(URI.create("/nicknames/${it.id}")).build() }
    }
}
