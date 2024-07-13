package com.gabrielaponciano.todoapp.di

import androidx.room.Room
import com.gabrielaponciano.todoapp.db.TaskDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val appModules = module {
    viewModelOf(::NewTaskViewModel)
    viewModelOf(::HomeViewModel)
   // viewModelOf(::TasksListViewModel)
}

val storageModule = module {
    val databaseName = "task-database"
    singleOf(::TaskRepository)
    single {
        Room.databaseBuilder(
            androidContext(),
            TaskDatabase::class.java, databaseName
        ).build()
    }
    single {
        get<TaskDatabase>().TaskDao()
    }
}