package com.felipe.appdecafeteria.screens

import android.icu.text.DecimalFormat
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.felipe.appdecafeteria.ui.theme.MyTheme
import com.felipe.appdecafeteria.viewmodel.CarrinhoViewModel

@Composable
fun Pagamento(
    carrinhoViewModel: CarrinhoViewModel
){

    val total = carrinhoViewModel.calcularTotal()

    MyTheme(
        theme = "1"
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = DecimalFormat.getCurrencyInstance().format(total),
                color = MaterialTheme.colorScheme.onPrimary,
                fontSize = 30.sp
            )
        }
    }


}