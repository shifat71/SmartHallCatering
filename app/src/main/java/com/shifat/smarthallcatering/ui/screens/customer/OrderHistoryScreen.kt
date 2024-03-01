package com.shifat.smarthallcatering.ui.screens.customer

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shifat.smarthallcatering.data.DataSource
import com.shifat.smarthallcatering.model.Order

@Composable
fun OrderHistoryScreen( orders: List<Order> ){

    LazyColumn(
        modifier = Modifier.padding(10.dp)
    ) {
       item{
           Text(
            text = "Order History",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
            )
        Spacer(modifier = Modifier.height(10.dp))
        for(order in orders){
            Row(
                Modifier
                    .padding(5.dp)
                    .background(
                        color = Color.LightGray,
                        shape = RoundedCornerShape(5.dp)
                    )
                    .padding(5.dp)
            ){
                OrderCard(order)
            }
            Spacer(modifier = Modifier.height(5.dp))
        }
       }
    }
}

@Composable
fun OrderCard(order: Order){

    val imageModifier = Modifier
        .size(
            80.dp,
            75.dp
        )
        .clip(
            RoundedCornerShape(10.dp)
        )

    Row(
        Modifier.padding(10.dp)
    ){
        Image(
            painter = painterResource(id = order.item.image),
            contentDescription = order.item.desc,
            modifier = imageModifier,
            contentScale = ContentScale.Crop
            )
        Spacer(modifier = Modifier.width(15.dp))

        Column{
            Row(){
                Text(
                    text = order.providerName,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .weight(.85F)
                )

                Text(
                    text = "Tk. ${order.cost}",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Magenta
                )
            }
            Spacer(modifier = Modifier.height(5.dp))
                if(order.isDelivered){
                    Text(
                        text ="Delivered on ${order.deliveredOn}",
                        fontSize = 15.sp
                    )
                }else{
                    Text(
                        text ="Collect on ${order.deliveryDate}",
                        fontSize = 15.sp
                    )
                }
            Spacer(modifier = Modifier.height(5.dp))
            Text(text = order.item.title)
        }
    }
}
fun provideColor(isDelivered: Boolean) : Color {
    if(isDelivered) return Color.Gray
    return Color.LightGray
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CustomerOderListScreenPreview(){
    OrderHistoryScreen(orders = DataSource.orderList)
}