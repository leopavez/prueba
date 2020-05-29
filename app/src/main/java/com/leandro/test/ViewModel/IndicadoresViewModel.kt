package com.leandro.test.ViewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.leandro.test.Data.APIServices
import com.leandro.test.Model.indicadores
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class IndicadoresViewModel : ViewModel() {


    fun getdataapi(){

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://www.mindicador.cl/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create<APIServices>(APIServices::class.java)
        service.getAllIndicadores().enqueue(object : Callback<indicadores> {
            override fun onResponse(
                call: Call<indicadores>?,
                response: Response<indicadores>?
            ) {
                val gson = Gson()
                val indicador = gson.fromJson(Gson().toJson(response?.body()), indicadores::class.java)

                Log.i("TAG",indicador.toString())

            }
            override fun onFailure(call: Call<indicadores>?, t: Throwable?) {
                t?.printStackTrace()
            }
        })

    }

}