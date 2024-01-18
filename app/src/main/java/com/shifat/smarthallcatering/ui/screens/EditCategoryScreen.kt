package com.shifat.smarthallcatering.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import com.shifat.smarthallcatering.data.DataSource
import com.shifat.smarthallcatering.model.Category

@Composable
fun EditCategoryScreen(category: Category){
    var isEditing by remember { mutableStateOf(false) }
    var text by remember { mutableStateOf(category.name) }


  }

@Preview(showBackground = true)
@Composable
fun EditCategoryScreenPreview(){
    EditCategoryScreen(category = DataSource.category)
}