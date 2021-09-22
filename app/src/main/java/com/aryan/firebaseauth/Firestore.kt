package com.aryan.firebaseauth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_firestore.*


class Firestore : AppCompatActivity() {

    private lateinit var database  :DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_firestore)

        button.setOnClickListener {
            val name = et_name.text.toString()
            val user = User(name)
            database = FirebaseDatabase.getInstance().getReference("Users")
            database.child("Users").setValue(user).addOnCompleteListener {
                Toast.makeText(this,"Registration not successful ", Toast.LENGTH_LONG).show()
            }.addOnFailureListener {
                Toast.makeText(this,"Registration successful ",Toast.LENGTH_LONG).show()
            }
        }
    }
}