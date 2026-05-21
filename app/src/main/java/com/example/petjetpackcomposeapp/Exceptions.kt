package com.example.petjetpackcomposeapp

import com.example.petjetpackcomposeapp.counterFeature.CounterRepository

data class InvalidCounterValueException(
    val value: String,
    val minValue: Int = CounterRepository.MIN_VALUE,
    val maxValue: Int = CounterRepository.MAX_VALUE,
) : Exception() {
    constructor(value: Int) : this(value.toString())
}