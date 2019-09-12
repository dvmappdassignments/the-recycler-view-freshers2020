
package a.suman.dvmtask

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView


class RecyclerViewAdapter2(private val context: Context, private val items: ArrayList<Itemclass2> ) : RecyclerView.Adapter<ViewHolder2>() {


    override fun getItemCount(): Int{
        return items.size
    }

    @NonNull
    override fun onCreateViewHolder(@NonNull parent: ViewGroup, viewType: Int): ViewHolder2 {
        val layoutInflater = LayoutInflater.from(context)
        val view = layoutInflater.inflate(R.layout.rview2, parent, false)
        return ViewHolder2(view)
    }

    override fun onBindViewHolder(@NonNull holder: ViewHolder2, position: Int) {
        val item=items.get(position)
        holder.textView.setText(item.itemname)
        holder.textView2.setText(item.itemname2)
    }


}

class ViewHolder2(@NonNull itemView: View) : RecyclerView.ViewHolder(itemView) {
    var textView: TextView
    var textView2: TextView
    init {
        textView = itemView.findViewById(R.id.textView2)
        textView2 = itemView.findViewById(R.id.textView2)
    }
}