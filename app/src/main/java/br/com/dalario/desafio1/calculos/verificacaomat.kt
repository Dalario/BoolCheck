package br.com.dalario.desafio1.calculos

fun criamatriz(expressao: String): MutableList<Char>{

    val matriz = mutableListOf<Char>()

    for(i in expressao.indices){
        if (expressao[i] in 'A'..'Z'){
            matriz.add(expressao[i])
        }
    }
    return matriz
}

fun corpomatriz(numdeementos: Int): MutableList<MutableList<Char>>{
    val linhas = 1 shl numdeementos

    val matriz = MutableList(linhas){
            linha-> MutableList(numdeementos){
            coluna -> if ((linha shr (numdeementos - coluna - 1)) and 1== 1) 'V' else 'F'
    }
    }
    return matriz
}

fun negcorpomatriz(numdeementos: Int): MutableList<MutableList<Char>>{
    val linhas = 1 shl numdeementos

    val matriz = MutableList(linhas){
            linha-> MutableList(numdeementos){
            coluna -> if ((linha shr (numdeementos - coluna - 1)) and 1== 1) 'F' else 'V'
    }
    }
    return matriz
}