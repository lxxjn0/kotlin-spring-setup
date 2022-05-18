package me.lxxjn0.sandbox.persistance

import me.lxxjn0.sandbox.domain.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long>
