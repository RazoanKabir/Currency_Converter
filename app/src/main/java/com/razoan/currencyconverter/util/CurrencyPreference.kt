package com.razoan.currencyconverter.util

import android.content.Context
import com.razoan.currencyconverter.util.PrefKeys.Companion.PREF_KEY_CURRENCY_INFO

class CurrencyPreference(context: Context) {
    var editor: PrefEditor? = null

    init {
        editor = PrefEditor(context)
    }

    var currencyInfo: String?
        get() {
            return editor?.getString(PREF_KEY_CURRENCY_INFO)
        }
        set(value) {
            editor?.setString(PREF_KEY_CURRENCY_INFO, value)
        }
}