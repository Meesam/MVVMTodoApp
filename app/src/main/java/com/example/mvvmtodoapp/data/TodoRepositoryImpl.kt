package com.example.mvvmtodoapp.data

import androidx.lifecycle.LiveData
import kotlinx.coroutines.flow.Flow

class TodoRepositoryImpl(private val dao: TodoDao):TodoRepository {
  
  override suspend fun createTodo(todo: Todo) {
    dao.createTodo(todo)
  }
  
  override suspend fun deleteTodo(todo: Todo) {
    dao.deleteTodo(todo)
  }
  
  override suspend fun getTodoById(id: Int): Todo? {
    return dao.getTodoById(id)
  }
  
  override fun getTodos(): Flow<List<Todo>> {
    return dao.getTodos()
  }
}