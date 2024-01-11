package com.shifat.smarthallcatering.components
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
import com.shifat.smarthallcatering.FoodItem
import com.shifat.smarthallcatering.components.ItemCard
import com.shifat.smarthallcatering.R

@Composable
fun Category(name: String, foodItems: List<FoodItem> )
{

        Column(){

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
                ItemCard(
                    modifier= Modifier.padding(start = 5.dp),
                    title = item.title,
                    desc= item.desc,
                    price = item.price,
                    image =item.image
                )
                   Divider()
            }
        }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Prev(){
    val desc = "This is a description of the Food, This is a description of the Food, Sdhas KJSd as sdj jsdj sjkdjk sk dsdkj khskjdhs kjhdsjkdh"
    val title = "Food Item Name"
    val price = 30;
    val image = painterResource(R.drawable.foodpic)

    val items = listOf(
        FoodItem(title,desc,price,image),
        FoodItem(title,desc,price,image),
        FoodItem(title,desc,price,image),
        FoodItem(title,desc,price,image),
        FoodItem(title,desc,price,image),
        FoodItem(title,desc,price,image),
        FoodItem(title,desc,price,image),
        FoodItem(title,desc,price,image),
        FoodItem(title,desc,price,image),
        FoodItem(title,desc,price,image),
        FoodItem(title,desc,price,image),
        FoodItem(title,desc,price,image),
    )

    Column {

        Category("Category 2" , items )
        Category("Category 1" , items )
    }

}