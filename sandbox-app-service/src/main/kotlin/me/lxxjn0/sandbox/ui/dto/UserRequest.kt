package me.lxxjn0.sandbox.ui.dto

import me.lxxjn0.sandbox.domain.User

data class UserCreateRequest(val name: String, val age: Long) {
    fun toUser() = User(name, age)
}
