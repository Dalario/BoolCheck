package br.com.dalario.desafio1.screens

import android.R
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.dalario.desafio1.calculos.criamatriz
import br.com.dalario.desafio1.calculos.verificacao
import java.nio.file.WatchEvent


@Composable
fun verificacaoScreen(navController: NavController) {
    var expressao = remember {
        mutableStateOf("P∧¬Q∨R∧S")
    }
    var estadoverificacao = remember {
        mutableStateOf(value = "")
    }
    var cordoestado = remember {
        mutableStateOf(value = Color.LightGray)
    }
    var matriz = remember {
        mutableStateOf(value = mutableListOf<Char>())
    }

    Column (modifier= Modifier.fillMaxSize()) {
        Spacer(modifier = Modifier.padding(top = 30.dp))
        IconButton(
            onClick = {
                navController.navigate("boasVindas")
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
        }
        Spacer(modifier = Modifier.padding(top = 10.dp))
        Column(
            modifier = Modifier
                .height(230.dp)
                .fillMaxWidth()
                .background(
                    color = Color(0xFF60B1C5),
                    shape = RoundedCornerShape(10.dp),
                )
                .border(
                    3.dp,
                    color = Color.Black,
                    shape = RoundedCornerShape(8.dp)
                ),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.padding(top = 10.dp))
            Text(
                "Por conveção, usar apenas letras maiúsculas (A,B,C...,Z) e adicionar os conectivos por meio dos botões abaixo",
                fontSize = 20.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(horizontal = 10.dp),
                textAlign = TextAlign.Justify
            )
            Spacer(modifier = Modifier.padding(top = 10.dp))
            OutlinedTextField(
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                modifier = Modifier.width(370.dp),
                label = {
                    Text("Insira a expressão lógica")
                },
                placeholder = {
                    Text("Ex: P→Q→¬J", color = Color.LightGray)
                },
                value = expressao.value,
                onValueChange = { ar ->
                    expressao.value = ar
                },
                shape = RoundedCornerShape(20.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color(0xFF0E5C64),
                    unfocusedBorderColor = Color.LightGray,
                    focusedLabelColor = Color.Black,
                    unfocusedLabelColor = Color.LightGray,
                    focusedTextColor = Color.White,
                    focusedPlaceholderColor = Color.Transparent
                ),
                maxLines = 4
            )
        }
        Spacer(modifier = Modifier.padding(top = 20.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxWidth()

        ) {
            Button(
                onClick = {
                    expressao.value = expressao.value + "¬"
                },
                border = BorderStroke(1.dp, color = Color(0xFF121212)),
                elevation = ButtonDefaults.buttonElevation(20.dp),
                modifier = Modifier.size(width = 100.dp, height = 50.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF60B1C5))
            ) {
                Text(
                    "¬",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Button(
                onClick = {
                    expressao.value = expressao.value + "∧"
                },
                border = BorderStroke(1.dp, color = Color(0xFF121212)),
                elevation = ButtonDefaults.buttonElevation(20.dp),
                modifier = Modifier.size(width = 100.dp, height = 50.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF60B1C5))
            ) {
                Text(
                    "∧",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Button(
                onClick = {
                    expressao.value = expressao.value + "∨"
                },
                border = BorderStroke(1.dp, color = Color(0xFF121212)),
                elevation = ButtonDefaults.buttonElevation(20.dp),
                modifier = Modifier.size(width = 100.dp, height = 50.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF60B1C5))
            ) {
                Text(
                    "∨",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }

        }
        Spacer(modifier = Modifier.padding(top = 13.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(
                onClick = {
                    expressao.value = expressao.value + "→"
                },
                border = BorderStroke(1.dp, color = Color(0xFF121212)),
                elevation = ButtonDefaults.buttonElevation(20.dp),
                modifier = Modifier.size(width = 100.dp, height = 50.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF60B1C5))
            ) {
                Text(
                    "→",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Button(
                onClick = {
                    expressao.value = expressao.value + "↔"
                },
                border = BorderStroke(1.dp, color = Color(0xFF121212)),
                elevation = ButtonDefaults.buttonElevation(20.dp),
                modifier = Modifier.size(width = 100.dp, height = 50.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF60B1C5))
            ) {
                Text(
                    "↔",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
        Spacer(modifier = Modifier.padding(top = 10.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                border = BorderStroke(3.dp, color = Color(0xFF121212)),
                elevation = ButtonDefaults.buttonElevation(20.dp),
                modifier = Modifier.size(350.dp, 60.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF60B1C5)),
                onClick = {
                    var estadoverificacao1 = verificacao(expressao.value)

                    if (estadoverificacao1) {
                        estadoverificacao.value = "verdadeiro"
                        cordoestado.value = Color(0xFF60E597)
                    } else {
                        estadoverificacao.value = "falso"
                        cordoestado.value = Color(0xFFF88585)
                    }
                }
            ) {
                Text("VERIFICAR EXPRESSÃO", fontSize = 20.sp, fontWeight = FontWeight.Bold)
            }
        }
        Spacer(modifier = Modifier.padding(top = 10.dp))
        Card(
            modifier = Modifier.size(310.dp, 110.dp)
                .padding(start = 60.dp),
            elevation = CardDefaults.cardElevation(20.dp),
            shape = RoundedCornerShape(10.dp),
            colors = CardDefaults.cardColors(containerColor = cordoestado.value),
            border = BorderStroke(3.dp, color = Color.Black)
        ) {
            if (estadoverificacao.value == "verdadeiro") {
                Text(
                    "Sintaxe\n\ncorreta",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxSize(),
                    fontSize = 50.sp
                )
            }
            if (estadoverificacao.value == "falso") {
                Text(
                    "Sintaxe\n\nincorreta",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxSize(),
                    fontSize = 50.sp
                )
            } else {
                Text(
                    "?",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxSize(),
                    fontSize = 95.sp
                )
            }
        }
        Spacer(modifier= Modifier.padding(top = 10.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ){
        Button(
            border = BorderStroke(3.dp, color = Color(0xFF121212)),
            elevation = ButtonDefaults.buttonElevation(20.dp),
            modifier = Modifier.size(350.dp, 60.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF60B1C5)),
            onClick = {
                if(estadoverificacao.value == "verdadeiro"){
                    matriz.value = criamatriz(expressao.value)
                    navController.currentBackStackEntry?.savedStateHandle?.set("listaChars",matriz.value)
                    navController.navigate("matriz")
                }
            }
        ) {
            Text("VER TABELA VERDADE", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        }
    }
    }
}
































