package com.example.notes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions



class NoteAdapter:FirestoreRecyclerAdapter<Note,NoteAdapter.NoteHolder> {


    constructor(options: FirestoreRecyclerOptions<Note>) : super(options)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteHolder {

        var v:View=LayoutInflater.from(parent.context).inflate(R.layout.note_item,parent,false)
        return NoteHolder(v)
    }

    override fun onBindViewHolder(p0: NoteHolder, p1: Int, p2: Note) {
        p0.textViewTitle.text=p2.getTitle()
        p0.textViewDescription.text=p2.getDescription()
    }

    fun deleteItem(position:Int){

        snapshots.getSnapshot(position).reference.delete()
    }

    class NoteHolder: RecyclerView.ViewHolder{

        var textViewTitle:TextView
        var textViewDescription:TextView

        constructor(itemView: View) : super(itemView){
            textViewTitle=itemView.findViewById(R.id.text_view_title)
            textViewDescription=itemView.findViewById(R.id.text_view_description)


        }
    }
}