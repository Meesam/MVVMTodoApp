package com.example.mvvmtodoapp.ui.theme.todo_list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mvvmtodoapp.data.Todo

@Composable
fun TodoItem(
  todo:Todo,
  onEvent: (TodoListEvent) -> Unit,
  modifier: Modifier = Modifier
){
  Row(verticalAlignment = Alignment.CenterVertically, modifier = modifier) {
    Column(verticalArrangement = Arrangement.Center,modifier=Modifier.weight(1f)) {
      Row(verticalAlignment = Alignment.CenterVertically) {
        Text(text = todo.title)
        IconButton(onClick = { onEvent(TodoListEvent.DeleteTodo(todo)) }) {
          Icon(imageVector = Icons.Default.Delete, contentDescription = "Delete" )
        }
      }
      todo.description?.let {
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = it)
      }
    }
    
    Checkbox(
      checked = todo.isDone,
      onCheckedChange ={isChecked ->
        onEvent(TodoListEvent.OnDoneChange(todo,isChecked))
      }
    )
  }
}