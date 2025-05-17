package com.example.listadetarefas.view

import android.annotation.SuppressLint
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.listadetarefas.ui.theme.Purple700
import com.example.listadetarefas.ui.theme.White


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun listaTarefas(
    navController: NavController
) {
    Scaffold(
        topBar = {
            TopAppBar(
                colors = topAppBarColors(
                    containerColor = Purple700,
                    titleContentColor = White
                ),
                title = {
                    Text(
                        text = "Lista de Tarefas",
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                    )
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate("salvarTarefa") },
                containerColor = Purple700) {
                Icon(Icons.Default.Add, contentDescription = "Adicionar Tarefa", tint = White)
            }
        }
    ) {

    }
}