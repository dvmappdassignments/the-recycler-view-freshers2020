package com.example.notes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.content.Intent
import com.google.android.material.floatingactionbutton.FloatingActionButton
import androidx.recyclerview.widget.ItemTouchHelper





    class MainActivity : AppCompatActivity(){

    private var db: FirebaseFirestore =FirebaseFirestore.getInstance()
    private  var notebookRef:CollectionReference=db.collection("Notebook")

    private var adapter: NoteAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var buttonAddNote:FloatingActionButton = findViewById(R.id.button_add_note)
        buttonAddNote.setOnClickListener { startActivity(Intent(
             this,
            NewNoteActivity::class.java
        )) }

        setUpRecyclerView()
    }

    private fun setUpRecyclerView(){

        var query = notebookRef

        var options = FirestoreRecyclerOptions.Builder<Note>()
            .setQuery(query, Note::class.java)
            .build()

        adapter = NoteAdapter(options)

        var recyclerView:RecyclerView = findViewById(R.id.recycler_view)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(
            0,
            ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
        ) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                adapter!!.deleteItem(viewHolder.adapterPosition)
            }
        }).attachToRecyclerView(recyclerView)

    }

    override fun onStart() {
        super.onStart()
        adapter?.startListening()
    }

    override fun onStop() {
        super.onStop()
        adapter?.stopListening()
    }
}
