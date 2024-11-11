package com.sample.jetpack.msatestapplication.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.sample.jetpack.msatestapplication.domain.model.Business

@Composable
fun CharacterItem(modifier: Modifier, business: Business) {

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(20.dp)
    ) {

        Card(
            elevation = CardDefaults.elevatedCardElevation(8.dp),
            shape = RoundedCornerShape(8.dp)
        ) {
            Column(
                modifier = modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                business.apply {
                    AsyncImage(
                        modifier = modifier
                            .padding(16.dp)
                            .clip(RectangleShape)
                            .fillMaxWidth(),
                        model = image,
                        contentDescription = "",
                        contentScale = ContentScale.Crop
                    )
                    Text(text = id.toString(), fontWeight = FontWeight.Bold)
                    Spacer(modifier = modifier.padding(8.dp))
                    Text(text = name.toString())
                    Spacer(modifier = modifier.padding(8.dp))
                }
            }
        }

    }

}