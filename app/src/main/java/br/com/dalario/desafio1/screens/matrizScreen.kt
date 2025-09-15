package br.com.dalario.desafio1.screens

import android.R
import androidx.compose.animation.Animatable
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.dalario.desafio1.calculos.corpomatriz
import br.com.dalario.desafio1.calculos.negcorpomatriz

@Composable
fun matrizScreen(navController: NavController) {

    val listaRecebida = navController.previousBackStackEntry
        ?.savedStateHandle?.get<MutableList<Char>>("listaChars") ?: mutableListOf()

    val corpomatrizState = remember {
        mutableStateOf(corpomatriz(listaRecebida.size))
    }

    val negcorpomatrizState = remember {
        mutableStateOf(value = negcorpomatriz(listaRecebida.size))
    }

    Column(modifier = Modifier.fillMaxSize()) {
        Spacer(modifier = Modifier.padding(top = 30.dp))
        IconButton(
            //Botão de voltar
            onClick = {
                navController.navigate("verificacao")
            },
            modifier = Modifier.size(120.dp, 40.dp),

            ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.border(
                    2.dp,
                    color = Color.Black,
                    shape = RoundedCornerShape(20.dp)
                )
                    .background(
                        color = Color(0xFF60B1C5),
                        shape = RoundedCornerShape(20.dp),

                        ).size(90.dp, 30.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowLeft,
                    contentDescription = "Voltar",
                )
                Text(
                    "Voltar   ",
                    textAlign = TextAlign.Center,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
            }
        } //Fim botão de voltar
        Spacer(modifier = Modifier.padding(5.dp))
        Card(shape = RoundedCornerShape(0.dp)) {
            Box(){
                Column(Modifier
                    .verticalScroll(state = rememberScrollState())
                    .horizontalScroll(state = rememberScrollState())) {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                    ) {
                        for (letra in listaRecebida) {
                            titulomatriz("${letra}")
                        }
                        for (letra in listaRecebida) {
                            titulomatriz("¬${letra}")
                        }
                    }
                    Row() {
                        Column() {
                            for (linha in corpomatrizState.value) {
                                Row(horizontalArrangement = Arrangement.Center) {
                                    for (valor in linha) {
                                        Card(
                                            shape = RoundedCornerShape(0.dp),
                                            modifier = Modifier.size(95.dp, 40.dp),
                                            border = BorderStroke(1.dp, Color(0xFF60B1C5))
                                        ) {
                                            Box(
                                                contentAlignment = Alignment.Center,
                                                modifier = Modifier.fillMaxSize()
                                            ) {
                                                Text(
                                                    text = valor.toString(),
                                                    textAlign = TextAlign.Center
                                                )
                                            }
                                        }
                                    }
                                }
                            }

                        }
                        Column {
                        for (linha in negcorpomatrizState.value) {
                            Row() {
                                for (valor in linha) {
                                    Card(
                                        shape = RoundedCornerShape(0.dp),
                                        modifier = Modifier.size(95.dp, 40.dp),
                                        border = BorderStroke(1.dp, Color(0xFF60B1C5))
                                    ) {
                                        Box(
                                            contentAlignment = Alignment.Center,
                                            modifier = Modifier.fillMaxSize()
                                        ) {
                                            Text(valor.toString())
                                        }
                                    }
                                }
                            }
                        }
                    }
                } //ROW menor
                } //COLUMN maior
        }// BOX
    }
    }
}

@Composable
fun titulomatriz(valormatriz: String) {
    Card(
        modifier = Modifier.size(95.dp, 40.dp),
        shape = RoundedCornerShape(0.dp),
        border = BorderStroke(3.dp, color = Color(0xFFFFFFFF))
    ){
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

                Text("${valormatriz}", textAlign = TextAlign.Center)

        }

    }
}



