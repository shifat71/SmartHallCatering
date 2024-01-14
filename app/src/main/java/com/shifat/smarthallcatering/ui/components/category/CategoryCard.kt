package com.shifat.smarthallcatering.ui.components.category
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shifat.smarthallcatering.data.DataSource
import com.shifat.smarthallcatering.model.FoodItem


@Composable
fun CategoryCards(modifier: Modifier= Modifier, name: String, foodItems: List<FoodItem> )
{
        Column{

            Text(
                    text = name,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(
                        top = 15.dp,
                        start = 10.dp
                    )
                )

            for(item in foodItems){
                ItemCards(
                    title = item.title,
                    desc= item.desc,
                    price = item.price,
                    image = painterResource(id = item.image),
                    modifier.clickable {
                        /* To Do
                        Navigate to:
                         PurchaseCard(item)
                         */
                    }
                )
                   Divider()
            }
        }
}



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Prev(){
    CategoryCards(name = "Category Name", foodItems = DataSource.foodItems)
}