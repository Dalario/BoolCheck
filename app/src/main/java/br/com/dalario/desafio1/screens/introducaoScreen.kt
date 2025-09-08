package br.com.dalario.desafio1.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun introducacaoScreen(navController: NavController){
    Column (modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally,
       ){
        Spacer(modifier = Modifier.padding(vertical = 15.dp))
        Card(
            modifier = Modifier.height( 200.dp). fillMaxWidth(),
            colors = CardDefaults.cardColors(Color(0xFF60B1C5)),
            border = BorderStroke(3.dp, Color(0xFF000000))
        ) {
            Spacer(modifier = Modifier.padding(top = 30.dp))
            Text(
                "Bem-vindo ao BoolCheck",
                fontSize = 30.sp,
                textAlign = TextAlign.Center,
                lineHeight = 40.sp,
                letterSpacing = 10.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )
        }
        Card( modifier = Modifier
            .size(330.dp, 440.dp)
            .offset(y = -80.dp),
            elevation = CardDefaults.cardElevation(20.dp),
            colors = CardDefaults.cardColors(Color.LightGray),
            border = BorderStroke(3.dp, Color(0xFF000000))
            ) {
            Text(
                "Instruções sobre os conectivos lógicos:\n\nNegação (¬):" +
                        "Inverte o valor de verdade de uma proposição. Por exemplo, se P é verdadeiro, ¬P é falso.\n\n" +
                        "Conjunção (∧):" +
                        "Indica \"e\". A conjunção (P ∧ Q) é verdadeira apenas se ambas as proposições P e Q forem verdadeiras.\n\n" +
                        "Disjunção Inclusiva (∨):\n" +
                        "Indica \"ou\" de forma inclusiva. A disjunção (P ∨ Q) é verdadeira se P for verdadeiro, ou Q for verdadeiro, ou ambos forem verdadeiros.\n\n" +
                        "Disjunção Exclusiva (⊻):\n" +
                        "Indica um \"ou\" exclusivo. A disjunção exclusiva (P ⊻ Q) é verdadeira apenas se P for verdadeiro e Q for falso, ou se P for falso e Q for verdadeiro.\n\n" +
                        "Condicional (→):\n" +
                        "Indica \"se... então...\". A condicional (P → Q) é falsa apenas no caso em que P é verdadeiro e Q é falso.\n\n" +
                        "Bicondicional (↔):\n" +
                        "Indica \"... se e somente se ...\". O bicondicional (P ↔ Q) é verdadeiro apenas quando P e Q têm o mesmo valor de verdade (ambos verdadeiros ou ambos falsos).",
                fontSize = 25.sp,
                modifier = Modifier
                    .padding(15.dp)
                    .verticalScroll(rememberScrollState(), enabled = true,),
                textAlign = TextAlign.Justify,
                color = Color.Black
            )
        }
        Spacer(modifier = Modifier.padding(0.dp))
        Button(
            border = BorderStroke(3.dp, color = Color(0xFF121212)),
            shape = RoundedCornerShape(20.dp),
            onClick = {navController.navigate("verificacao")},
            modifier = Modifier.size(300.dp, 80.dp),
            colors = ButtonDefaults.buttonColors(Color(0xFF60B1C5)),
            elevation = ButtonDefaults.buttonElevation(20.dp)
        ) {
            Text("Testar fórmulas ->", fontSize = 25.sp, color = Color.Black, textAlign = TextAlign.Center)
        }

    }
}

