package com.example.adapterlisttest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.compose.Model
import androidx.compose.frames.ModelList
import androidx.compose.frames.modelListOf
import androidx.ui.core.*
import androidx.ui.foundation.*
import androidx.ui.graphics.Color
import androidx.ui.graphics.ColorFilter
import androidx.ui.material.ListItem
import androidx.ui.material.MaterialTheme
import androidx.ui.res.vectorResource
import androidx.ui.tooling.preview.Preview
import com.example.adapterlisttest.ListModel.addItemToList
import com.example.adapterlisttest.ListModel.contactList
import java.lang.StringBuilder

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
        data = contactList
    ) { item ->
        val isLastItem = (item == contactList[contactList.lastIndex])
        if (!isLastItem) {
            ListItem(
                icon = {
                    Image(
                        asset = vectorResource(id = R.drawable.ic_contact),
                        colorFilter = ColorFilter.tint(Color.Black)
                    )
                },
                text = {
                    Text("Contact")
                },
                overlineText = {
                    Text(item.first)
                },
                secondaryText = {
                    Text(item.second)
                }
            )
        } else {
            ListItem(
                icon = {
                    Image(
                        asset = vectorResource(id = R.drawable.ic_add),
                        colorFilter = ColorFilter.tint(Color.Black)
                    )
                },
                text = {
                    Text(item.first)
                },
                onClick = {
                    addItemToList()
                }
            )
        }
    }
}

val contactTypes = listOf("Work", "Home", "Cell")

@Model
object ListModel {
    val contactList: ModelList<Pair<String, String>> = modelListOf(Pair("Load More Contacts", ""))

    fun addItemToList() {
        for (i in 0..3) {
            val phoneBuilder = StringBuilder((7000000000..8000000000).random().toString())
            phoneBuilder.insert(3, "-")
            phoneBuilder.insert(7, "-")

            val phoneNumber = phoneBuilder.toString()

            contactList.add(0, Pair(contactTypes.random().toString(), phoneNumber))
        }
    }
}

@Preview
@Composable
fun DefaultPreview() {
    MaterialTheme {
        ItemList()
    }
}