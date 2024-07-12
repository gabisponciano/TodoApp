package com.gabrielaponciano.todoapp.repository

import com.gabrielaponciano.todoapp.db.TaskDao
import com.gabrielaponciano.todoapp.db.TaskEntity
import com.gabrielaponciano.todoapp.model.TaskModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class TaskRepository (private val dao: TaskDao):TaskRepositoryInterface{
    override fun findAll(): Flow<List<TaskEntity>> {
        return dao.findAll()
    }

    override suspend fun save(task: TaskModel) {
        dao.save(task.toEntity())
    }

    override suspend fun deleteTask(id: String) {
        dao.deleteTask(id)
    }

    override suspend fun updateTask(task: TaskModel) {
        TODO("Not yet implemented")
    }

    override fun getTaskById(id: String){
        dao.getTaskById(id)
    }

}

fun TaskModel.toEntity() = TaskEntity(
    id = this.id,
    title = this.title,
    description = this.description,
    date = this.date,
    status = this.status
)