package com.gabrielaponciano.todoapp.ui.viewmodels

import android.widget.Toast
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gabrielaponciano.todoapp.model.TaskModel
import com.gabrielaponciano.todoapp.repository.TaskRepository
import kotlinx.coroutines.launch
import java.util.UUID

class NewTaskViewModel(private val repository: TaskRepository) : ViewModel(){
    var title by mutableStateOf("")
    var description by mutableStateOf("")
    var status by mutableStateOf("")



    fun clearFilds(){
        title = ""
        description = ""
        status = ""
    }

    fun saveTask(){
        if(
            title.isNotEmpty() &&
            description.isNotEmpty()
        ){
            viewModelScope.launch {
                save(title,description,status)
            }
        }

    }

    private suspend fun save(
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
