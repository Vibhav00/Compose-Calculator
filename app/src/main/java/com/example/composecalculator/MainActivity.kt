package com.example.composecalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel


import com.example.composecalculator.ui.theme.ComposeCalculatorTheme
import com.example.composecalculator.ui.theme.LightBlue
import com.example.composecalculator.ui.theme.LightGray
import com.example.composecalculator.ui.theme.LightGrey2
import com.example.composecalculator.ui.theme.MediumBlue
import com.example.composecalculator.ui.theme.MediumGray
import com.example.composecalculator.ui.theme.Orange

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeCalculatorTheme {
              val viewModel = viewModel<CalculatorViewModel>()
                val state=viewModel.state
              CalculatorLayout(viewModel = viewModel, state = state)
            }
        }
    }
}


@Composable
fun CalculatorLayout(viewModel: CalculatorViewModel , state: CalculatorState){
    val buttonSpacing = 8.dp
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MediumBlue)
            .padding(16.dp)
    )
    {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            verticalArrangement = Arrangement.spacedBy(buttonSpacing),
        ) {


            Column(modifier =  Modifier.fillMaxWidth()) {



                Text(
                    text = state.number3,
                    textAlign = TextAlign.End,
                    modifier = Modifier
                        .fillMaxWidth(),
                    fontWeight = FontWeight.Light,
                    fontSize = 60.sp,
                    color = LightGrey2,
                    maxLines = 1,

                    )

                Text(
                    text = state.number1 + (state.operation?.symbol ?: "") + state.number2,
                    textAlign = TextAlign.End,
                    modifier = Modifier
                        .fillMaxWidth()
                        ,
                    fontWeight = FontWeight.Light,
                    fontSize = 60.sp,
                    color = Color.White,
                    maxLines = 1,

                    )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalculatorButton(
                    symbol = "AC",
                    color = LightBlue,
                    modifier = Modifier
                        .aspectRatio(2f)
                        .weight(2f)
                ) {
                    viewModel.onAction(CalculatorAction.Clear)
                }
                CalculatorButton(
                    symbol = "Del",
                    color = LightBlue,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                    viewModel.onAction(CalculatorAction.Delete)
                }
                CalculatorButton(
                    symbol = "/",
                    color = Orange,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                    viewModel.onAction(CalculatorAction.Operation(CalculatorOperation.Divide))
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalculatorButton(
                    symbol = "7",
                    color = MediumGray,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                    viewModel.onAction(CalculatorAction.Number(7))
                }
                CalculatorButton(
                    symbol = "8",
                    color = MediumGray,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                    viewModel.onAction(CalculatorAction.Number(8))
                }
                CalculatorButton(
                    symbol = "9",
                    color = MediumGray,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                    viewModel.onAction(CalculatorAction.Number(9))
                }
                CalculatorButton(
                    symbol = "x",
                    color = Orange,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                    viewModel.onAction(CalculatorAction.Operation(CalculatorOperation.Multiply))
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalculatorButton(
                    symbol = "4",
                    color = MediumGray,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                    viewModel.onAction(CalculatorAction.Number(4))
                }
                CalculatorButton(
                    symbol = "5",
                    color = MediumGray,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                    viewModel.onAction(CalculatorAction.Number(5))
                }
                CalculatorButton(
                    symbol = "6",
                    color = MediumGray,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                    viewModel.onAction(CalculatorAction.Number(6))
                }
                CalculatorButton(
                    symbol = "-",
                    color = Orange,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                    viewModel.onAction(CalculatorAction.Operation(CalculatorOperation.Subtract))
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalculatorButton(
                    symbol = "1",
                    color = MediumGray,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                    viewModel.onAction(CalculatorAction.Number(1))
                }
                CalculatorButton(
                    symbol = "2",
                    color = MediumGray,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                    viewModel.onAction(CalculatorAction.Number(2))
                }
                CalculatorButton(
                    symbol = "3",
                    color = MediumGray,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                    viewModel.onAction(CalculatorAction.Number(3))
                }
                CalculatorButton(
                    symbol = "+",
                    color = Orange,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                    viewModel.onAction(CalculatorAction.Operation(CalculatorOperation.Add))
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalculatorButton(
                    symbol = "0",
                    color = MediumGray,
                    modifier = Modifier
                        .aspectRatio(2f)
                        .weight(2f)
                ) {
                    viewModel.onAction(CalculatorAction.Number(0))
                }
                CalculatorButton(
                    symbol = ".",
                    color = MediumGray,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                    viewModel.onAction(CalculatorAction.Decimal)
                }
                CalculatorButton(
                    symbol = "=",
                    color = Orange,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                    viewModel.onAction(CalculatorAction.Calculate)
                }
            }
        }
    }

}




/** preview the layout  **/
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    val viewModel = viewModel<CalculatorViewModel>()
    val state=viewModel.state
    ComposeCalculatorTheme {
        CalculatorLayout(viewModel = viewModel, state = state)
    }
}