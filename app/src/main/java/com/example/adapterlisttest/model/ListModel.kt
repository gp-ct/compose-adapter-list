package com.example.adapterlisttest.model

import androidx.compose.Model
import androidx.compose.frames.ModelList
import androidx.compose.frames.modelListOf
import com.example.adapterlisttest.data.contactTypes
import java.lang.StringBuilder

@Model
object ListModel {

    //Model object to track the state of the list of contacts
    val contactList: ModelList<Pair<String, String>> = modelListOf(Pair("Load More Contacts", ""))

    init {
        //Load initial contacts
        loadMoreContacts()
    }

    //Loads 4 more contacts (creates 4 sample contacts and adds them to the list)
    fun loadMoreContacts() {
        for (i in 0..3) {
            //Create phone number
            val phoneBuilder = StringBuilder((7000000000..8000000000).random().toString())
            phoneBuilder.insert(3, "-")
            phoneBuilder.insert(7, "-")

            val phoneNumber = phoneBuilder.toString()

            contactList.add(0, Pair(contactTypes.random().toString(), phoneNumber))
        }
    }
}