package com.example.listadetarefas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.listadetarefas.ui.theme.ListaDeTarefasTheme
import com.example.listadetarefas.view.listaTarefas
import com.example.listadetarefas.view.salvarTarefa

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ListaDeTarefasTheme {

                 val navController = rememberNavController();

                 NavHost(navController = navController, startDestination = "listaTarefas") {
                     composable(
                         route = "listaTarefas"
                     ) {
                         listaTarefas(navController)
                     }
                     composable(
                         route = "salvarTarefa"
                     ){
                         salvarTarefa(navController)
                     }
                 }
            }
        }
    }
}
