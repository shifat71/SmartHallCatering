package com.shifat.smarthallcatering.ui.screens.customer

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shifat.smarthallcatering.data.DataSource
import com.shifat.smarthallcatering.model.Order

@Composable
fun OrderDetailsScreen(order: Order) {


    Column (
        modifier = Modifier.padding(10.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        val imageModifier = Modifier
            .padding(5.dp)
            .size(395.dp, 230.dp)
            .clip(RoundedCornerShape(10.dp))
        Spacer(Modifier.height(50.dp))
        Text(
            text = order.item.title,
            fontSize = 30.sp,
        )
        Spacer(Modifier.height(15.dp))
        Image(
            painter = painterResource(order.item.image),
            contentDescription = order.item.desc,
            contentScale = ContentScale.Crop,
            modifier = imageModifier
        )
        Spacer(Modifier.height(15.dp))
        Text(
            text = "Quantity: ${order.quantity}",
            fontSize = 30.sp
        )
        Spacer(Modifier.height(15.dp))
        Text(
            text = "Total: ${order.cost} Tk.",
            fontSize = 25.sp
        )
        Spacer(Modifier.height(15.dp))
        Text(
            text = "Ordered On: ${order.orderedOn} Tk.",
            fontSize = 25.sp
        )
        Spacer(Modifier.height(15.dp))
        Text(
            text = "Collect by: ${order.deliveryDate}",
            fontSize = 25.sp
        )
        Spacer(Modifier.height(5.dp))
        Text(
            text = "OTP: ${order.otp}",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(5.dp)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun OrderDetailsScreenPreview(){
    OrderDetailsScreen(order = DataSource.order)
}