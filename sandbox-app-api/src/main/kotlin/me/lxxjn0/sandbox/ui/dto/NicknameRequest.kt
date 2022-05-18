package me.lxxjn0.sandbox.ui.dto

import me.lxxjn0.sandbox.domain.Nickname

data class NicknameCreateRequest(val userName: String, val nickname: String) {
    fun toNickname() = Nickname(userName, nickname)
}
