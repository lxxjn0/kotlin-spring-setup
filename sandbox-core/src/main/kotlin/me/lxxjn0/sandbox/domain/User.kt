package me.lxxjn0.sandbox.domain

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "users")
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
