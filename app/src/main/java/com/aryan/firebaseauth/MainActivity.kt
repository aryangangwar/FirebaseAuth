package com.aryan.firebaseauth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {
    lateinit var auth : FirebaseAuth
    lateinit var databaseReference : DatabaseReference
    var database : FirebaseDatabase?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        auth =  FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance()
        databaseReference = database?.reference!!.child("User Profile")

    }
}