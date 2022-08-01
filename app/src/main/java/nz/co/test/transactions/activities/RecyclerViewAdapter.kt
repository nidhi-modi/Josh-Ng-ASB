package nz.co.test.transactions.activities

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import nz.co.test.transactions.R
import nz.co.test.transactions.model.RecyclerData
import java.text.SimpleDateFormat
import java.util.*


class RecyclerViewAdapter: RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {

    private var listData: List<RecyclerData>? = null

    fun setUpdatedData(listData: List<RecyclerData>) {
        this.listData = listData
    }

    class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val textviewName = view.findViewById<TextView>(R.id.textviewName);
        val textviewDescription = view.findViewById<TextView>(R.id.textviewDescription)

        fun bind(data: RecyclerData) {

            val simpleDateFormat = SimpleDateFormat("EEEE, dd-MMM-yyyy hh-mm-ss a")
            val dateTime = simpleDateFormat.format(data.transactionDate)
            textviewName.text = dateTime
            textviewDescription.setText(data.summary)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_list_row, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        if(listData == null)return 0
        else return listData?.size!!
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(listData?.get(position)!!)
    }
}