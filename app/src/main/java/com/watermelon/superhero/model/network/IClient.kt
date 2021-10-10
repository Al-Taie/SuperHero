package com.watermelon.superhero.model.network

import com.watermelon.superhero.model.data.Status
import com.watermelon.superhero.model.data.response.Parent
import okhttp3.HttpUrl

interface IClient {
    fun initUrl(path: String, query: String = "a"): HttpUrl
    fun makeSuperHeroRequest(query: String): Status<Parent>
}