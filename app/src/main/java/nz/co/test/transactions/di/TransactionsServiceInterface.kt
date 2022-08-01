package nz.co.test.transactions.di

import nz.co.test.transactions.model.RecyclerList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface TransactionsServiceInterface {

    @GET("Josh-Ng/500f2716604dc1e8e2a3c6d31ad01830/raw/4d73acaa7caa1167676445c922835554c5572e82/test-data.json")
    fun getDataFromAPI(): Call<RecyclerList>?
}