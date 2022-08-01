package nz.co.test.transactions.di

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class RetroModule {

    val baseURL = "https://gist.githubusercontent.com/"

    @Singleton
    @Provides
    fun getRetroServiceInterface(retrofit: Retrofit):TransactionsServiceInterface {
        return retrofit.create(TransactionsServiceInterface::class.java)
    }

    @Singleton
    @Provides
    fun getRetroFitInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}