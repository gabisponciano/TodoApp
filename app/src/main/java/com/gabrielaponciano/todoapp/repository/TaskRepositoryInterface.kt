package com.gabrielaponciano.todoapp.repository

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.gabrielaponciano.todoapp.db.TaskEntity
import com.gabrielaponciano.todoapp.model.TaskModel
import kotlinx.coroutines.flow.Flow

interface TaskRepositoryInterface {
    fun findAll(): Flow<List<TaskEntity>>
    suspend fun save (task: TaskModel)
    suspend fun deleteTask(id: String)
    suspend fun updateTask(task: TaskModel)
    fun getTaskById(id:String)
}