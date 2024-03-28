package com.example.composecalculator


/** calculator state **/
data class CalculatorState(
    val number1: String = "",
    val number2: String = "",
    val operation: CalculatorOperation? = null,
    val number3:String= ""
)