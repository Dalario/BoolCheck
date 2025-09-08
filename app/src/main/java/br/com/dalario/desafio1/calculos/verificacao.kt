package br.com.dalario.desafio1.calculos

import android.util.Log
import androidx.collection.emptyLongSet
import androidx.compose.material3.rememberTimePickerState

fun verificacao(expressao: String): Boolean{
    var tam = expressao.length

    for (i in expressao.indices){
        Log.d("caracteres", "${expressao[i]}")

        if (tam == 1){
            if(expressao[i] in 'A'..'Z'){
                return true
            }
            else return false
        }
        if(tam > 1 && expressao.any {it.isLetter()}){
            if(i == 0){
                if(expressao[i] in 'A'..'Z'|| expressao[i] == '¬');
                else return false
            }
            if(i> 0){
                if (expressao[i - 1] in 'A'..'Z'){
                    if (expressao[i] in "¬∧∨→↔") {
                        if (i+1 < tam){
                            if (expressao[i + 1] in 'A'..'Z' || expressao[i + 1] == '¬');
                            else return false
                        }
                        else return false
                    }
                    else return false
                }
                else {
                    if(expressao[i] in 'A'..'Z'|| expressao[i] == '¬'){
                        if (expressao[i] in 'A'..'Z');

                        if (expressao [i] == '¬' && i+1 < tam) {
                            if (expressao[i + 1] in 'A'..'Z'|| expressao[i+ 1] == '¬');
                            else return false
                        }
                    }
                    else return false

                }
            }
        }
        else return false
    }
    if (expressao[tam-2] in "¬∧∨→↔" && expressao[tam -1] in 'A'..'Z'){
        return true
    }else return false
}