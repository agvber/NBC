package com.agvber.my_info

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class SignInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)


        val idEditText = findViewById<EditText>(R.id.id_edit_text)
        val passwordEditText = findViewById<EditText>(R.id.password_edit_text)

        val loginButton = findViewById<Button>(R.id.login_button)
        val registerButton = findViewById<Button>(R.id.register_button)

        loginButton.setOnClickListener {
            if (idEditText.text.isBlank() || passwordEditText.text.isBlank()) {
                showLoginFailedToast()
                return@setOnClickListener
            }
            startSignUpActivity(idEditText.text.toString(), passwordEditText.text.toString())
            showLoginSuccessToast()
        }

        registerButton.setOnClickListener {
            if (idEditText.text.isBlank() || passwordEditText.text.isBlank()) {
                showLoginFailedToast()
                return@setOnClickListener
            }
            startSignUpActivity(idEditText.text.toString(), passwordEditText.text.toString())
        }
    }

    private fun showLoginFailedToast() {
        Toast.makeText(this, "아이디/비밀번호를 확인해주세요", Toast.LENGTH_SHORT).show()
    }

    private fun showLoginSuccessToast() {
        Toast.makeText(this, "로그인 성공", Toast.LENGTH_SHORT).show()
    }

    private fun startHomeActivity(id: String, password: String) {
        val intent = Intent(this, HomeActivity::class.java).apply {
            putExtra("id", id)
            putExtra("password", password)
        }
        startActivity(intent)
    }

    private fun startSignUpActivity(id: String, password: String) {
        val intent = Intent(this, SignUpActivity::class.java).apply {
            putExtra("id", id)
            putExtra("password", password)
        }
        startActivity(intent)
    }
}