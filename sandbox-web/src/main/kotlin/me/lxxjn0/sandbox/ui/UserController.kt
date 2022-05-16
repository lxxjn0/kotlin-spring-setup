package me.lxxjn0.sandbox.ui

import me.lxxjn0.sandbox.annotation.Slf4j
import me.lxxjn0.sandbox.annotation.Slf4j.Companion.log
import me.lxxjn0.sandbox.application.UserService
import me.lxxjn0.sandbox.ui.dto.UserCreateRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI

@Slf4j
@RestController
class UserController(private val userService: UserService) {

    @GetMapping(value = ["/users/{id}"])
    @ResponseStatus(HttpStatus.OK)
    fun showById(@PathVariable id: Long) =
        userService.findById(id)
            .also { log.info("[UserController.showById] 유저 조회 - id: ${it.id}, name: ${it.name}, age: ${it.age}") }

    @PostMapping(value = ["/users"])
    fun create(@RequestBody request: UserCreateRequest): ResponseEntity<Unit> {
        log.info("[UserController.create] 유저 생성 요청 - request: ${request}")

        return userService.save(request)
            .also { log.info("[UserController.create] 유저 생성 완료 - id: ${it.id}, name: ${it.name}, age: ${it.age}") }
            .let { ResponseEntity.created(URI.create("/users/${it.id}")).build() }
    }
}
