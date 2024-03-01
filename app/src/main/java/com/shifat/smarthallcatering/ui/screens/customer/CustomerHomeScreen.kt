package com.shifat.smarthallcatering.ui.screens.customer

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.shifat.smarthallcatering.data.DataSource
import com.shifat.smarthallcatering.model.user.Customer
import com.shifat.smarthallcatering.model.user.Provider

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomerHomeScreen(
    customer: Customer,
    onHallSelectButton: (Int) -> Unit
    ) {

    Scaffold(
        contentColor = Color.White,
        topBar = {
            TopAppBar(
                colors = topAppBarColors(
                    containerColor = Color(0xFFFF407D),
                    titleContentColor = Color.LightGray,
                ),
               title = {
                   Row(
                       horizontalArrangement = Arrangement.SpaceBetween,
                       verticalAlignment = Alignment.CenterVertically,
                       modifier = Modifier.fillMaxWidth()
                   ) {
                       ThreeLineButton()
                       Text(
                           text = "Hi ${customer.firstName}",
                           fontWeight = FontWeight.ExtraBold,
                           letterSpacing = 0.1.em,
                           modifier = Modifier
                               .weight(.7F)
                               .padding(start = 15.dp)
                       )
                   }
                }
            )
        }
    ) { innerPadding ->
        Card(
            modifier = Modifier
                .padding(innerPadding)
                .padding(top = 10.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {

            Column(

            ) {

                Text(
                    text = "Subscribed Providers",
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.DarkGray,
                    modifier = Modifier.padding(
                        bottom = 5.dp,
                        start = 5.dp
                    )
                )

                HallListCard(
                    subscribedProviders = customer.subscribedProviders,
                    onHallSelectButton
                )
            }

        }
    }

}

@Composable
fun ThreeLineButton() {
    IconButton(
        onClick = {
            // Handle button click
        },
        modifier = Modifier.size(48.dp)
    ) {
        Column {
            Spacer(modifier = Modifier.height(4.dp))
            Icon(
                imageVector = Icons.Default.Menu,
                contentDescription = null
            )
        }
    }
}


@Composable
fun HallListCard(
    subscribedProviders: List<Provider>,
    onClick: (Int) -> Unit
) {
    LazyColumn {

        items(subscribedProviders) { provider ->
            Surface(
                modifier = Modifier
                    .padding(
                        start = 5.dp,
                        end = 5.dp,
                        bottom = 15.dp
                    )
                    .clickable {
                        // To know, which hall to navigate
                        onClick(provider.id)
                    },
                shadowElevation = 10.dp,
                tonalElevation = 5.dp,
                shape = RoundedCornerShape(5.dp)
            ) {
                Box {
                    Image(
                        painter = painterResource(id = provider.image),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(395.dp, 150.dp)

                    )

                    Box(
                        modifier = Modifier
                            .padding(top = 2.dp)
                            .background(
                                color = Color(0xFFFF407D),
                                shape = RoundedCornerShape(3.dp)
                            )
                    ) {
                        Text(
                            text = provider.name,
                            fontSize = 20.sp,
                            color = Color.White,
                            fontFamily = FontFamily.Serif,
                            letterSpacing = 0.02.em,
                            modifier = Modifier.padding(7.dp)
                        )
                    }

                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CustomerHomeScreenPreview(){
    CustomerHomeScreen(DataSource.customer, onHallSelectButton = {})
}