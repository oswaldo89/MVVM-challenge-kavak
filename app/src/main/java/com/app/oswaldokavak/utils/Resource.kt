/**
 * Created by Oswaldo GH on 15/03/21.
 */

package com.app.oswaldokavak.utils

sealed class Resource<out T> {
    class Loading<out T>: Resource<T>()
    data class Success<out T>(val data: T): Resource<T>()
    data class Failure(val errorMessage: String?, val error: Throwable): Resource<Nothing>()
}