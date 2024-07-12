package com.gabrielaponciano.todoapp.repository


import com.gabrielaponciano.todoapp.db.TaskDao
import com.gabrielaponciano.todoapp.db.TaskEntity
import com.gabrielaponciano.todoapp.model.TaskModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class TaskRepository(
    private val dao: TaskDao
){
//    val alltasks get() = dao.getAllTasksEntries()

    suspend fun save(task: TaskModel) = withContext(IO) {
        dao.save(task.toEntity())
    }


//    suspend fun deleteTask(task: TaskModel) = withContext(IO){
//        dao.deleteTask(task.toEntity())
//    }
//
//    suspend fun deleteTaskId(id: Int) = withContext(IO){
//        dao.deleteTaskId(id)
//    }

    suspend fun findAllList(): List<TaskModel> = withContext(IO){
        return@withContext dao.getAllTasksEntries().map { it.toTask() }
    }


//    suspend fun updateTask(task: TaskModel) {
//        dao.updateTask(task.toEntity())
//    }
}

fun TaskModel.toEntity() = TaskEntity(
    id = this.id,
    title = this.title,
    description = this.description,
    status = this.status
)

fun TaskEntity.toTask() = TaskModel(
    id = this.id,
    title = this.title,
    description = this.description,
    status = this.status

)
