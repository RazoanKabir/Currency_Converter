package com.razoan.currencyconverter.fragment

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import androidx.annotation.NonNull
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatDialogFragment
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.razoan.currencyconverter.R
import com.razoan.currencyconverter.adapter.CurrencyListAdapter


class CurrencyListDialogFragment : AppCompatDialogFragment(),
    CurrencyListAdapter.OnCurrencyTypeItemClickListener {

    private var rootView: View? = null
    private var listener: DialogCurrencyTypeListener? = null
    private var rvView: RecyclerView? = null
    var adapter: CurrencyListAdapter? = null
    private var type: String? = ""
    var rate: Double? = 0.0

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val inflater = requireActivity().layoutInflater
        rootView = inflater.inflate(R.layout.fragment_currency_list_dialog, null)
        insertData()

        val builder = AlertDialog.Builder(requireContext(), R.style.DialogListStyle)
        builder.setView(rootView)
            .setTitle("Select your currency:")
            .setNegativeButton("close", DialogInterface.OnClickListener { dialog, which ->
                dismiss()
            })
            .setPositiveButton("select", DialogInterface.OnClickListener { dialog, which ->
                listener?.selectedCurrencyType(type, rate)
                dismiss()
            })

        val alert = builder.create()
        alert.setOnShowListener { arg0: DialogInterface? ->
            alert.getButton(AlertDialog.BUTTON_NEGATIVE)
                .setTextColor(ContextCompat.getColorStateList(requireContext(), R.color.dialogbtn))
            alert.getButton(AlertDialog.BUTTON_POSITIVE)
                .setTextColor(ContextCompat.getColorStateList(requireContext(), R.color.dialogbtn))
        }
        alert.show()

        return alert
    }

    interface DialogCurrencyTypeListener {
        fun selectedCurrencyType(type: String?, rate: Double?)
    }

    override fun onAttach(@NonNull context: Context) {
        super.onAttach(context)
        listener = try {
            context as DialogCurrencyTypeListener?
        } catch (e: ClassCastException) {
            throw ClassCastException(
                context.toString() +
                        "must implement ExampleDialogListener"
            )
        }
    }
    private fun insertData() {
        setRecyclerView()
    }

    override fun onCurrencyTypeItemClick(selectedCurrencyType: String?, conversionRate: Double?) {
        type = selectedCurrencyType
        rate = conversionRate
    }

    private fun setRecyclerView() {
        adapter = CurrencyListAdapter(this)
        rvView = rootView?.findViewById(R.id.rvCurrencyType)
        rvView?.layoutManager = LinearLayoutManager(activity)
        rvView?.isVerticalScrollBarEnabled = true
        rvView?.setHasFixedSize(true)
        rvView?.adapter = adapter
    }
}