package com.razoan.currencyconverter.apiclient

import com.razoan.currencyconverter.model.CurrencyInfoResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiEndPoints {
    @GET("live")
    fun getCurrencyInfo(@Query("access_key") access_key: String?,
                               @Query("format") format: Int?): Call<CurrencyInfoResponse>?
}