package nz.co.test.transactions.activities

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import nz.co.test.transactions.di.TransactionsServiceInterface
import nz.co.test.transactions.model.RecyclerList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class MainActivityViewModel(application: Application) : AndroidViewModel(application){
    @Inject
    lateinit var mService: TransactionsServiceInterface

    private lateinit var liveDataList: MutableLiveData<RecyclerList>


    init {
        //here we need to init application.
        (application as MyApplication).getRetroComponent().inject(this)
        liveDataList = MutableLiveData()
    }


    fun getLiveDataObserver(): MutableLiveData<RecyclerList> {
        return liveDataList
    }

    fun makeApicall() {
        val call: Call<RecyclerList>?  = mService.getDataFromAPI()
        call?.enqueue(object : Callback<RecyclerList>{
            override fun onFailure(call: Call<RecyclerList>, t: Throwable) {
                liveDataList.postValue(null)
            }

            override fun onResponse(call: Call<RecyclerList>, response: Response<RecyclerList>) {
                if(response.isSuccessful) {
                    liveDataList.postValue(response.body())
                } else {
                    liveDataList.postValue(null)
                }
            }
        })
    }
}