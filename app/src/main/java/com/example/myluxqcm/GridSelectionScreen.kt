import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.myluxqcm.questions

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GridSelectionScreen(navController: NavHostController, questionIndex: Int) {
    val question = questions[questionIndex]
    val (selectedAnswer, setSelectedAnswer) = remember { mutableStateOf<String?>(null) }

    Scaffold(
        topBar = { TopAppBar(title = { Text("Sélectionnez votre réponse") }) },
        content = { padding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = question.text, style = MaterialTheme.typography.headlineMedium)
                Spacer(modifier = Modifier.height(32.dp))
                question.answers.forEachIndexed { index, answer ->
                    AnswerButton(answer, selectedAnswer == answer) {
                        setSelectedAnswer(answer)
                    }
                }
                Button(
                    modifier = Modifier.padding(16.dp),
                    onClick = {
                        if(selectedAnswer != null) {
                            navController.navigate("confirmation/${selectedAnswer == question.answers[question.correctAnswerIndex]}")
                        }
                    }
                ) {
                    Text("Confirmer")
                }
            }
        }
    )
}

@Composable
fun AnswerButton(answer: String, isSelected: Boolean, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.secondary
        )
    ) {
        Text(answer)
    }
}
