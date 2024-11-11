package com.sample.jetpack.msatestapplication.presentation.navigation

sealed class Screen(val route: String) {
    data object CharacterScreen : Screen("home_screen")

}