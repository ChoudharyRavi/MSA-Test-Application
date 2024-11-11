package com.sample.jetpack.msatestapplication.presentation.navigation

import android.location.Location
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import com.google.android.gms.location.LocationServices
import kotlinx.coroutines.launch

@Composable
fun GetCurrentLocation(onLocationAvailable: (Double, Double) -> Unit) {
    val context = LocalContext.current
    val fusedLocationClient = remember { LocationServices.getFusedLocationProviderClient(context) }
    val scope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        try {
            scope.launch {
                fusedLocationClient.lastLocation.addOnSuccessListener { location: Location? ->
                    if (location != null) {
                        onLocationAvailable(location.latitude, location.longitude)
                    }
                }
            }
        } catch (e: SecurityException) {
            // Handle exception, location permission denied
        }
    }
}