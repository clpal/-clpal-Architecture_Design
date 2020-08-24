package example.kotlin.room.mvvm.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import example.kotlin.room.mvvm.R
import example.kotlin.room.mvvm.model.LoginTableModel
import kotlinx.android.synthetic.main.custom_view.view.*

class RecyclerViewAdapter(val employees: List<LoginTableModel>) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            : RecyclerViewAdapter.ViewHolder {
        val v: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.custom_view,parent,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: RecyclerViewAdapter.ViewHolder, position: Int) {
        holder.id.text = employees[position].Phone.toString()
        holder.name.text = employees[position].Username.toString()
    }

    override fun getItemCount(): Int {
        return employees.size
    }

    override fun getItemId(position: Int): Long {
        return super.getItemId(position)
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    class ViewHolder(itemView:View): RecyclerView.ViewHolder(itemView){
        val id = itemView.tvId
        val name = itemView.tvName
    }
}