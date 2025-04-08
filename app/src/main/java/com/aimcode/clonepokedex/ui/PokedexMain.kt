package com.aimcode.clonepokedex.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.aimcode.navigation.AppComposeNavigator

@Composable
fun PokedexMain(composeNavigator: AppComposeNavigator<PokedexScreen>) {
    PokedexTheme {
        val navHostController = rememberNavController()

        LaunchedEffect(Unit) {
            composeNavigator.handleNavigationCommands(navHostController)
        }

        PokedexNavHost(navHostController = navHostController)
    }
}