package com.agvber.my_info

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.agvber.my_info.ui.theme.MY_INFO_Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MY_INFO_Theme {

            }
        }
    }
}