package com.example.adapterlisttest.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.ui.core.*
import androidx.ui.material.MaterialTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                ItemList()
            }
        }
    }
}


