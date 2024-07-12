package com.gabrielaponciano.todoapp.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

@Dao
interface TaskDao {

    @Query("SELECT * FROM TaskEntity")
    fun findAll(): Flow<List<TaskEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save (task: TaskEntity)

    @Query("DELETE FROM TaskEntity WHERE id = :id")
    suspend fun deleteTask(id: String)

    @Update
    suspend fun updateTask(task: TaskEntity)

    @Query("Select * FROM TaskEntity WHERE id = :id")
    fun getTaskById(id:String): Flow<List<TaskEntity>>


}