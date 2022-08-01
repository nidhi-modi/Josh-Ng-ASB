package nz.co.test.transactions.di

import dagger.Component
import nz.co.test.transactions.activities.MainActivityViewModel
import javax.inject.Singleton


@Singleton
@Component(modules = [RetroModule::class])
interface RetroComponent {

    fun inject(mainActivityViewModel: MainActivityViewModel)
}