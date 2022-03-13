package com.razoan.currencyconverter.util

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.os.Build
import android.widget.Toast
import java.text.NumberFormat
import java.util.*

class CommonUtil {
    companion object {
        fun currencyFormatter(amount: Double?, type: String?): String? {
            val format: NumberFormat = NumberFormat.getCurrencyInstance()
            format.maximumFractionDigits = 5
            format.currency = Currency.getInstance(type)
            return format.format((amount))
        }

        fun showToast(context: Context?, msg: String?) {
            Toast.makeText(context, msg, Toast.LENGTH_LONG).show()
        }

        @JvmStatic
        fun isNetworkConnected(context: Context?): Boolean {
            val cm = context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

            val n: Network? = cm.activeNetwork
            if (n != null) {
                val nc: NetworkCapabilities? = cm.getNetworkCapabilities(n)
                return nc?.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) == true || nc?.hasTransport(
                    NetworkCapabilities.TRANSPORT_WIFI) == true || nc?.hasTransport(
                    NetworkCapabilities.TRANSPORT_VPN) == true
            }
            return false
        }
    }
}