package com.watermelon.superhero.model.network

import com.google.gson.Gson
import com.watermelon.superhero.model.repository.MainRepository
import com.watermelon.superhero.model.data.response.Parent
import okhttp3.OkHttpClient
import okhttp3.Request

object Client {

    private val client = OkHttpClient()

    fun getSuperHero() {
        val url = "https://superheroapi.com/api/3025766657670104/search/${MainRepository.superHeroName}"
        val request = Request.Builder().url(url).build()
        val response = client.newCall(request).execute()
        if (response.isSuccessful) {
            val result =
                Gson().fromJson(response.body?.string(), Parent::class.java)

        } else {

        }
    }

}