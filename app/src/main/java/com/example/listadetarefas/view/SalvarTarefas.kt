package com.example.listadetarefas.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.listadetarefas.components.tarefaForm
import com.example.listadetarefas.ui.theme.Purple700
import com.example.listadetarefas.ui.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun salvarTarefa(
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
                        text = "Criar uma Tarefa",
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                    )
                }
            )
        },
        content = {innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                tarefaForm()
            }
        }
    )
}