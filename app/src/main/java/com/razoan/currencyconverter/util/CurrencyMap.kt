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
        currencyMap.put("USDANG", quotes?.USDANG)
        currencyMap.put("USDAOA", quotes?.USDAOA)
        currencyMap.put("USDARS", quotes?.USDARS)
        currencyMap.put("USDAUD", quotes?.USDAUD)
        currencyMap.put("USDAWG", quotes?.USDAWG)
        currencyMap.put("USDAZN", quotes?.USDAZN)
        currencyMap.put("USDBAM", quotes?.USDBAM)
        currencyMap.put("USDBBD", quotes?.USDBBD)
        currencyMap.put("USDBDT", quotes?.USDBDT)
        currencyMap.put("USDBGN", quotes?.USDBGN)
        currencyMap.put("USDBHD", quotes?.USDBHD)
        currencyMap.put("USDBIF", quotes?.USDBIF)
        currencyMap.put("USDBMD", quotes?.USDBMD)
        currencyMap.put("USDBND", quotes?.USDBND)
        currencyMap.put("USDBOB", quotes?.USDBOB)
        currencyMap.put("USDBRL", quotes?.USDBRL)
        currencyMap.put("USDBSD", quotes?.USDBSD)
        currencyMap.put("USDBTC", quotes?.USDBTC)
        currencyMap.put("USDBTN", quotes?.USDBTN)
        currencyMap.put("USDBWP", quotes?.USDBWP)
        currencyMap.put("USDBYN", quotes?.USDBYN)
        currencyMap.put("USDBYR", quotes?.USDBYR)
        currencyMap.put("USDBZD", quotes?.USDBZD)
        currencyMap.put("USDCAD", quotes?.USDCAD)
        currencyMap.put("USDCDF", quotes?.USDCDF)
        currencyMap.put("USDCHF", quotes?.USDCHF)
        currencyMap.put("USDCLF", quotes?.USDCLF)
        currencyMap.put("USDCLP", quotes?.USDCLP)
        currencyMap.put("USDCNY", quotes?.USDCNY)
        currencyMap.put("USDCOP", quotes?.USDCOP)
        currencyMap.put("USDCRC", quotes?.USDCRC)
        currencyMap.put("USDCUC", quotes?.USDCUC)
        currencyMap.put("USDCUP", quotes?.USDCUP)
        currencyMap.put("USDCVE", quotes?.USDCVE)
        currencyMap.put("USDCZK", quotes?.USDCZK)
        currencyMap.put("USDDJF", quotes?.USDDJF)
        currencyMap.put("USDDKK", quotes?.USDDKK)
        currencyMap.put("USDDOP", quotes?.USDDOP)
        currencyMap.put("USDDZD", quotes?.USDDZD)
        currencyMap.put("USDEGP", quotes?.USDEGP)
        currencyMap.put("USDERN", quotes?.USDERN)
        currencyMap.put("USDETB", quotes?.USDETB)
        currencyMap.put("USDEUR", quotes?.USDEUR)
        currencyMap.put("USDFJD", quotes?.USDFJD)
        currencyMap.put("USDFKP", quotes?.USDFKP)
        currencyMap.put("USDGBP", quotes?.USDGBP)
        currencyMap.put("USDGEL", quotes?.USDGEL)
        currencyMap.put("USDGGP", quotes?.USDGGP)
        currencyMap.put("USDGHS", quotes?.USDGHS)
        currencyMap.put("USDGIP", quotes?.USDGIP)
        currencyMap.put("USDGMD", quotes?.USDGMD)
        currencyMap.put("USDGNF", quotes?.USDGNF)
        currencyMap.put("USDGTQ", quotes?.USDGTQ)
        currencyMap.put("USDGYD", quotes?.USDGYD)
        currencyMap.put("USDHKD", quotes?.USDHKD)
        currencyMap.put("USDHNL", quotes?.USDHNL)
        currencyMap.put("USDHRK", quotes?.USDHRK)
        currencyMap.put("USDHTG", quotes?.USDHTG)
        currencyMap.put("USDHUF", quotes?.USDHUF)
        currencyMap.put("USDIDR", quotes?.USDIDR)
        currencyMap.put("USDILS", quotes?.USDILS)
        currencyMap.put("USDIMP", quotes?.USDIMP)
        currencyMap.put("USDINR", quotes?.USDINR)
        currencyMap.put("USDIQD", quotes?.USDIQD)
        currencyMap.put("USDIRR", quotes?.USDIRR)
        currencyMap.put("USDISK", quotes?.USDISK)
        currencyMap.put("USDJEP", quotes?.USDJEP)
        currencyMap.put("USDJMD", quotes?.USDJMD)
        currencyMap.put("USDJOD", quotes?.USDJOD)
        currencyMap.put("USDJPY", quotes?.USDJPY)
        currencyMap.put("USDKES", quotes?.USDKES)
        currencyMap.put("USDKGS", quotes?.USDKGS)
        currencyMap.put("USDKHR", quotes?.USDKHR)
        currencyMap.put("USDKMF", quotes?.USDKMF)
        currencyMap.put("USDKPW", quotes?.USDKPW)
        currencyMap.put("USDKRW", quotes?.USDKRW)
        currencyMap.put("USDKWD", quotes?.USDKWD)
        currencyMap.put("USDKYD", quotes?.USDKYD)
        currencyMap.put("USDKZT", quotes?.USDKZT)
        currencyMap.put("USDLAK", quotes?.USDLAK)
        currencyMap.put("USDLBP", quotes?.USDLBP)
        currencyMap.put("USDLKR", quotes?.USDLKR)
        currencyMap.put("USDLRD", quotes?.USDLRD)
        currencyMap.put("USDLSL", quotes?.USDLSL)
        currencyMap.put("USDLTL", quotes?.USDLTL)
        currencyMap.put("USDLVL", quotes?.USDLVL)
        currencyMap.put("USDLYD", quotes?.USDLYD)
        currencyMap.put("USDMAD", quotes?.USDMAD)
        currencyMap.put("USDMDL", quotes?.USDMDL)
        currencyMap.put("USDMGA", quotes?.USDMGA)
        currencyMap.put("USDMKD", quotes?.USDMKD)
        currencyMap.put("USDMMK", quotes?.USDMMK)
        currencyMap.put("USDMNT", quotes?.USDMNT)
        currencyMap.put("USDMOP", quotes?.USDMOP)
        currencyMap.put("USDMRO", quotes?.USDMRO)
        currencyMap.put("USDMUR", quotes?.USDMUR)
        currencyMap.put("USDMVR", quotes?.USDMVR)
        currencyMap.put("USDMWK", quotes?.USDMWK)
        currencyMap.put("USDMXN", quotes?.USDMXN)
        currencyMap.put("USDMYR", quotes?.USDMYR)
        currencyMap.put("USDMZN", quotes?.USDMZN)
        currencyMap.put("USDNAD", quotes?.USDNAD)
        currencyMap.put("USDNGN", quotes?.USDNGN)
        currencyMap.put("USDNIO", quotes?.USDNIO)
        currencyMap.put("USDNOK", quotes?.USDNOK)
        currencyMap.put("USDNPR", quotes?.USDNPR)
        currencyMap.put("USDNZD", quotes?.USDNZD)
        currencyMap.put("USDOMR", quotes?.USDOMR)
        currencyMap.put("USDPAB", quotes?.USDPAB)
        currencyMap.put("USDPEN", quotes?.USDPEN)
        currencyMap.put("USDPGK", quotes?.USDPGK)
        currencyMap.put("USDPHP", quotes?.USDPHP)
        currencyMap.put("USDPKR", quotes?.USDPKR)
        currencyMap.put("USDPLN", quotes?.USDPLN)
        currencyMap.put("USDPYG", quotes?.USDPYG)
        currencyMap.put("USDQAR", quotes?.USDQAR)
        currencyMap.put("USDRON", quotes?.USDRON)
        currencyMap.put("USDRSD", quotes?.USDRSD)
        currencyMap.put("USDRUB", quotes?.USDRUB)
        currencyMap.put("USDRWF", quotes?.USDRWF)
        currencyMap.put("USDSAR", quotes?.USDSAR)
        currencyMap.put("USDSBD", quotes?.USDSBD)
        currencyMap.put("USDSCR", quotes?.USDSCR)
        currencyMap.put("USDSDG", quotes?.USDSDG)
        currencyMap.put("USDSEK", quotes?.USDSEK)
        currencyMap.put("USDSGD", quotes?.USDSGD)
        currencyMap.put("USDSHP", quotes?.USDSHP)
        currencyMap.put("USDSLL", quotes?.USDSLL)
        currencyMap.put("USDSOS", quotes?.USDSOS)
        currencyMap.put("USDSRD", quotes?.USDSRD)
        currencyMap.put("USDSTD", quotes?.USDSTD)
        currencyMap.put("USDSVC", quotes?.USDSVC)
        currencyMap.put("USDSYP", quotes?.USDSYP)
        currencyMap.put("USDSZL", quotes?.USDSZL)
        currencyMap.put("USDTHB", quotes?.USDTHB)
        currencyMap.put("USDTJS", quotes?.USDTJS)
        currencyMap.put("USDTMT", quotes?.USDTMT)
        currencyMap.put("USDTND", quotes?.USDTND)
        currencyMap.put("USDTOP", quotes?.USDTOP)
        currencyMap.put("USDTRY", quotes?.USDTRY)
        currencyMap.put("USDTTD", quotes?.USDTTD)
        currencyMap.put("USDTWD", quotes?.USDTWD)
        currencyMap.put("USDTZS", quotes?.USDTZS)
        currencyMap.put("USDUAH", quotes?.USDUAH)
        currencyMap.put("USDUGX", quotes?.USDUGX)
        currencyMap.put("USDUSD", quotes?.USDUSD)
        currencyMap.put("USDUYU", quotes?.USDUYU)
        currencyMap.put("USDUZS", quotes?.USDUZS)
        currencyMap.put("USDVEF", quotes?.USDVEF)
        currencyMap.put("USDVND", quotes?.USDVND)
        currencyMap.put("USDVUV", quotes?.USDVUV)
        currencyMap.put("USDWST", quotes?.USDWST)
        currencyMap.put("USDXAF", quotes?.USDXAF)
        currencyMap.put("USDXAG", quotes?.USDXAG)
        currencyMap.put("USDXAU", quotes?.USDXAU)
        currencyMap.put("USDXCD", quotes?.USDXCD)
        currencyMap.put("USDXDR", quotes?.USDXDR)
        currencyMap.put("USDXOF", quotes?.USDXOF)
        currencyMap.put("USDXPF", quotes?.USDXPF)
        currencyMap.put("USDYER", quotes?.USDYER)
        currencyMap.put("USDZAR", quotes?.USDZAR)
        currencyMap.put("USDZMK", quotes?.USDZMK)
        currencyMap.put("USDZMW", quotes?.USDZMW)
        currencyMap.put("USDZWL", quotes?.USDZWL)
    }
}