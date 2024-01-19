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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shifat.smarthallcatering.data.DataSource
import com.shifat.smarthallcatering.model.FoodItem

@Composable
fun ItemCard(item:FoodItem, modifier: Modifier=Modifier) {

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
                    text= item.title,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(
                        bottom = 5.dp
                    )
                )

                Text(
                    text=item.desc,
                    color = Color.Gray,
                    fontSize = 12.sp,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )

                Text(
                    modifier = Modifier.padding(
                        top = 10.dp
                    ),
                    text= "Tk. ${item.price}"
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
                painter = painterResource(item.image),
                contentDescription = item.desc,
            )

        }
    }

@Preview(showBackground = true)
@Composable
fun ItemCardPreview(){
    ItemCard(DataSource.foodItem)
}