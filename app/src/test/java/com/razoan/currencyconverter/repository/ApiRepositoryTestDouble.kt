package com.razoan.currencyconverter.repository

import com.razoan.currencyconverter.apiclient.Resource
import com.razoan.currencyconverter.model.CurrencyInfoResponse

object ApiRepositoryTestDouble {

    private var shouldReturnNetworkError = false

    fun setShouldReturnNetworkError(value: Boolean): Boolean {
        shouldReturnNetworkError = value
        return shouldReturnNetworkError
    }

    fun getCurrencyInfo(internetConnectivity: Boolean): Resource<CurrencyInfoResponse> {
        return if (!internetConnectivity) {
            Resource.error("An error happens", null)
        } else {
            CurrencyInfoResponse().success = true
            Resource.success(CurrencyInfoResponse())
        }
    }
}