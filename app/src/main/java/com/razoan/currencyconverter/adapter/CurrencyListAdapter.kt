package com.razoan.currencyconverter.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.razoan.currencyconverter.R
import com.razoan.currencyconverter.util.CurrencyMap

class CurrencyListAdapter(var listener: OnCurrencyTypeItemClickListener) :
    RecyclerView.Adapter<CurrencyListAdapter.TypeViewHolder>() {

    lateinit var context: Context
    private var lastSelectedPosition = -1
    var currencyListFull: LinkedHashMap<String, Double?> = LinkedHashMap()

    init {
        currencyListFull = CurrencyMap.currencyMap
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TypeViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.item_currency_type, parent, false)
        return TypeViewHolder(view)
    }

    override fun getItemCount(): Int {
        return currencyListFull.size
    }

    override fun onBindViewHolder(holder: TypeViewHolder, position: Int) {
        val currentItem = getHashMapKeyFromIndex(currencyListFull, position)
        holder.textView.text = currentItem?.substring(3)
        holder.radioButton.isChecked = lastSelectedPosition == position
    }

    inner class TypeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var radioButton: RadioButton = itemView.findViewById<RadioButton>(R.id.rbSelectCurrencyType)
        val textView: TextView = itemView.findViewById<TextView>(R.id.tvSelectCurrencyType)

        init {
            itemView.setOnClickListener(View.OnClickListener {
                when {
                    adapterPosition >= 0 -> {
                        lastSelectedPosition = adapterPosition
                        listener.onCurrencyTypeItemClick(
                            getHashMapKeyFromIndex(
                                currencyListFull,
                                adapterPosition
                            ),
                            currencyListFull.get(
                                getHashMapKeyFromIndex(
                                    currencyListFull,
                                    adapterPosition
                                )
                            )
                        )
                        notifyDataSetChanged()
                    }
                }
            })
            radioButton.setOnClickListener(View.OnClickListener {
                when {
                    adapterPosition >= 0 -> {
                        lastSelectedPosition = adapterPosition
                        listener.onCurrencyTypeItemClick(
                            getHashMapKeyFromIndex(
                                currencyListFull,
                                adapterPosition
                            ),
                            currencyListFull.get(
                                getHashMapKeyFromIndex(
                                    currencyListFull,
                                    adapterPosition
                                )
                            )
                        )
                        notifyDataSetChanged()
                    }
                }
            })
        }
    }

    private fun getHashMapKeyFromIndex(
        currencyListFull: HashMap<String, Double?>,
        position: Int
    ): String? {
        var key: String? = null
        val hs: HashMap<String, Double?> = currencyListFull
        var pos = 0
        for ((key1) in hs.entries) {
            if (position == pos) {
                key = key1
            }
            pos++
        }
        return key
    }

    interface OnCurrencyTypeItemClickListener {
        fun onCurrencyTypeItemClick(selectedCurrencyType: String?, conversionRate: Double?)
    }
}