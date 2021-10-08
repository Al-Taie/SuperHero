package com.watermelon.superhero.model.repository

import com.watermelon.superhero.model.data.Status
import com.watermelon.superhero.model.data.response.Parent
import com.watermelon.superhero.model.network.Client
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

object MainRepository {
    var superHeroName = "a"
    private val dispatcher = Dispatchers.IO

    fun getSuperHero(): Flow<Status<Parent>>{
        return flow {
            emit(Status.Loading)
            emit(Client.makeSuperHeroRequest())
        }.flowOn(dispatcher)
    }
    fun getSuperHeroSearch(): Flow<Status<Parent>>{
        return flow {
            emit(Status.Loading)
            emit(Client. makeSearchRequest())
        }.flowOn(dispatcher)
    }

}