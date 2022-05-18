package me.lxxjn0.sandbox.domain

import javax.persistence.*

@Entity
@Table(name = "nickname")
class Nickname(
    userName: String,
    nickname: String,
    id: Long = 0,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nickname_id")
    val id: Long = id

    @Column(name = "user_name")
    val userName: String = userName

    @Column(name = "nickname")
    val nickname: String = nickname
}
