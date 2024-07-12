package com.gabrielaponciano.todoapp.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID
@Entity()
data class TaskEntity (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val description: String,
    val status: String,
    val date:Int

)

