package com.shifat.smarthallcatering.ui.screens.provider

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shifat.smarthallcatering.data.DataSource
import com.shifat.smarthallcatering.model.Order

@Composable
fun OrderListScreen(orderList: List<Order>){
    LazyColumn(
        modifier = Modifier.padding(
            start = 25.dp)
    ) {
        item{

            Row(
                modifier = Modifier.padding(top = 10.dp, bottom = 10.dp, start = 10.dp)
            ){
                Text(
                    text = "Item Name",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .weight(.55F)
                )
                Text(
                    text = "Quantity",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .weight(.45F)
                        .padding(start = 10.dp)

                )
            }

            for(order in orderList){
                Row(
                    modifier = Modifier
                        .padding(bottom = 10.dp, end = 25.dp)
                        .background(color = Color.Cyan, shape = RoundedCornerShape(10.dp))
                ){
                    SingleOrderCard(title = order.item.title, quantity = order.quantity )
                }
            }
        }
    }
}

@Composable
fun SingleOrderCard(title:String , quantity: Int){
    Row(
        modifier = Modifier.padding(
            start = 10.dp,
            end = 10.dp,
            top = 6.dp,
            bottom = 6.dp
        )
    ){
        Text(
            text = title,
            fontSize = 16.sp,
            modifier = Modifier
                .weight(.6F)
                .padding(start = 10.dp)
        )
        Text(
            text = "${quantity}",
            fontSize = 16.sp,
            modifier = Modifier
                .weight(.4F)
                .padding(start = 40.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun OrderListScreenPreview(){
    OrderListScreen(orderList = DataSource.orderList)
}