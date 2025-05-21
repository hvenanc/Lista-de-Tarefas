package com.example.listadetarefas.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.listadetarefas.R
import com.example.listadetarefas.model.Tarefa
import com.example.listadetarefas.ui.theme.Black
import com.example.listadetarefas.ui.theme.CardColor
import com.example.listadetarefas.ui.theme.UnselectRadioGreen
import com.example.listadetarefas.ui.theme.UnselectRadioRed
import com.example.listadetarefas.ui.theme.UnselectRadioYellon

@Composable
fun TarefaItem(
    position: Int,
    listaTarefas: MutableList<Tarefa>
) {

    val tituloTarefa = listaTarefas[position].tarefa
    val descricaoTarefa = listaTarefas[position].descricao
    val prioridadeTarefa = listaTarefas[position].prioridade

    var nivelPrioridade: String = when(prioridadeTarefa) {
        0 -> {"Sem Prioridade"}
        1 -> {"Prioridade Baixa"}
        2 -> {"Prioridade Média"}
        else -> {"Prioridade ALta"}
    }

    val color = when(prioridadeTarefa) {
        0 -> {
            Black
        }
        1 -> {
            UnselectRadioGreen
        }
        2 -> {
            UnselectRadioYellon
        }
        else -> {
            UnselectRadioRed
        }
    }


    Card(
        colors = CardDefaults.cardColors(
            containerColor = CardColor
        ),
        modifier = Modifier.fillMaxWidth().padding(10.dp)
    ) {
        ConstraintLayout(
            modifier = Modifier.padding(20.dp)
        ) {
            val (textTitulo, textDescricao, cardPrioridade, textPrioridade, btnDeleter) = createRefs()

            Text(
                text = tituloTarefa.toString(),
                modifier = Modifier.constrainAs(textTitulo) {
                    top.linkTo(parent.top, margin = 10.dp)
                    start.linkTo(parent.start, margin = 10.dp)
                }
            )

            Text(
                text = descricaoTarefa.toString(),
                modifier = Modifier.constrainAs(textDescricao) {
                    top.linkTo(textTitulo.bottom, margin = 10.dp)
                    start.linkTo(parent.start, margin = 10.dp)
                }
            )

            Text(
                text = nivelPrioridade,
                modifier = Modifier.constrainAs(textPrioridade) {
                    top.linkTo(textDescricao.bottom, margin = 10.dp)
                    start.linkTo(parent.start, margin = 10.dp)
                    bottom.linkTo(parent.bottom, margin = 10.dp)
                }
            )

            Card(
                colors = CardDefaults.cardColors(
                    containerColor = color,
                ),
                modifier = Modifier.size(30.dp).constrainAs(cardPrioridade) {
                    top.linkTo(textDescricao.bottom, margin = 10.dp)
                    start.linkTo(textPrioridade.end, margin = 10.dp)
                    bottom.linkTo(parent.bottom, margin = 10.dp)
                },
                shape = RoundedCornerShape(100.dp)
            ) {

            }
            IconButton(
                onClick = {

                },
                modifier = Modifier.constrainAs(btnDeleter) {
                    top.linkTo(textDescricao.bottom, margin = 10.dp)
                    start.linkTo(cardPrioridade.end, margin = 30.dp)
                    end.linkTo(parent.end, margin = 10.dp)
                    bottom.linkTo(parent.bottom, margin = 10.dp)
                }
            ) {
                Image(
                    painter = painterResource(R.drawable.ic_delete),
                    contentDescription = "Deletar Tarefa"
                )
            }
        }
    }
}