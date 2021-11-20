package com.example.layoutscodelab

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.layoutscodelab.ui.theme.LayoutsCodelabTheme

@Composable
fun LayoutsCodelab() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("LayoutsCodelab")
                },
                actions = {
                    IconButton(onClick = { /* doSomething() */ }) {
                        Icon(Icons.Filled.Favorite, contentDescription = null)
                    }
                }
            )
        }
    ){ innerPadding ->
        BodyContent(Modifier.padding(innerPadding).padding(8.dp))
    }
}

val topics = listOf(
    "Arts & Crafts", "Beauty", "Books", "Business", "Comics", "Culinary",
    "Design", "Fashion", "Film", "History", "Maths", "Music", "People", "Philosophy",
    "Religion", "Social sciences", "Technology", "TV", "Writing"
)

@Composable
fun BodyContent(modifier: Modifier = Modifier) {
    Row(modifier = modifier
        .background(color = Color.LightGray)
        .padding(16.dp)
        .size(200.dp)
        .horizontalScroll(rememberScrollState()),
        content = {
            StaggeredGrid {
                for (topic in topics) {
                    Chip(modifier = Modifier.padding(8.dp), text = topic)
                }
            }
        })
}

@Preview
@Composable
fun LayoutsCodelabPreview() {
    LayoutsCodelabTheme {
        LayoutsCodelab()
    }
}