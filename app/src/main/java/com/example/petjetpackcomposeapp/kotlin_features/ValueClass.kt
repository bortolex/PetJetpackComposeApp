package com.example.petjetpackcomposeapp.kotlin_features

@JvmInline
value class Email(val value: String) {
    fun printEmail(email: Email) {
        println(email.value)
    }
}