package com.sample.jetpack.msatestapplication.presentation.components

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.sample.jetpack.msatestapplication.presentation.state.BusinessState

@Composable
fun HomeScreen(modifier: Modifier, businessState: BusinessState) {

    businessState.apply {
        if (isLoading) {
            Box(modifier = modifier.fillMaxSize()) {
                Text(
                    text = "Loading data...",
                    modifier = modifier.align(Alignment.Center)
                )
            }
        } else if (errorMsg?.isNotEmpty() == true) {
            Box(modifier = modifier.fillMaxSize()) {
                Text(
                    text = errorMsg.toString(),
                    modifier = modifier.align(Alignment.Center)
                )
            }
        } else if (business?.isNotEmpty() == true) {
            Log.i("TAG", "HomeScreen: business:${business.size}")
            business.distinct().apply {
                LazyColumn {
                    items(size) { index ->
                        CharacterItem(modifier = modifier, business = this@apply[index])
                    }
                }
            }
        }
    }
}