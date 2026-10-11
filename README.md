<div align="center">

# ✅ BoolCheck

**App Android para validar expressões da lógica proposicional e gerar a tabela-verdade**

![Kotlin](https://img.shields.io/badge/Kotlin-2.0-7F52FF?style=for-the-badge&logo=kotlin&logoColor=white)
![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-4285F4?style=for-the-badge&logo=jetpackcompose&logoColor=white)
![Android](https://img.shields.io/badge/Android-8.1%2B-3DDC84?style=for-the-badge&logo=android&logoColor=white)
![Material 3](https://img.shields.io/badge/Material%203-757575?style=for-the-badge&logo=materialdesign&logoColor=white)

</div>

---

## 📖 Sobre o projeto

O **BoolCheck** é uma ferramenta de apoio ao estudo de **Lógica Matemática**. O usuário monta uma fórmula com proposições (`P`, `Q`, `R`...) e conectivos lógicos, e o app:

1. **verifica se a sintaxe da fórmula está correta**;
2. **gera a tabela-verdade** com todas as combinações de valores **V** e **F** das proposições.

Tudo roda offline, direto no aparelho, sem precisar de internet ou cadastro.

---

## ✨ Funcionalidades

- 📘 **Tela de introdução** explicando cada conectivo lógico com exemplos
- ⌨️ **Teclado de conectivos**: botões para inserir `¬`, `∧`, `∨`, `→` e `↔` sem precisar procurar os símbolos
- 🔎 **Verificador de sintaxe** com retorno visual: verde para *sintaxe correta* e vermelho para *sintaxe incorreta*
- 📊 **Tabela-verdade automática** com as 2ⁿ linhas de combinações e as colunas de cada proposição e da sua negação
- ↔️ Tabela com **rolagem horizontal e vertical**, para fórmulas com muitas proposições

---

## 🔣 Conectivos suportados

| Símbolo | Nome | Leitura | Exemplo |
|:-------:|------|---------|---------|
| `¬` | Negação | "não" | `¬P` |
| `∧` | Conjunção | "e" | `P∧Q` |
| `∨` | Disjunção inclusiva | "ou" | `P∨Q` |
| `→` | Condicional | "se... então..." | `P→Q` |
| `↔` | Bicondicional | "se e somente se" | `P↔Q` |

### Regras de sintaxe

- Proposições são **letras maiúsculas** de `A` a `Z`.
- Uma fórmula pode ser só uma proposição (`P`) ou várias, ligadas por conectivos binários (`P∧Q∨R`).
- A negação pode vir antes de qualquer proposição, inclusive repetida (`¬¬P`).
- A fórmula não pode começar nem terminar com um conectivo binário, e dois conectivos binários não podem ficar seguidos.

| Expressão | Resultado |
|-----------|:---------:|
| `P∧¬Q∨R∧S` | ✅ correta |
| `P→Q→¬J` | ✅ correta |
| `P∧∨Q` | ❌ incorreta |
| `∧P` | ❌ incorreta |
| `PQ` | ❌ incorreta |

---

## 📱 Fluxo do app

```
┌────────────────┐      ┌──────────────────────┐      ┌──────────────────┐
│   Introdução   │ ───▶ │   Verificação da     │ ───▶ │  Tabela-verdade  │
│  (conectivos)  │      │  sintaxe da fórmula  │      │   (V / F)        │
└────────────────┘      └──────────────────────┘      └──────────────────┘
```

A tabela-verdade só é liberada depois que a fórmula passa na verificação de sintaxe.

---

## 🧰 Tecnologias

| Camada | Stack |
|--------|-------|
| Linguagem | Kotlin 2.0 |
| Interface | Jetpack Compose + Material 3 |
| Navegação | Navigation Compose |
| Build | Gradle (Kotlin DSL), AGP 8.11, compileSdk 36, minSdk 27 |

---

## 📁 Estrutura

```
app/src/main/java/br/com/dalario/desafio1/
├── MainActivity.kt              # NavHost com as três telas
├── screens/
│   ├── introducaoScreen.kt      # Boas-vindas e explicação dos conectivos
│   ├── vereficacaoScreen.kt     # Entrada da fórmula e verificação
│   └── matrizScreen.kt          # Exibição da tabela-verdade
├── calculos/
│   ├── verificacaosint.kt       # Validação da sintaxe da expressão
│   └── verificacaomat.kt        # Extração das proposições e geração das linhas V/F
└── ui/theme/                    # Cores, tipografia e tema
```

### Como a tabela é gerada

Para `n` proposições, o app cria `2ⁿ` linhas e usa **operações de bits** para preencher cada coluna: o bit correspondente do número da linha define se o valor é `V` ou `F`. Assim, todas as combinações aparecem em ordem, sem repetição.

---

## 🚀 Como rodar

**Pré-requisitos:** Android Studio (versão recente), JDK 11+ e um dispositivo ou emulador com **Android 8.1 (API 27)** ou superior.

```bash
git clone https://github.com/Dalario/BoolCheck.git
```

Abra a pasta no **Android Studio**, aguarde a sincronização do Gradle e clique em **Run ▶**.

---

## 🗺️ Próximos passos

- [ ] Calcular o **resultado final da fórmula** em uma coluna da tabela
- [ ] Mostrar as colunas intermediárias de cada subexpressão
- [ ] Suporte a **parênteses** para definir precedência
- [ ] Suporte à **disjunção exclusiva** (`⊻`)
- [ ] Ignorar proposições repetidas ao montar a tabela (ex.: `P∧P`)
- [ ] Identificar **tautologias**, **contradições** e **contingências**

---

<div align="center">

Feito com 💙 por **[Dalario](https://github.com/Dalario)**

</div>
