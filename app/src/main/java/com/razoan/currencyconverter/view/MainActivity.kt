package com.razoan.currencyconverter.view

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.constraintlayout.widget.Group
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.gson.Gson
import com.jakewharton.rxbinding.view.RxView
import com.razoan.currencyconverter.R
import com.razoan.currencyconverter.databinding.ActivityMainBinding
import com.razoan.currencyconverter.fragment.CurrencyListDialogFragment
import com.razoan.currencyconverter.model.CurrencyInfoResponse
import com.razoan.currencyconverter.util.CommonUtil
import com.razoan.currencyconverter.util.CurrencyPreference
import com.razoan.currencyconverter.util.DataPreference
import com.razoan.currencyconverter.viewmodel.CurrencyConverterVM
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity(), CurrencyListDialogFragment.DialogCurrencyTypeListener {
    private lateinit var binding: ActivityMainBinding
    private val context: Context = this
    private var currencyConverterVM: CurrencyConverterVM? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initVm()
        initBindings()
        initApiCall()
        setObserver()
        initListener()
    }

    private fun initListener() {
        val group = findViewById<Group>(R.id.grpOpenDialog)
        val refIds = group.referencedIds
        for (id in refIds) {
            findViewById<View>(id).setOnClickListener {
                openCurrencyDialog()
            }
        }
    }

    private fun setObserver() {
        currencyConverterVM?._currencyInfoLiveData?.observe(this, Observer {
            if (it != null && it.data?.success == true) {
                setDataInVM(it.data)
            }
        })
    }

    private fun initApiCall() {
        if (Gson().fromJson(
                CurrencyPreference(context).currencyInfo,
                CurrencyInfoResponse::class.java
            ) != null
        )
            setDataInVM(
                Gson().fromJson(
                    CurrencyPreference(context).currencyInfo,
                    CurrencyInfoResponse::class.java
                )
            )
        else {
            if (CommonUtil.isNetworkConnected(context))
                currencyConverterVM?.getCurrencyInfo()
            else CommonUtil.showToast(context, getString(R.string.noInternet))
        }

    }

    private fun setDataInVM(data: CurrencyInfoResponse) {
        CurrencyPreference(context).currencyInfo = Gson().toJson(data)
        currencyConverterVM?.setInitialData(context)
        callApiAfterDelay()
    }

    private fun initBindings() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.let {
            it.viewModel = currencyConverterVM
            it.lifecycleOwner = this
        }
        currencyConverterVM?.setBindings(binding)
    }

    private fun initVm() {
        currencyConverterVM = ViewModelProvider(this).get(CurrencyConverterVM::class.java)
    }

    private fun openCurrencyDialog() {
        val dialog = CurrencyListDialogFragment()
        dialog.show(supportFragmentManager, getString(R.string.currencyFragment))
    }

    private var doubleBackToExitPressedOnce = false
    private fun exitAppWithConfirmation() {
        if (doubleBackToExitPressedOnce) {
            overridePendingTransition(R.anim.right_in, R.anim.left_out)
            finish()
            return
        }
        this.doubleBackToExitPressedOnce = true
        CommonUtil.showToast(context, getString(R.string.closeApp))
        Handler().postDelayed({ doubleBackToExitPressedOnce = false }, 1000)
    }

    private fun callApiAfterDelay() {
        GlobalScope.launch {
            delay(1800000)
            DataPreference().clearPreference(context)
            finish()
            overridePendingTransition(R.anim.right_in, R.anim.left_out)
            startActivity(intent);
            overridePendingTransition(R.anim.left_out, R.anim.right_in)
        }
    }

    override fun onBackPressed() {
        exitAppWithConfirmation()
    }

    override fun selectedCurrencyType(type: String?, rate: Double?) {
        currencyConverterVM?.setCurrencySelectionData(type, rate, binding)
    }
}