package me.lxxjn0.sandbox.persistance

import me.lxxjn0.sandbox.domain.Nickname
import org.springframework.data.jpa.repository.JpaRepository

interface NicknameRepository : JpaRepository<Nickname, Long> {
    fun findByUserName(userName: String): Nickname?
}
