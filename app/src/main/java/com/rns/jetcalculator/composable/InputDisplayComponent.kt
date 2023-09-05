package com.rns.jetcalculator.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.rns.jetcalculator.CalculatorViewModel
import com.rns.jetcalculator.ui.theme.JetCalculatorTheme

@Composable
internal fun InputDisplayComponent(
    state: String,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = state,
            textAlign = TextAlign.End,
            style = MaterialTheme.typography.displayLarge,
            color = Color.Blue,
            maxLines = 1,
            modifier = Modifier.fillMaxWidth()
        )
    }
}