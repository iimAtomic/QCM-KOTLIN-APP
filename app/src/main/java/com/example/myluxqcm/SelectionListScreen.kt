package com.example.myluxqcm

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
data class Question(
    val text: String,
    val answers: List<String>,
    val correctAnswerIndex: Int,

)


val questions = listOf(
    Question("Quelle est la capitale de la France ?", listOf("Paris", "Lyon", "Marseille", "Lille"), 0),
    Question("Quelle est la capitale de la France ?", listOf("Paris", "Lyon", "Marseille", "Lille"), 0),
    Question("Quel est le plus grand océan ?", listOf("Atlantique", "Pacifique", "Indien", "Arctique"), 1),
    Question("Qui a peint la Joconde ?", listOf("Michel-Ange", "Léonard de Vinci", "Raphaël", "Donatello"), 1),
    Question("Quel est le langage de programmation principalement utilisé pour Android ?", listOf("Java", "Kotlin", "Swift", "C#"), 1),
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SelectionListScreen(navController: NavHostController) {
    Scaffold(
        topBar = { TopAppBar(title = { Text("Sélection de la question") }) },
        content = { padding ->
            LazyColumn(contentPadding = padding) {
                items(questions) { question ->
                    QuestionItem(question = question, index = questions.indexOf(question), navController = navController)
                }
            }

        }
    )
}

@Composable
fun QuestionItem(question: Question, index: Int, navController: NavHostController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable {
                navController.navigate("gridSelection/$index")
            }
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = question.text, style = MaterialTheme.typography.bodyLarge)
        }
    }
}
