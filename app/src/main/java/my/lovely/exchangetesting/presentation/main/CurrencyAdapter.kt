package my.lovely.exchangetesting.presentation.main

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import my.lovely.exchangetesting.R

class CurrencyAdapter(var currencyNames: List<String>, val currencyValues: List<Double>, private var favouriteBookListener: OnItemClickListener) :
    RecyclerView.Adapter<CurrencyAdapter.CurrencyViewHolder>() {

    private lateinit var context: Context
//    private lateinit var favouriteBookListener: OnItemClickListener

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
        val currencyValue = currencyValues[position]
        holder.tvMainCurrency.text = currencyName
        holder.tvMainCurrencyValue.text = currencyValue.toString()
    }

    fun setFilteredList(currencyNames: List<String>){
        this.currencyNames = currencyNames
        notifyDataSetChanged()
    }

    interface OnItemClickListener{
        fun onItemClick(position: Int)
    }

    fun setOnFavouriteBookListener(listener: OnItemClickListener){
        favouriteBookListener = listener
    }


}