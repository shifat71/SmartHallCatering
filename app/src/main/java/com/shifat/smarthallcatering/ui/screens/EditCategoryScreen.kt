package com.shifat.smarthallcatering.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.shifat.smarthallcatering.data.DataSource
import com.shifat.smarthallcatering.model.Category
import com.shifat.smarthallcatering.ui.components.category.CategoryCards

@Composable
fun EditCategoryScreen(category: Category){

    CategoryCards(name = category.name, foodItems = category.items)
}

@Preview(showBackground = true)
@Composable
fun EditCategoryScreenPreview(){
    EditCategoryScreen(category = DataSource.category)
}