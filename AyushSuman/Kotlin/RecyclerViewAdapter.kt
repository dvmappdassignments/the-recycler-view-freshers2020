package a.suman.dvmtask

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView


class RecyclerViewAdapter(private val context: Context, private val items: ArrayList<Itemclass> ) : RecyclerView.Adapter<ViewHolder>() {


    override fun getItemCount(): Int{
        return items.size
    }

    @NonNull
    override fun onCreateViewHolder(@NonNull parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(context)
        val view = layoutInflater.inflate(R.layout.rview, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(@NonNull holder: ViewHolder, position: Int) {
        val item=items.get(position)
        holder.textView.setText(item.itemname)
    }


}

class ViewHolder(@NonNull itemView: View) : RecyclerView.ViewHolder(itemView) {
    var textView: TextView
    init {
        textView = itemView.findViewById(R.id.textView2)
    }
}