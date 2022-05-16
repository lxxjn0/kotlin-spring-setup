package me.lxxjn0.sandbox.ui.dto

import me.lxxjn0.sandbox.persistance.UserEntity

data class UserCreateRequest(val name: String, val age: Long) {
    fun toUserEntity() = UserEntity(name, age)
}
