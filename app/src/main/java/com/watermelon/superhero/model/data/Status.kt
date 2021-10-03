package com.watermelon.superhero.model.data

/**
 * get status of requests.
 * @author     Ahmed Yusef
 * @return     Unit
 * */

sealed class Status<out T> {
    object Loading : Status<Nothing>()
    data class Fail(val message: String) : Status<Nothing>()
    data class Success<T>(val data: T) : Status<T>()
}

