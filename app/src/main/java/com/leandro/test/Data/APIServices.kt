package com.leandro.test.Data

import com.leandro.test.Model.indicadores
import retrofit2.Call
import retrofit2.http.GET

interface APIServices {

    @GET("api/")
    fun getAllIndicadores(): Call<indicadores>

}