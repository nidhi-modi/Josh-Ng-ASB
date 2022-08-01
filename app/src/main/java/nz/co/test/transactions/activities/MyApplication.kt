package nz.co.test.transactions.activities

import android.app.Application
import nz.co.test.transactions.di.DaggerRetroComponent
import nz.co.test.transactions.di.RetroComponent
import nz.co.test.transactions.di.RetroModule

class MyApplication: Application() {

    private lateinit var retroComponent: RetroComponent

    override fun onCreate() {
        super.onCreate()

        retroComponent = DaggerRetroComponent.builder()
            .retroModule(RetroModule())
            .build()
    }

    fun getRetroComponent(): RetroComponent {
        return retroComponent
    }
}