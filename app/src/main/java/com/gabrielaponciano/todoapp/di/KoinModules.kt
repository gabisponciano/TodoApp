package com.gabrielaponciano.todoapp.di

import androidx.room.Room
import com.gabrielaponciano.todoapp.db.TaskDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val appModule = module {
    viewModelOf (::HomeViewModel)
    singleOf(::TaskRepository)
}

val storageModule = module {
    single {
        Room.databaseBuilder(
            androidContext(),
            TaskDatabase::class.java, "task-database.db"
        ).build()
    }
    single {
        get<TaskDatabase>().TaskDao()
    }
}