package com.watermelon.superhero.model.repository

import com.watermelon.superhero.model.data.Status
import com.watermelon.superhero.model.data.response.Parent
import com.watermelon.superhero.model.network.Client
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

object MainRepository {

    var superHeroName = "a"

    fun getSuperHero(): Flow<Status<Parent>>{
        return flow {
            emit(Status.Loading)
            emit(Client.makeSuperHeroRequest())
        }
    }

}