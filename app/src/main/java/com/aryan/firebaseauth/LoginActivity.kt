package com.aryan.firebaseauth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.*

class LoginActivity : AppCompatActivity() {

    lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        auth = FirebaseAuth.getInstance()
        login()
        bt_navigate_reg.setOnClickListener {
            startActivity(Intent(this@LoginActivity,RegisterActivity::class.java))
            finish()
        }
    }
    private fun login(){
        bt_login.setOnClickListener {
            if(TextUtils.isEmpty(et_email.text.toString())){
                Toast.makeText(this,"Please Enter all the details ", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }else if (TextUtils.isEmpty(et_password.text.toString())){
                Toast.makeText(this,"Please Enter all the details ", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            auth.signInWithEmailAndPassword(et_email.text.toString(),et_password.text.toString())
                .addOnCompleteListener {
                    if(it.isSuccessful){
                        startActivity(Intent(this@LoginActivity,MainActivity::class.java))
                        finish()
                    }else{
                        Toast.makeText(this,"login not successful ",Toast.LENGTH_LONG).show()
                    }
                }
        }
    }
}