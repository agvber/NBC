package com.agvber.my_info

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.agvber.my_info.model.User

class SignInActivity : AppCompatActivity() {

    private var user: User? = null

    private val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        val id = it.data?.extras?.getString(HomeActivity.ID)
        val password = it.data?.extras?.getString(HomeActivity.PASSWORD)
        val name = it.data?.extras?.getString(HomeActivity.NAME)
        val age = it.data?.extras?.getInt(HomeActivity.AGE)
        val mbti = it.data?.extras?.getString(HomeActivity.MBTI)

        user = User(
            id = id ?: "",
            password = password ?: "",
            name = name ?: "",
            age = age ?: 0,
            mbti = mbti ?: ""
        )
        Log.d("user", "$user")
    }

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
            startHomeActivity()
            showLoginSuccessToast()
        }

        registerButton.setOnClickListener {
            startSignUpActivity()
        }
    }

    private fun showLoginFailedToast() {
        Toast.makeText(this, "아이디/비밀번호를 확인해주세요", Toast.LENGTH_SHORT).show()
    }

    private fun showLoginSuccessToast() {
        Toast.makeText(this, "로그인 성공", Toast.LENGTH_SHORT).show()
    }

    private fun startHomeActivity() {
        val intent = Intent(this, HomeActivity::class.java).apply {
            putExtra(HomeActivity.ID, user?.id)
            putExtra(HomeActivity.PASSWORD, user?.password)
            putExtra(HomeActivity.NAME, user?.name)
            putExtra(HomeActivity.AGE, user?.age)
            putExtra(HomeActivity.MBTI, user?.mbti)
        }
        startActivity(intent)
    }

    private fun startSignUpActivity() {
        val intent = Intent(this, SignUpActivity::class.java)
        launcher.launch(intent)
    }
}