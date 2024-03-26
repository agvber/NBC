package com.agvber.my_info

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener

class SignUpActivity : AppCompatActivity() {

    private val viewModel: SignUpViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val nameEditText = findViewById<EditText>(R.id.name_edit_text)
        val idEditText = findViewById<EditText>(R.id.id_edit_text)
        val passwordEditText = findViewById<EditText>(R.id.password_edit_text)
        val registerButton = findViewById<Button>(R.id.register_button)

        nameEditText.addTextChangedListener { viewModel.updateName(it.toString()) }
        idEditText.addTextChangedListener { viewModel.updateId(it.toString()) }
        passwordEditText.addTextChangedListener { viewModel.updatePassword(it.toString()) }


        registerButton.setOnClickListener {
            if (!viewModel.buttonEnable.value) {
                showErrorMessage()
                return@setOnClickListener
            }
            showSuccessMessage()
        }
    }

    private fun showErrorMessage() {
        Toast.makeText(this, "입력되지 않은 정보가 있습니다", Toast.LENGTH_SHORT).show()
    }

    private fun showSuccessMessage() {
        Toast.makeText(this, viewModel.toastMessage.value, Toast.LENGTH_SHORT).show()
    }
}