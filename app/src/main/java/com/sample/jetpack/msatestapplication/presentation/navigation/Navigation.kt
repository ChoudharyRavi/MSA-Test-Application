package com.sample.jetpack.msatestapplication.presentation.navigation

import android.Manifest
import android.content.pm.PackageManager
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sample.jetpack.msatestapplication.core.utils.Constants
import com.sample.jetpack.msatestapplication.presentation.components.HomeScreen
import com.sample.jetpack.msatestapplication.presentation.state.BusinessState
import com.sample.jetpack.msatestapplication.presentation.viewmodel.BusinessViewModel

@Composable
fun Navigation() {
    val navController = rememberNavController()

    val context = LocalContext.current
    val permissionGranted = remember { mutableStateOf(false) }

    val locationPermissionLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        permissionGranted.value = isGranted
    }

    NavHost(navController = navController, startDestination = Screen.CharacterScreen.route) {
        composable(Screen.CharacterScreen.route) {
            val businessViewModel = hiltViewModel<BusinessViewModel>()

            LaunchedEffect(Unit) {
                permissionGranted.value = ContextCompat.checkSelfPermission(
                    context, Manifest.permission.ACCESS_FINE_LOCATION
                ) == PackageManager.PERMISSION_GRANTED

                if (!permissionGranted.value) {
                    locationPermissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
                }
            }

            if (permissionGranted.value) {
                GetCurrentLocation { lat, long ->
                    businessViewModel.apply {
                        //here are two possibilities for retrieving data.
                        // If lat long does not have any data then try using location. Please uncomment lat and long in the api interface while calling using lat long and just empty the location string
                        getAllCharacters(Constants.PIZZA, Constants.JUICE, "New York City", lat, long)
                    }
                }
            } else {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text("Location permission is required to continue.")
                    Spacer(modifier = Modifier.height(8.dp))
                    Button(onClick = { locationPermissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION) }) {
                        Text("Grant Location Permission")
                    }
                }
            }

            val businessState: BusinessState =
                businessViewModel.businessState.collectAsStateWithLifecycle().value

            Log.i("TAG", "Navigation: here...")
            HomeScreen(modifier = Modifier, businessState = businessState)


        }
    }
}

@Preview
@Composable
fun NavigationPreview() {
    Navigation()
}