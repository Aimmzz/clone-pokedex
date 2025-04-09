package com.aimcode.data.repository.home

import androidx.annotation.WorkerThread
import com.aimcode.model.Pokemon
import kotlinx.coroutines.flow.Flow

interface HomeRepository {

    @WorkerThread
    fun fetchPokemonList(
        page: Int,
        onStart: () -> Unit,
        onComplete: () -> Unit,
        onError: (String?) -> Unit,
    ): Flow<List<Pokemon>>
}