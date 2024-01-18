package com.shifat.smarthallcatering.ui.components.category

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shifat.smarthallcatering.data.DataSource
import com.shifat.smarthallcatering.model.FoodItem


@Composable
fun ItemDetailsCard(modifier: Modifier = Modifier, foodItem: FoodItem) {

    LazyColumn(modifier) {
        item {
            Column {

                val imageModifier = Modifier
                    .padding(top = 30.dp)
                    .clip(RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp))
                    .size(395.dp, 230.dp)

                Image(
                    painter = painterResource(foodItem.image),
                    contentDescription = foodItem.desc,
                    contentScale = ContentScale.Crop,
                    modifier = imageModifier
                )

                Column(
                    Modifier.padding(
                        top = 15.dp,
                        start = 15.dp,
                        end = 15.dp
                    )
                ) {

                    Row(
                        Modifier.padding(
                            bottom = 10.dp
                        )
                    ) {
                        Text(
                            text = foodItem.title,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp,
                            modifier = Modifier.weight(.85F)
                        )

                        Text(
                            text = "Tk. ${foodItem.price}",
                            modifier = Modifier
                                .padding(
                                    top = 10.dp
                                ),
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Magenta
                        )
                    }

                    Text(
                        text = foodItem.desc,
                        color = Color.Gray,
                        textAlign = TextAlign.Justify,
                        fontSize = 12.sp
                    )

                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ItemD() {
    ItemDetailsCard(foodItem = DataSource.foodItem)
}