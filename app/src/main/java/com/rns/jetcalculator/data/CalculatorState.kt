package com.rns.jetcalculator.data

data class CalculatorState(
    val firstNumber: String = "",
    val secondNumber: String = "",
    val operation: Operations? = null,
)
