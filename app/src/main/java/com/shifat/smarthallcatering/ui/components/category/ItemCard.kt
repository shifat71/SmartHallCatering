package com.shifat.smarthallcatering.ui.components.category
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ItemCard(title: String, desc: String, price: Int, image: Painter, modifier: Modifier=Modifier) {

        Row(
            modifier = modifier.padding(
                bottom =  10.dp,
                start = 5.dp,
                top = 5.dp
            )
        ){
            Column(
                modifier = Modifier
                    .padding(10.dp)
                    .weight(.75F)
            ) {
                Text(
                    text= title,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(
                        bottom = 5.dp
                    )
                )

                Text(
                    text=desc,
                    color = Color.Gray,
                    fontSize = 12.sp,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )

                Text(
                    modifier = Modifier.padding(
                        top = 10.dp
                    ),
                    text= "Tk. $price"
                )
            }

            Image(
                modifier = Modifier
                    .padding(
                        top = 20.dp,
                        end = 20.dp,
                        start = 13.dp
                    )
                    .clip(RoundedCornerShape(10.dp)),
                painter = image,
                contentDescription = desc,
            )

        }
    }
