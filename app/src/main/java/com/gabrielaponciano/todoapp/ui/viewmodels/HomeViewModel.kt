package com.gabrielaponciano.todoapp.ui.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gabrielaponciano.todoapp.model.TaskModel
import com.gabrielaponciano.todoapp.repository.TaskRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.util.UUID

class HomeViewModel(private val repository: TaskRepository): ViewModel() {

    private val _listAll = MutableStateFlow<List<TaskModel>>(emptyList())
    val listAll: StateFlow<List<TaskModel>> = _listAll

    var itemSelection by mutableIntStateOf(1)


//    var listAllTask by mutableStateOf<Array<TaskModel>?>(null)

//    private val tempList = mutableListOf<TaskModel>()

    init {
        viewModelScope.launch {
            getAllTasks()
        }

    }

    private suspend fun getAllTasks(){

            try {
                _listAll.value = repository.findAllList()
//                val listTaskResult = repository.findAllList()
//                for (i in listTaskResult.indices){
//                    tempList.add(listTaskResult[i])
//                }
//                listAllTask = tempList.toTypedArray()
            }catch (e:Exception){
                println(e.message)
            }


//        try {
//            val listTaskResult = repository.findAllList()
//            for (i in listTaskResult.indices){
//                tempList.add(listTaskResult[i])
//            }
//            listAllTask = tempList.toTypedArray()
//        }catch (e:Exception){
//            println(e.message)
//        }

    }

    suspend fun save(
        title:String,
        description:String,
        status:String
    ){
        repository.save(
            TaskModel(
                id = UUID.randomUUID().toString(),
                title = title,
                description = description,
                status = status
            )
        )
    }
}