package com.razoan.currencyconverter.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.common.truth.Truth.assertThat
import com.razoan.currencyconverter.apiclient.Resource
import com.razoan.currencyconverter.model.CurrencyInfoResponse
import com.razoan.currencyconverter.repository.ApiRepositoryTestDouble
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class CurrencyConverterVMTest {

    @get: Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var currencyConverterVM: CurrencyConverterVM

    @Before
    fun setUp() {
        currencyConverterVM = CurrencyConverterVM()
    }

    @Test
    fun checkInternetBeforeApi() {
        val internetConnectivity = ApiRepositoryTestDouble.setShouldReturnNetworkError(true)
        assertThat(internetConnectivity).isTrue()
    }

    @Test
    fun getCurrencyInfoWithoutInternet() {
        val internetConnectivity = false
        val currencyInfo: Resource<CurrencyInfoResponse> =
            ApiRepositoryTestDouble.getCurrencyInfo(internetConnectivity)
        assertThat(currencyInfo.status).isEqualTo(Resource.Status.ERROR)
    }

    @Test
    fun getCurrencyInfoWithInternet() {
        val internetConnectivity = true
        val currencyInfo: Resource<CurrencyInfoResponse> =
            ApiRepositoryTestDouble.getCurrencyInfo(internetConnectivity)
        assertThat(currencyInfo.status).isEqualTo(Resource.Status.SUCCESS)
    }

    @Test
    fun checkConversionRate() {
        val rateBDT = currencyConverterVM.conversionTest(100.00, 85.00)
        assertThat(rateBDT).isEqualTo(100.00 / 85.00)
    }
}