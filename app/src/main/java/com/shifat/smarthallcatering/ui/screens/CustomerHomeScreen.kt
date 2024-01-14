package com.shifat.smarthallcatering.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
import com.shifat.smarthallcatering.model.user.Customer

@Composable
fun CustomerHomeScreen(customer: Customer) {

    Column {
        Text(
            text = "Hi, ${customer.firstName} !",
            fontSize = 30.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally).padding(5.dp),
            color = Color.Blue
        )

         LazyColumn{
             item{
                 Text(
                     text = "Subscribed Providers",
                     fontSize = 35.sp,
                     fontWeight = FontWeight.Bold,
                     color = Color.DarkGray,
                     modifier = Modifier.padding(5.dp)
                 )
             }

             items(customer.subscribedProviders){
                 provider ->
                 Column(
                     modifier = Modifier.padding(
                         10.dp
                     )
                 ) {
                     Text(
                         text = provider.name,
                         fontSize = 30.sp,
                         modifier = Modifier.padding(
                          bottom = 10.dp
                         )
                     )
                     Image(
                         painter = painterResource(id = provider.image),
                         contentDescription = null,
                         contentScale = ContentScale.Crop,
                         modifier = Modifier.size(
                             395.dp,
                             150.dp
                         ).clip(RoundedCornerShape(15.dp))
                     )
                 }
             }
         }

    }

}

@Preview(showBackground = true)
@Composable
fun CustomerHomeScreenPreview(){
    CustomerHomeScreen(DataSource.customer)
}