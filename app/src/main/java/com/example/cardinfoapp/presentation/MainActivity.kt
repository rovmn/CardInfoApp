package com.example.cardinfoapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.cardinfoapp.presentation.screens.ApplicationScreen
import com.example.cardinfoapp.presentation.theme.CardInfoAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CardInfoAppTheme {
                ApplicationScreen()
            }
        }
    }
}