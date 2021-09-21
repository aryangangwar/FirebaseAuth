package com.aryan.firebaseauth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database

import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

     lateinit var auth : FirebaseAuth
    // lateinit var databaseReference : DatabaseReference
    // var database : FirebaseDatabase?= null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val database = Firebase.database
        val myRef = database.getReference("message")

        myRef.setValue("Hello, World!")

        auth =  FirebaseAuth.getInstance();
        //database = FirebaseDatabase.getInstance()
        //databaseReference = database?.reference!!.child("User Profile")           // User profile
        register()
        bt_navigate_login.setOnClickListener {
            startActivity(Intent(this@RegisterActivity,LoginActivity::class.java))
            finish()
        }

    }

    private fun register(){
        bt_register.setOnClickListener {
            if(TextUtils.isEmpty(et_firstname.text.toString())){
                Toast.makeText(this,"Please Enter all the details ",Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }else if (TextUtils.isEmpty(et_lastname.text.toString())){
                Toast.makeText(this,"Please Enter all the details ",Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }else if(TextUtils.isEmpty(et_email_reg.text.toString())){
                Toast.makeText(this,"Please Enter all the details ",Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }else if (TextUtils.isEmpty(et_password_reg.text.toString())){
                Toast.makeText(this,"Please Enter all the details ",Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            auth.createUserWithEmailAndPassword(et_email_reg.text.toString(),et_password_reg.text.toString())
                .addOnCompleteListener {
                    if(it.isSuccessful){
                      //  val currentUser = auth.currentUser
                       // val currentUserDb = databaseReference?.child(currentUser?.uid!!)
                       // currentUserDb.child("First Name").setValue(et_firstname.text.toString())
                      //  currentUserDb.child("Last Name").setValue(et_lastname.text.toString())
                        Toast.makeText(this,"Registration successful ",Toast.LENGTH_LONG).show()
                        startActivity(Intent(this@RegisterActivity,LoginActivity::class.java))
                        finish()
                    }else{
                        Toast.makeText(this,"Registration not successful ",Toast.LENGTH_LONG).show()
                    }
                }


        }
    }
}