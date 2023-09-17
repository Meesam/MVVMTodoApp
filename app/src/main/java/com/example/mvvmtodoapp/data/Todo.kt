package com.example.mvvmtodoapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "todo")
data class Todo(
  @PrimaryKey
  val id: Int? = null ,
  @ColumnInfo(name = "title")
  val title:String,
  @ColumnInfo(name = "description")
  val description:String?,
  @ColumnInfo(name = "isDone")
  var isDone:Boolean,
  
  )
