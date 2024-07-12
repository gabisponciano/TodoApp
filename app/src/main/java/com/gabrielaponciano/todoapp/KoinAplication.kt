package com.gabrielaponciano.todoapp

import android.app.Application
import com.gabrielaponciano.todoapp.di.appModule
import com.gabrielaponciano.todoapp.di.storageModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class KoinAplication :Application(){
    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidLogger()
            androidContext(this@KoinAplication)
            modules(appModule,
                storageModule)
        }
    }
}