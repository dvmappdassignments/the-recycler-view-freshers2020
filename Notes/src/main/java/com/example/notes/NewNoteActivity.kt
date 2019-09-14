package com.example.notes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.EditText
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore


class NewNoteActivity : AppCompatActivity() {

    var editTextTitle: EditText? = null
    var editTextDescription: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_note)

        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_close)

        editTextTitle = findViewById(R.id.edit_text_title)
        editTextDescription = findViewById(R.id.edit_text_description)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        var menuInflater:MenuInflater=menuInflater
        menuInflater.inflate(R.menu.new_note_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.save_note -> {
                saveNote()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    private fun saveNote(){

        var title:String= editTextTitle?.text.toString()
        var description:String= editTextDescription?.text.toString()

        if (title.trim().isEmpty() || description.trim().isEmpty()) {
            Toast.makeText(this, "Please insert a title and description", Toast.LENGTH_LONG).show()
            return
        }

        var notebookRef:CollectionReference=FirebaseFirestore.getInstance().collection("Notebook")
        notebookRef.add(Note(title, description))
        Toast.makeText(this,"Note Added",Toast.LENGTH_LONG).show()
        finish()
    }
}
