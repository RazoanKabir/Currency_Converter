package com.razoan.currencyconverter.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.razoan.currencyconverter.apiclient.Resource
import com.razoan.currencyconverter.databinding.ActivityMainBinding
import com.razoan.currencyconverter.model.CurrencyInfoResponse
import com.razoan.currencyconverter.repository.ApiRepository
import com.razoan.currencyconverter.util.CommonUtil
import com.razoan.currencyconverter.util.Constant.Companion.maxInput
import com.razoan.currencyconverter.util.CurrencyMap
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CurrencyConverterVM : ViewModel() {
    private var binding: ActivityMainBinding? = null
    val _currencyInfoLiveData = MutableLiveData<Resource<CurrencyInfoResponse>>()
    var currencyInfoData: CurrencyInfoResponse? = null
    var currentRate: Double? = null
    var type: String? = null
    private var currentAmount: String? = ""

    fun getCurrencyInfo() {
        ApiRepository.getCurrencyInfo(object : GetCurrencyInfoCallBack {
            override fun getCurrencyInfoCallBackResponse(response: Resource<CurrencyInfoResponse>) {
                currencyInfoData = response.data
                _currencyInfoLiveData.value = response
            }
        })
    }

    fun onOperatorAdd(addedCurrency: String) {
        try {
            if (currentAmount!!.toLong() >= maxInput) {
                return
            }
        } catch (e: Exception) {
        }
        if (addedCurrency.equals(".") && currentAmount?.contains(".") == true) return
        currentAmount += addedCurrency
        conversionRate(currentAmount?.toDouble()!!)
    }

    fun onClearAll() {
        currentAmount = ""
        conversionRate(1.0)
    }

    private fun conversionRate(currentAmount: Double) {
        val currentUSDAccordingToAmount = (currentAmount / currentRate!!)
        binding?.tvUSDAmount?.text =
            CommonUtil.currencyFormatter(currentUSDAccordingToAmount, "USD")
        binding?.tvOtherCurrencyAmount?.text = CommonUtil.currencyFormatter(currentAmount, type)
    }

    fun setInitialData(context: Context) {
        CurrencyMap(context)
        binding?.tvOtherCurrencySign?.text =
            getKey(CurrencyMap.currencyMap, CurrencyMap.currencyMap["USDJPY"]).substring(3)
        binding?.tvOtherCurrencyAmount?.text = CurrencyMap.currencyMap["USDJPY"].toString()
        currentRate = CurrencyMap.currencyMap["USDJPY"]
        type = "JPY"
        conversionRate(1.0)
    }

    fun setCurrencySelectionData(type: String?, rate: Double?, binding: ActivityMainBinding) {
        if (type?.length == 6)
            this.type = type.substring(3)
        else
            this.type = type
        binding.tvOtherCurrencySign.text = this.type
        currentRate = rate
        onClearAll()
    }

    private fun <K, V> getKey(hashMap: Map<K, V>, target: V): K {
        return hashMap.filter { target == it.value }.keys.first()
    }

    fun setBindings(binding: ActivityMainBinding) {
        this.binding = binding
    }

    interface GetCurrencyInfoCallBack {
        fun getCurrencyInfoCallBackResponse(response: Resource<CurrencyInfoResponse>)
    }

    fun conversionTest(currentAmount: Double, conversionRate: Double): Double {
        return (currentAmount / conversionRate)
    }
}