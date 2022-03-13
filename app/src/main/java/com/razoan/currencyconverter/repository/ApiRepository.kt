package com.razoan.currencyconverter.repository

import com.razoan.currencyconverter.apiclient.Resource
import com.razoan.currencyconverter.apiclient.RetrofitClient
import com.razoan.currencyconverter.model.CurrencyInfoResponse
import com.razoan.currencyconverter.util.DataConfig
import com.razoan.currencyconverter.viewmodel.CurrencyConverterVM
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object ApiRepository {
    fun getCurrencyInfo(callback: CurrencyConverterVM.GetCurrencyInfoCallBack){

        callback.getCurrencyInfoCallBackResponse(Resource.loading())

        RetrofitClient.ApiRequest.getCurrencyInfo(DataConfig.ACCESS_KEY, 1)?.enqueue(object :
            Callback<CurrencyInfoResponse> {
            override fun onFailure(call: Call<CurrencyInfoResponse>, t: Throwable) {
                callback.getCurrencyInfoCallBackResponse(Resource.error(t.localizedMessage ?: "Failed to get data."))
            }

            override fun onResponse(call: Call<CurrencyInfoResponse>, response: Response<CurrencyInfoResponse>) {
                if (response.isSuccessful) {
                    callback.getCurrencyInfoCallBackResponse(Resource.success(response.body()))
                } else{
                    callback.getCurrencyInfoCallBackResponse(Resource.error(response.errorBody()?.string() ?: "Failed to get data."))
                }
            }
        })
    }
}