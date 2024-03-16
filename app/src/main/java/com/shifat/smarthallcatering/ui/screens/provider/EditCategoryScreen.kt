
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shifat.smarthallcatering.data.DataSource
import com.shifat.smarthallcatering.model.Category
import com.shifat.smarthallcatering.ui.components.category.ItemsCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditCategoryScreen(category: Category, onAddProduct: () -> Unit) {

    // edit category name text-field
    val categoryName = remember { mutableStateOf(category.name) }

    Column(modifier = Modifier.padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {

        OutlinedTextField(
            value = categoryName.value,
            onValueChange = { categoryName.value = it },
            label = { Text("Category Name") },
            textStyle = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Blue,
                unfocusedBorderColor = Color.Gray
            )
        )

        Spacer(modifier = Modifier.height(8.dp))

        IconButton(onClick = onAddProduct) {
            Icon(Icons.Rounded.Add, contentDescription = "Add Product")
        }

        Spacer(modifier = Modifier.height(8.dp))

        LazyColumn {
            item {
                ItemsCard(
                    foodItems = category.items
                )
            }
        }

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun EditCategoryScreenPreview() {
    EditCategoryScreen(category = DataSource.category, onAddProduct = { /*TODO: Handle add product*/ })
}