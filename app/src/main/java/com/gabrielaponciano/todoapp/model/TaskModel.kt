package com.gabrielaponciano.todoapp.model

import java.util.UUID

data class TaskModel (
    val id: Int = 0,
    val title: String,
    val description: String,
    val status: String,
    val date:Int

)