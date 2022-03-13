package com.razoan.currencyconverter.util

import android.content.Context
import android.content.SharedPreferences
import com.razoan.currencyconverter.util.PrefKeys.Companion.PREF_KEY_PREF_NAME

class PrefEditor(context: Context) {
    var preference: SharedPreferences? = null

    init {
        preference = DataPreference().getPreference(context)
    }

    fun getString(key: String, defValue: String? = null): String? {
        val str = preference?.getString(key, defValue)
        return if (str.isNullOrEmpty() || str == "null") null
        else str
    }

    fun setString(key: String, value: String?) {
        preference?.edit()?.putString(key, value)?.apply()
    }
}

class DataPreference {

    fun getPreference(context: Context): SharedPreferences {
        return context.getSharedPreferences(PREF_KEY_PREF_NAME, Context.MODE_PRIVATE)
    }

    fun clearPreference(context: Context) {
        getPreference(context).edit().clear().apply()
    }
}