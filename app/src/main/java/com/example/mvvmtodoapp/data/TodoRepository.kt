package com.example.mvvmtodoapp.data

import androidx.lifecycle.LiveData
import kotlinx.coroutines.flow.Flow

interface TodoRepository {

  suspend fun createTodo(todo: Todo)
  
  suspend fun deleteTodo(todo: Todo)
  
  suspend fun getTodoById(id:Int):Todo?
  
  fun getTodos(): Flow<List<Todo>>
}