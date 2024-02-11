package com.example.myluxqcm

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun ResultScreen(navController: NavHostController, answer: String) {
    // La bonne réponse pour l'exemple
    val correctAnswer = "Paris"

    Column {
        Text("Vous avez choisi : $answer")
        Spacer(modifier = Modifier.height(16.dp))
        // Ici, ajoutez la logique pour vérifier si la réponse est correcte
        if(answer == correctAnswer) {
            Text("Bonne réponse !", color = MaterialTheme.colorScheme.primary)
        } else {
            Text("Mauvaise réponse. La bonne réponse est $correctAnswer.", color = MaterialTheme.colorScheme.error)
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { navController.navigate("question") }) {
            Text("Réessayer")
        }
    }
}
