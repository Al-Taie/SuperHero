package com.watermelon.superhero.model.network

import com.google.gson.Gson
import com.watermelon.superhero.model.data.Status
import com.watermelon.superhero.model.data.response.Parent
import com.watermelon.superhero.util.Constant.Link
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.Request

object Client : IClient {
    private val client = OkHttpClient()

    override fun makeSuperHeroRequest(query: String): Status<Parent> {
        val url = initUrl(path = Link.Path.SEARCH, query = query)
        val request = Request.Builder().url(url).build()
        val response = client.newCall(request).execute()
        return if (response.isSuccessful) {
            val result = Gson().fromJson(response.body?.string(), Parent::class.java)
            Status.Success(result)
        } else {
            Status.Fail(response.message)
        }
    }

    override fun initUrl(path: String, query: String): HttpUrl {
        return HttpUrl.Builder()
            .scheme(Link.SCHEMA)
            .host(Link.HOST)
            .addPathSegment(Link.Path.API)
            .addPathSegment(Link.ACCESS_TOKEN)
            .addPathSegment(path)
            .addPathSegment(query)
            .build()
    }
}