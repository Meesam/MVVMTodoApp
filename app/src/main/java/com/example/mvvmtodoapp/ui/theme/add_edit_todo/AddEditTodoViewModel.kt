package com.example.mvvmtodoapp.ui.theme.add_edit_todo

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmtodoapp.data.Todo
import com.example.mvvmtodoapp.data.TodoRepository
import com.example.mvvmtodoapp.util.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddEditTodoViewModel @Inject constructor(
  private val repository: TodoRepository,
  savedStateHandle: SavedStateHandle
) : ViewModel() {

  var todo by mutableStateOf<Todo?>(null)
    private set
  
  var title by mutableStateOf("")
     private set

  var description by mutableStateOf("")
    private  set
  
  private val _uiEvent = Channel<UiEvent>()
  val uiEvent = _uiEvent.receiveAsFlow()
  
  init {
    val todoId =savedStateHandle.get<Int>("todoId")!!
    if(todoId != -1){
      viewModelScope.launch {
         repository.getTodoById(todoId)?.let {todo->
           title = todo.title
           description= todo.description.toString()
           this@AddEditTodoViewModel.todo = todo
         }
      }
    }
  }
  
  fun onEvent(event:AddEditTodoEvent){
    when(event){
      is AddEditTodoEvent.onTitleChange -> {
        title=event.title
      }
      is AddEditTodoEvent.onDescriptionChange->{
        description = event.description
      }
      is AddEditTodoEvent.OnSaveTodoClick->{
         viewModelScope.launch {
           repository.createTodo(
             Todo(title =  title, description =  description,isDone = todo?.isDone ?: false)
           )
           sendUiEvent(UiEvent.PopBackStack)
         }
      }
    }
  }
  
  private fun sendUiEvent(event: UiEvent){
    viewModelScope.launch {
      _uiEvent.send(event)
    }
  }

}