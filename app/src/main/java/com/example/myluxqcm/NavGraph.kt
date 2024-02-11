package com.example.myluxqcm

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "questionScreen") {
        composable("questionScreen") {
            QuestionScreen(navController = navController)
        }
        // Ajoutez ici d'autres destinations si nécessaire
    }
}
