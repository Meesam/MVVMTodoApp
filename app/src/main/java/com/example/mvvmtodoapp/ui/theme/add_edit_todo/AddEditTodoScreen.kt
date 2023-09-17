package com.example.mvvmtodoapp.ui.theme.add_edit_todo

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.mvvmtodoapp.util.UiEvent
import kotlinx.coroutines.flow.collect

@Composable
fun AddEditTodoScreen(
  onPopBackStack:() ->Unit,
  viewModel: AddEditTodoViewModel = hiltViewModel()
){
  val scaffoldState = remember {
    SnackbarHostState()
  }
  
  LaunchedEffect(key1 = true){
    viewModel.uiEvent.collect{event->
      when(event){
        is UiEvent.PopBackStack ->onPopBackStack()
        is UiEvent.ShowSnakbar ->{
          scaffoldState.showSnackbar(message = event.message, actionLabel = event.action)
        }
        else -> Unit
      }
    }
  }
  
  Box(modifier = Modifier.fillMaxSize()) {
    Column {
      TextField(value = viewModel.title,
        onValueChange ={
          viewModel.onEvent(AddEditTodoEvent.onTitleChange(it))
        }
      )
      TextField(value = viewModel.description,
        onValueChange ={
          viewModel.onEvent(AddEditTodoEvent.onDescriptionChange(it))
        }
      )
      Button(onClick = {
        viewModel.onEvent((AddEditTodoEvent.OnSaveTodoClick))
      }) {
        Text(text = "Add Todo")
      }
    }
  }
}