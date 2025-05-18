package com.example.listadetarefas.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.listadetarefas.ui.theme.Black
import com.example.listadetarefas.ui.theme.Ciano

@Composable
fun tarefaForm() {

    var tituloTarefa by rememberSaveable { mutableStateOf("") }
    var descricaoTarefa by rememberSaveable { mutableStateOf ("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())

    ) {
        OutlinedTextField(
            value = tituloTarefa,
            label = {
                Text(
                    text = "Título da Tarefa",
                    fontWeight = FontWeight.Bold,
                )
            },
            modifier = Modifier.fillMaxWidth()
                .padding(10.dp, 10.dp, 10.dp, 0.dp),
            onValueChange = {tituloTarefa = it},
            textStyle = TextStyle(
                color = Black,
                fontWeight = FontWeight.Bold,
            ),
            maxLines = 1,
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Ciano
            ),
            shape = RoundedCornerShape(8.dp)
        )
        Spacer(modifier = Modifier.size(24.dp))
        OutlinedTextField(
            value = descricaoTarefa,
            label = {
                Text(
                    text = "Descrição",
                    fontWeight = FontWeight.Bold,
                )
            },
            modifier = Modifier.fillMaxWidth().height(150.dp)
                .padding(10.dp, 10.dp, 10.dp, 0.dp),
            onValueChange = {descricaoTarefa = it},
            textStyle = TextStyle(
                color = Black,
                fontWeight = FontWeight.Bold,
            ),
            maxLines = 5,
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Ciano
            ),
            shape = RoundedCornerShape(8.dp)
        )
    }

}