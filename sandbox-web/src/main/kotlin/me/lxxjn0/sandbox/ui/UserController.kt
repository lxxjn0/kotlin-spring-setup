package me.lxxjn0.sandbox.ui

import me.lxxjn0.sandbox.application.UserService
import me.lxxjn0.sandbox.ui.dto.UserCreateRequest
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
class UserController(private val userService: UserService) {

    @GetMapping(value = ["/users/{id}"])
    @ResponseStatus(HttpStatus.OK)
    fun showById(@PathVariable id: Long) = userService.findById(id)

    @PostMapping(value = ["/users"])
    fun create(@RequestParam name: String, age: Long) = userService.save(UserCreateRequest(name, age))
}
