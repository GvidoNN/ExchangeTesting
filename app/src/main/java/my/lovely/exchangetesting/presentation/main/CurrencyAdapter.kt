package my.lovely.exchangetesting.presentation.main

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import my.lovely.exchangetesting.R

class CurrencyAdapter(private val currencyNames: List<String>, private val currencyValues: List<Double>) :
    RecyclerView.Adapter<CurrencyAdapter.CurrencyViewHolder>() {

    private lateinit var context: Context
//    private lateinit var currencyListener: OnItemClickListener


//    , listener: OnItemClickListener
    class CurrencyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val tvMainCurrency: TextView = itemView.findViewById(R.id.tvMainCurrency)
        val tvMainCurrencyValue: TextView = itemView.findViewById(R.id.tvMainCurrencyValue)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyViewHolder {
        context = parent.context
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_exchange, parent, false)
        return CurrencyViewHolder(view)
//        , currencyListener
    }

    override fun getItemCount(): Int {
        return currencyNames.size
    }

    override fun onBindViewHolder(holder: CurrencyViewHolder, position: Int) {
        val currencyName = currencyNames[position]
        val currencyValue = currencyValues[position]
        holder.tvMainCurrency.text = currencyName
        holder.tvMainCurrencyValue.text = currencyValue.toString()
    }


//    interface OnItemClickListener{
//        fun onItemClick(position: Int)
//    }

//    fun setOnItemClickListener(listener: OnItemClickListener){
//        currencyListener = listener
//    }

}