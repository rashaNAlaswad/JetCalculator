package com.rns.jetcalculator.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rns.jetcalculator.ui.theme.JetCalculatorTheme

@Composable
fun ButtonComponent(
    text: String,
    color: Color,
    onClicked: () -> Unit,
    modifier: Modifier = Modifier,
) {

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .clip(MaterialTheme.shapes.large)
            .background(color)
            .clickable { onClicked() }
            .then(modifier)
    ) {

        Text(
            text = text,
            style = MaterialTheme.typography.displaySmall,
            color = Color.White
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ButtonComponentPreview() {
    JetCalculatorTheme {
        ButtonComponent(
            text = "1",
            color = MaterialTheme.colorScheme.primary,
            onClicked = {},
            modifier = Modifier.size(50.dp)
        )
    }
}