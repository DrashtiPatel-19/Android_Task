package com.crm.task1

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputLayout

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        window.statusBarColor = Color.rgb(237,229,229 )
        var tv_email = findViewById<TextInputLayout>(R.id.email)
        var tv_password = findViewById<TextInputLayout>(R.id.password)
        var btn_login = findViewById<Button>(R.id.login)

        btn_login.setOnClickListener {

            var email = tv_email.editText?.text.toString().trim()
            var pass = tv_password.editText?.text.toString().trim()

            if(email.equals("test@android.com") && pass.equals("123456"))
            {
                var intent = Intent(LoginActivity@this , MainActivity::class.java)
                startActivity(intent)
                finish()
            }
            else{
                var snackbar = Snackbar.make(it, "Please Enter Valid Credentials",Snackbar.LENGTH_LONG).show()
            }

        }
    }
}