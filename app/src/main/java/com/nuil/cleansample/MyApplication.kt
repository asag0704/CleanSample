package com.nuil.cleansample

import android.app.Application
import com.nuil.cleansample.main.mainModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        // 의존성 주입을 사용하기 위한 선언
        startKoin {
            androidContext(applicationContext)
            modules(mainModule)
        }
    }
}