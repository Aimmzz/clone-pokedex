package com.aimcode.clonepokedex.navigation

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.aimcode.navigation.PokedexScreen

context(SharedTransitionScope)
@OptIn(ExperimentalSharedTransitionApi::class)
fun NavGraphBuilder.pokedexNavigation() {
    composable<PokedexScreen.Home> {
        PokedexHome(this)
    }

    composable<PokedexScreen.Details>(
        typeMap = PokedexScreen.Details.typeMap,
    ) {
        PokedexDetails(this)
    }
}