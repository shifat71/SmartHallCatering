package com.shifat.smarthallcatering.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun OrderCompleteScreen(
    onMoreItems : () -> Unit = {}
){
  Column(
      horizontalAlignment = Alignment.CenterHorizontally,
      verticalArrangement = Arrangement.Center
  ) {
      Text(
          text="Your Order Has Been Completed.",
          fontSize =  20.sp,
          modifier = Modifier.padding(10.dp)
          )
      Text(text ="Please Collect Your Item from Store")
      Row(
          Modifier
              .padding(10.dp)
              .clickable(onClick = onMoreItems)
              .background(
                  color = Color.Gray,
                  shape = RoundedCornerShape(10.dp),
              )
      ){
          Text(
              text = "See More Items",
              Modifier.padding(10.dp))
      }
  }
}

@Preview(showBackground = true)
@Composable
fun OrderCompleteScreenPreview(){
   OrderCompleteScreen()
}