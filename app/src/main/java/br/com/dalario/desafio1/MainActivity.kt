package br.com.dalario.desafio1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.dalario.desafio1.screens.introducacaoScreen
import br.com.dalario.desafio1.screens.matrizScreen
import br.com.dalario.desafio1.screens.verificacaoScreen
import br.com.dalario.desafio1.ui.theme.Desafio1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Desafio1Theme {
                Surface(modifier = Modifier.fillMaxSize(), color = Color(0xFF435057)
                ){
                    val navController = rememberNavController()

                    NavHost(navController= navController, startDestination = "boasVindas"){
                        composable (route = "boasVindas") { introducacaoScreen(navController) }
                        composable (route = "verificacao") { verificacaoScreen(navController) }
                        composable (route = "matriz") { matrizScreen(navController) }
                    }
                }
            }
        }
    }
}

