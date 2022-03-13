package com.razoan.currencyconverter.apiclient

import com.razoan.currencyconverter.util.DataConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitClient {
    private val retrofitBuilder: Retrofit.Builder by lazy {

        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        val builder = OkHttpClient.Builder()
            .readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
            .addInterceptor { chain ->
                val request = chain.request().newBuilder().build()
                chain.proceed(request)
            }

        try {
            builder.addInterceptor(interceptor)
        } catch (e: Exception) {
            e.printStackTrace()
        }

        val okHttpClient1 = builder.build()
        Retrofit.Builder()
            .baseUrl(DataConfig.BASE_URL)
            .client(okHttpClient1)
            .addConverterFactory(GsonConverterFactory.create())
    }

    internal val ApiRequest: ApiEndPoints by lazy {
        retrofitBuilder
            .build()
            .create(ApiEndPoints::class.java)
    }
}