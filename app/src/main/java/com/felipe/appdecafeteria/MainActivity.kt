package com.felipe.appdecafeteria
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.felipe.appdecafeteria.screens.Carrinho
import com.felipe.appdecafeteria.screens.Home
import com.felipe.appdecafeteria.screens.Pagamento
import com.felipe.appdecafeteria.viewmodel.CarrinhoViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val navController = rememberNavController()
            val carrinhoViewModel: CarrinhoViewModel = hiltViewModel()

            NavHost(
                startDestination = "Home",
                navController = navController
            ){
                composable(
                    route = "Home"
                ){
                    Home(navController = navController, carrinhoViewModel = carrinhoViewModel)
                }

                composable(
                    route = "Carrinho"
                ){
                    Carrinho(navController = navController,carrinhoViewModel = carrinhoViewModel)
                }

                composable(
                    route = "Pagamento"
                ){
                    Pagamento(carrinhoViewModel = carrinhoViewModel)
                }
            }

        }
    }
}
