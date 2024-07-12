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
    //Precisa de Uptade, Deletar, Criar e Procurar

    @Insert(onConflict = OnConflictStrategy.REPLACE) // Atualiza e Insere
    suspend fun save(task: TaskEntity)

//    @Delete
//    suspend fun deleteTask(task: TaskEntity)

//    @Query ("DELETE FROM TaskEntity WHERE id = :id")
//    suspend fun deleteTaskId(id:Int)

    @Query("SELECT * FROM TaskEntity")
    fun getAllTasksEntries():List<TaskEntity>

//    @Update()
//    suspend fun updateTask(task: TaskEntity)

}