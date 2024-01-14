package com.shifat.smarthallcatering.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shifat.smarthallcatering.data.DataSource

@Composable
fun ShopSummaryCard(
    shopName: String,
    shopPicture: Int
) {
    Column {

        Text(
            text=shopName,
            fontSize = 30.sp,
            modifier = Modifier.padding(5.dp).align(Alignment.CenterHorizontally)
        )

        Image(
            painter = painterResource(id = shopPicture),
            contentScale = ContentScale.Crop,
            contentDescription =null,
            modifier = Modifier.clip(RoundedCornerShape(20.dp)).
            size(
                395.dp,
                150.dp
            ).
            padding(5.dp),
            )
    }

}

@Preview(showBackground = true)
@Composable
fun ShopSummaryCardPreview(){
    ShopSummaryCard("Shahporan Hall",DataSource.hallImage)
}
