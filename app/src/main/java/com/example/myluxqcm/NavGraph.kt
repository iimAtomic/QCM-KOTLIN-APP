package com.example.myluxqcm

import GridSelectionScreen
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable


@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "selectionList") {
        composable("selectionList") {
            SelectionListScreen(navController)
        }
        composable("gridSelection/{questionIndex}") { backStackEntry ->
            val questionIndex = backStackEntry.arguments?.getString("questionIndex")?.toIntOrNull() ?: 0
            GridSelectionScreen(navController, questionIndex)
        }
        composable("confirmation/{isCorrect}") { backStackEntry ->
            val isCorrect = backStackEntry.arguments?.getString("isCorrect")?.toBoolean() ?: false
            ConfirmationScreen(navController, isCorrect)
        }

        composable("result/{isCorrect}") { backStackEntry ->
            val isCorrect = backStackEntry.arguments?.getString("isCorrect")?.toBoolean() ?: false
            ResultScreen(navController, isCorrect)
        }
    }
}
