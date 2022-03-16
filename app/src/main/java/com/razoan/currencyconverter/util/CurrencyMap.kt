package com.razoan.currencyconverter.util

import android.content.Context
import com.google.gson.Gson
import com.razoan.currencyconverter.model.CurrencyInfoResponse
import com.razoan.currencyconverter.model.USDToAnother

class CurrencyMap(context: Context) {

    companion object {
        var currencyMap: LinkedHashMap<String, Double?> = LinkedHashMap()
    }

    init {
        val quotes = Gson().fromJson(
            CurrencyPreference(context).currencyInfo,
            CurrencyInfoResponse::class.java
        ).quotes
        setCurrencyRate(quotes)
    }

    private fun setCurrencyRate(quotes: USDToAnother?) {
        currencyMap.put("USDAED", quotes?.USDAED)
        currencyMap.put("USDAFN", quotes?.USDAFN)
        currencyMap.put("USDALL", quotes?.USDALL)
        currencyMap.put("USDAMD", quotes?.USDAMD)
        currencyMap.put("USDBDT", quotes?.USDBDT)
    }
}
