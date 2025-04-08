package com.aimcode.clonepokedex.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.compose.rememberNavController
import com.aimcode.designsystem.theme.PokedexTheme
import com.aimcode.navigation.AppComposeNavigator
import com.aimcode.navigation.PokedexScreen

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