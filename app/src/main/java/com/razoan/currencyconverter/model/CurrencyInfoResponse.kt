package com.razoan.currencyconverter.model

import com.google.gson.annotations.SerializedName

class CurrencyInfoResponse {
    @field:SerializedName("success")
    var success: Boolean? = null

    @field:SerializedName("quotes")
    val quotes: USDToAnother? = null
}

class USDToAnother {
    @field:SerializedName("USDAED")
    val USDAED: Double? = null

    @field:SerializedName("USDAFN")
    val USDAFN: Double? = null

    @field:SerializedName("USDALL")
    val USDALL: Double? = null

    @field:SerializedName("USDAMD")
    val USDAMD: Double? = null

    @field:SerializedName("USDBDT")
    val USDBDT: Double? = null
}

