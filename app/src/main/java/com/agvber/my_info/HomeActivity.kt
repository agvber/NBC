package com.agvber.my_info

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class HomeActivity : AppCompatActivity() {

    companion object {
        const val ID = "id"
        const val PASSWORD = "password"
        const val NAME = "name"
        const val AGE = "age"
        const val MBTI = "mbti"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val intent = intent
        val id = intent.getStringExtra(ID)
        val name = intent.getStringExtra(NAME)
        val age = intent.getIntExtra(AGE, 0)
        val mbti = intent.getStringExtra(MBTI)

        val idTextView = findViewById<TextView>(R.id.id_text_view)
        val nameTextView = findViewById<TextView>(R.id.name_text_view)
        val ageTextView = findViewById<TextView>(R.id.age_text_view)
        val mbtiTextView = findViewById<TextView>(R.id.mbti_text_view)
        val closeButton = findViewById<Button>(R.id.close_button)


        idTextView.text = "아이디 : $id"
        nameTextView.text = "이름 : $name"
        ageTextView.text = "나이 : $age"
        mbtiTextView.text = "MBTI : $mbti"


        closeButton.setOnClickListener {
            finish()
        }
    }
}