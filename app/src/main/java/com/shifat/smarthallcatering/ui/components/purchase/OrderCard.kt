package com.shifat.smarthallcatering.ui.components.purchase

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shifat.smarthallcatering.R


@Composable
fun OrderCard(
    modifier: Modifier = Modifier,
    price: Int,
    onOrderButtonClicked: (quantity: Int) -> Unit = { }
) {

    var quanitity by remember { mutableIntStateOf(1) }
    
    Divider()
    Column(
        modifier = modifier.padding(
            top = 5.dp,
            start = 10.dp,
            bottom = 10.dp
        )
    ) {



           Row(Modifier.padding(15.dp)) {
               Text(
                   text ="Total:     ${quanitity*price} Tk.",
                   fontSize = 20.sp,
                   fontWeight = FontWeight.Bold
               )
               Row(
                   Modifier
                       .padding(
                           start = 55.dp
                       )){


                   Image(
                       painter = painterResource(id = R.drawable.add),
                       contentDescription = null,
                       Modifier.clickable { quanitity++ }.size(30.dp)
                   )

                   Text(
                       text = quanitity.toString(),
                       Modifier.padding(start = 20.dp, end = 20.dp),
                       fontSize = 20.sp
                   )

                   Image(
                       painter = painterResource(id = R.drawable.minus),
                       contentDescription = null,
                       Modifier.clickable {
                           if(quanitity>1) quanitity-- }.size(30.dp)
                   )

               }

           }
        Button(
            modifier = Modifier.padding(start = 120.dp),
            onClick = { onOrderButtonClicked(quanitity) }
        ) {
            Text(text = "Order")
        }


    }

}

@Preview(showBackground = true)
@Composable
fun OrderCardPreview(){
    OrderCard( Modifier,10)
}