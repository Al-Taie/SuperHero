package com.watermelon.superhero.model.network

import com.watermelon.superhero.model.data.Status
import com.watermelon.superhero.model.data.response.Parent
import okhttp3.HttpUrl

interface IClient {
    fun initUrl(path: String): HttpUrl
    fun initUrl(path: String,text:CharSequence): HttpUrl
    fun makeSuperHeroRequest(): Status<Parent>
}