package com.example.composecalculator



/** different calculator actions **/
sealed class CalculatorAction {
    data class Number(val number: Int): CalculatorAction()
    data object Clear: CalculatorAction()
    data object Delete: CalculatorAction()
    data class Operation(val operation: CalculatorOperation): CalculatorAction()
    data object Calculate: CalculatorAction()
    data object Decimal: CalculatorAction()
}