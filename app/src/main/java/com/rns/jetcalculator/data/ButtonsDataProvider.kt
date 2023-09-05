package com.rns.jetcalculator.data

object ButtonsDataProvider {
    val buttons = listOf(
        ActionType.Clear,
        ActionType.Operation(Operations.Power),
        ActionType.Operation(Operations.Mod),
        ActionType.Operation(Operations.Divide),
        ActionType.Number(7),
        ActionType.Number(8),
        ActionType.Number(9),
        ActionType.Operation(Operations.Multiply),
        ActionType.Number(4),
        ActionType.Number(5),
        ActionType.Number(6),
        ActionType.Operation(Operations.Subtract),
        ActionType.Number(3),
        ActionType.Number(2),
        ActionType.Number(1),
        ActionType.Operation(Operations.Add),
        ActionType.Number(0),
        ActionType.Decimal,
        ActionType.Delete,
        ActionType.Calculate,
    )
}