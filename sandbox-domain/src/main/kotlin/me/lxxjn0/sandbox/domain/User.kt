package me.lxxjn0.sandbox.domain

import javax.persistence.*

@Entity
@Table(name = "user")
class User(
    name: String,
    age: Long,
    id: Long = 0,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    val id: Long = id

    @Column(name = "name")
    val name: String = name

    @Column(name = "age")
    val age: Long = age
}
