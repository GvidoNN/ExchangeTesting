package my.lovely.exchangetesting.presentation.main

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import my.lovely.exchangetesting.R

class CurrencyAdapter(var currencyNames: List<String>, var currencyValues: List<Double>, private var favouriteBookListener: OnItemClickListener) :
    RecyclerView.Adapter<CurrencyAdapter.CurrencyViewHolder>() {

    private lateinit var context: Context

    class CurrencyViewHolder(itemView: View, favouriteListener: OnItemClickListener) : RecyclerView.ViewHolder(itemView) {

        val tvMainCurrency: TextView = itemView.findViewById(R.id.tvMainCurrency)
        val tvMainCurrencyValue: TextView = itemView.findViewById(R.id.tvMainCurrencyValue)

        init {
            itemView.setOnClickListener{
                favouriteListener.onItemClick(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyViewHolder {
        context = parent.context
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_exchange, parent, false)
        return CurrencyViewHolder(view, favouriteBookListener)
    }

    override fun getItemCount(): Int {
        return currencyNames.size
    }

    override fun onBindViewHolder(holder: CurrencyViewHolder, position: Int) {
        val currencyName = currencyNames[position]
        Log.d("MyLog", currencyName)
        val index = currencyNames.indexOf(currencyName)
        Log.d("MyLog",index.toString())
        val currencyValue = currencyValues[position]
        Log.d("MyLog",currencyValue.toString())
        Log.d("MyLog",currencyValues[index].toString())
        holder.tvMainCurrency.text = currencyName
        holder.tvMainCurrencyValue.text = currencyValue.toString()
    }

    fun setFilteredList(currencyNames: List<String>, currencyValues: List<Double>) {
        this.currencyNames = currencyNames
        this.currencyValues = currencyValues
        notifyDataSetChanged()
    }

    interface OnItemClickListener{
        fun onItemClick(position: Int)
    }
}