package com.agvber.my_info

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val nameEditText = findViewById<EditText>(R.id.name_edit_text)
        val idEditText = findViewById<EditText>(R.id.id_edit_text)
        val passwordEditText = findViewById<EditText>(R.id.password_edit_text)

        val registerButton = findViewById<Button>(R.id.register_button)

        registerButton.setOnClickListener {
            val isTextBlank = nameEditText.text.isBlank() || idEditText.text.isBlank() || passwordEditText.text.isBlank()
            if (isTextBlank) {
                showErrorMessage()
                return@setOnClickListener
            }

            finish()
        }
    }
    
    private fun showErrorMessage() {
        Toast.makeText(this, "입력되지 않은 정보가 있습니다", Toast.LENGTH_SHORT).show()
    }
}