package com.agvber.mbti_test

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.agvber.mbti_test.ui.theme.MBTI_TEST_Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MBTI_TEST_Theme {
               val intent = Intent(this, BaseActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}