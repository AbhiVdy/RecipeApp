package com.example.composeex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.animation.expandHorizontally
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val flowers = listOf<Flowers>(
            Flowers("Lily", "200"),
            Flowers("Jasmine", "300"),
            Flowers("Roses", "100")
        )
        setContent {
            PopularFlowerList(flowers)
        }
    }

    @Composable
    private fun PopularFlowerList(flowers: List<Flowers>) {
        LazyRow(modifier = Modifier.fillMaxWidth()) {
            itemsIndexed(flowers) { _, item ->
                FlowerCard(flower = item)
            }
        }
    }

    @Composable
    fun FlowerCard(flower: Flowers) {
        Card(
            shape = RoundedCornerShape(14.dp),
            backgroundColor = Color.LightGray,
            modifier = Modifier
                .padding(10.dp)
                .width(180.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    "Some String",
                    modifier = Modifier.size(140.dp),
                    alignment = Alignment.Center,
                )
                Row(modifier = Modifier.padding(20.dp)) {
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = flower.name,
                            style = TextStyle(
                                color = Color.DarkGray,
                                fontSize = 16.sp
                            )
                        )
                        Text(
                            text = "₹" + flower.price,
                            style = TextStyle(
                                color = Color(R.color.purple_700),
                                fontSize = 16.sp
                            )
                        )
                    }
                    IconButton(
                        onClick = { },
                        modifier = Modifier.background(
                            color = Color(R.color.purple_700),
                            shape = RoundedCornerShape(10.dp)
                        )
                    ) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = null,
                            tint = Color.White
                        )
                    }
                }
            }
        }
    }
}