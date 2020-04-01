package com.example.adapterlisttest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.compose.Model
import androidx.compose.frames.ModelList
import androidx.ui.core.setContent
import androidx.ui.foundation.AdapterList
import androidx.ui.foundation.Box
import androidx.ui.foundation.ContentGravity
import androidx.ui.foundation.Text
import androidx.ui.material.Button
import androidx.ui.material.MaterialTheme
import androidx.ui.tooling.preview.Preview
import com.example.adapterlisttest.ListModel.addItemToList
import com.example.adapterlisttest.ListModel.dataList

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

@Composable
fun ItemList() {
    AdapterList(
            data = dataList
    ) {
        Text(it)
    }
    Box(gravity = ContentGravity.Center) {
        Button(onClick = { addItemToList() }) {
            Text("Add Item")
        }
    }
}

@Model
object ListModel {
    val dataList: ModelList<String> = ModelList()

    fun addItemToList() {
        val nextItemCount = dataList.size + 1
        dataList.add("Item " + (nextItemCount).toString())
    }
}

@Preview
@Composable
fun DefaultPreview() {
    MaterialTheme {
        ItemList()
    }
}