package com.rns.jetcalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.rns.jetcalculator.composable.ButtonComponent
import com.rns.jetcalculator.composable.InputDisplayComponent
import com.rns.jetcalculator.data.ActionType
import com.rns.jetcalculator.data.ButtonsDataProvider
import com.rns.jetcalculator.ui.theme.JetCalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetCalculatorTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val viewModel = viewModel<CalculatorViewModel>()
                    val state = viewModel.state
                    CalculatorScreen(
                        state = state.firstNumber + (state.operation?.symbol
                            ?: "") + state.secondNumber
                    ) {
                        viewModel.onAction(it)
                    }
                }
            }
        }
    }
}

@Composable
fun CalculatorScreen(state: String, action: (ActionType) -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomEnd),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            InputDisplayComponent(state = state)
            Spacer(modifier = Modifier.height(24.dp))
            ButtonsGridLayout(action)
        }
    }
}

@Composable
fun ButtonsGridLayout(action: (ActionType) -> Unit) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(4),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(ButtonsDataProvider.buttons) {
            ButtonComponent(text = it.text,
                color = it.color,
                modifier = Modifier
                    .aspectRatio(1f),
                onClicked = { action(it) })
        }
    }
}


@Preview(
    showBackground = true,
)
@Composable
fun GreetingPreview() {
    JetCalculatorTheme {
        CalculatorScreen(state = "", action = {})
    }
}

