package com.github.nabin0.kmmvideoplayersampleandroid.utils

sealed class Resource<out T>{
    data class Success<out T>(val result: T): Resource<T>()
    data class Failure<out T>(val exception: Exception): Resource<T>()
    data object Loading: Resource<Nothing>()
}