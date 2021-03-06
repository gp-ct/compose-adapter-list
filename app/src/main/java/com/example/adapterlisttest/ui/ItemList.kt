package com.example.adapterlisttest.ui

import androidx.compose.Composable
import androidx.ui.foundation.AdapterList
import androidx.ui.foundation.Image
import androidx.ui.foundation.Text
import androidx.ui.graphics.ColorFilter
import androidx.ui.material.ListItem
import androidx.ui.material.MaterialTheme
import androidx.ui.res.vectorResource
import androidx.ui.tooling.preview.Preview
import com.example.adapterlisttest.R
import com.example.adapterlisttest.data.Contact
import com.example.adapterlisttest.model.ListModel

@Preview
@Composable
fun DefaultPreview() {
    MaterialTheme {
        ItemList()
    }
}

@Composable
fun ItemList() {
    AdapterList(
        data = ListModel.contactList
    ) { item ->

        //Always show the LoadMoreContactsItem at the end of the list
        if (item is Contact) {
            ContactItem(item.contactType, item.phoneNumber)
        } else {
            LoadMoreContactsItem(item as String)
        }

    }
}

@Composable
fun ContactItem(contactType: String, phoneNumber: String) {
    ListItem(
        icon = {
            Image(
                asset = vectorResource(id = R.drawable.ic_contact),
                colorFilter = ColorFilter.tint(mainThemeColor)
            )
        },
        text = {
            Text("Contact")
        },
        overlineText = {
            Text(contactType)
        },
        secondaryText = {
            Text(phoneNumber)
        }
    )
}

@Composable
fun LoadMoreContactsItem(itemText: String) {
    ListItem(
        icon = {
            Image(
                asset = vectorResource(id = R.drawable.ic_add),
                colorFilter = ColorFilter.tint(mainThemeColor)
            )
        },
        text = {
            Text(itemText)
        },
        onClick = {
            ListModel.loadMoreContacts()
        }
    )
}