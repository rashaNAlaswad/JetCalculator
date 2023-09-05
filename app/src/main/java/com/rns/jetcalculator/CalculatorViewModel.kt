package com.rns.jetcalculator

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.rns.jetcalculator.data.ActionType
import com.rns.jetcalculator.data.CalculatorState
import com.rns.jetcalculator.data.Operations
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.map
import kotlin.math.pow

class CalculatorViewModel : ViewModel() {
    var state by mutableStateOf(CalculatorState())

    fun onAction(action: ActionType) {
        when (action) {
            is ActionType.Delete -> delete()
            is ActionType.Clear -> clear()
            is ActionType.Number -> enterNumber(action.number)
            is ActionType.Decimal -> addDecimal()
            is ActionType.Operation -> addOperation(action.operation)
            is ActionType.Calculate -> performCalculate()
        }
    }

    private fun performCalculate() {
        if (state.firstNumber.isNotEmpty() &&
            state.secondNumber.isNotEmpty() &&
            state.operation != null
        ) {
            val num1 = state.firstNumber.toDouble()
            val num2 = state.secondNumber.toDouble()

            val result = when (state.operation) {
                Operations.Add -> num1.plus(num2)
                Operations.Divide -> {
                    if (num2 != 0.0) {
                        num1.div(num2)
                    } else {
                        ""
                    }
                }

                Operations.Multiply -> num1.times(num2)
                Operations.Subtract -> num1.minus(num2)
                Operations.Power -> num1.pow(num2)
                Operations.Mod -> num1.mod(num2)
                else -> null
            }
            state = state.copy(
                firstNumber = result.toString(),
                operation = null,
                secondNumber = ""
            )
        }
    }

    private fun addOperation(operation: Operations) {
        if (state.firstNumber.isNotEmpty() &&
            state.operation == null
        ) {
            state = state.copy(operation = operation)
        }
    }

    private fun enterNumber(number: Int) {
        if (state.operation == null) {
            state =
                state.copy(firstNumber = state.firstNumber + number)
            return
        } else {
            state =
                state.copy(secondNumber = state.secondNumber + number)
        }
    }

    private fun delete() {
        when {
            state.secondNumber.isNotBlank() -> state = state.copy(
                secondNumber = state.secondNumber.dropLast(1)
            )
            state.operation != null -> state = state.copy(
                operation = null
            )
            state.firstNumber.isNotBlank() -> state = state.copy(
                firstNumber = state.firstNumber.dropLast(1)
            )
        }
    }

    private fun clear() {
        state = state.copy(
            firstNumber = "",
            operation = null,
            secondNumber = ""
        )
    }

    private fun addDecimal() {
        if (state.operation == null &&
            !state.firstNumber.contains(".")
        ) {
            state = state.copy(
                firstNumber = state.firstNumber + "."
            )
        } else if (
            state.operation != null &&
            state.secondNumber.isNotBlank()
            && !state.secondNumber.contains(".")
        ) {
            state = state.copy(
                secondNumber = state.secondNumber + "."
            )
        }
    }

}