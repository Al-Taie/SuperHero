package com.watermelon.superhero.model.network

import com.google.gson.Gson
import com.watermelon.superhero.model.data.Status
import com.watermelon.superhero.model.repository.MainRepository
import com.watermelon.superhero.model.data.response.Parent
import com.watermelon.superhero.util.Constants
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.Request
import kotlin.coroutines.coroutineContext

object Client {

    private val client = OkHttpClient()

    fun makeSuperHeroRequest(): Status<Parent> {
        val url = initUrl()
        val request = Request.Builder().url(url).build()
        val response = client.newCall(request).execute()
        return if (response.isSuccessful) {
            val result =
                Gson().fromJson(response.body?.string(), Parent::class.java)
                Status.Success(result)
        } else {
            Status.Fail(response.message)
        }
    }

    private fun initUrl(): HttpUrl{
        return HttpUrl.Builder()
            .scheme(Constants.Url.SCHEMA)
            .host(Constants.Url.HOST)
            .addPathSegment(Constants.Url.MAIN_PATH)
            .addPathSegment(Constants.Url.ACCESS_TOKEN)
            .addPathSegment(Constants.Url.SEARCH_PATH)
            .addPathSegment(MainRepository.superHeroName)
            .build()
    }

}