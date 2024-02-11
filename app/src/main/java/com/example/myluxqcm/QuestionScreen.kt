package com.example.myluxqcm

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.navigation.NavHostController

@Composable
fun QuestionScreen(navController: NavHostController) {
    val question = "Quelle est la capitale de la France ?"
    val choices = listOf("Paris", "Lyon", "Marseille", "Lille")
    val (selectedAnswer, setSelectedAnswer) = remember { mutableStateOf<String?>(null) }

    Column {
        Text(question)
        choices.forEach { answer ->
            RadioButton(
                selected = selectedAnswer == answer,
                onClick = { setSelectedAnswer(answer) }
            )
            Text(answer)
        }
        Button(onClick = {
            navController.navigate("result/$selectedAnswer")
        }) {
            Text("Soumettre")
        }
    }
}
