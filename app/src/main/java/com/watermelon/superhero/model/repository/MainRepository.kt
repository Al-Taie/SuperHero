package com.watermelon.superhero.model.repository

import com.watermelon.superhero.model.data.Status
import com.watermelon.superhero.model.data.response.Parent
import com.watermelon.superhero.model.network.Client
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

object MainRepository {
    private val dispatcher = Dispatchers.IO

    fun getSuperHero(text: String = "a"): Flow<Status<Parent>>{
        return flow {
            emit(Status.Loading)
            emit(Client.makeSuperHeroRequest(text))
        }.flowOn(dispatcher)
    }
}