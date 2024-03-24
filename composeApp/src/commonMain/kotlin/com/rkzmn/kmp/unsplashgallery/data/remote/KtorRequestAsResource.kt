package com.rkzmn.kmp.unsplashgallery.data.remote

import com.rkzmn.kmp.unsplashgallery.data.resource.ErrorEntity
import com.rkzmn.kmp.unsplashgallery.data.resource.Resource
import com.rkzmn.kmp.unsplashgallery.data.resource.RestErrorEntity
import io.ktor.client.call.body
import io.ktor.client.network.sockets.ConnectTimeoutException
import io.ktor.client.network.sockets.SocketTimeoutException
import io.ktor.client.plugins.HttpRequestTimeoutException
import io.ktor.client.plugins.ResponseException
import io.ktor.client.statement.HttpResponse
import io.ktor.utils.io.errors.IOException

suspend inline fun <reified D : Any> ktorRequestAsResource(
    crossinline request: suspend () -> HttpResponse,
): Resource<D> {
    return try {
        val httpResponse = request()
        val response = httpResponse.body<D>()
        Resource.Success(response)
    } catch (e: Exception) {
        Resource.Failure(e.asRestErrorEntity())
    }
}

suspend inline fun <reified R : Any, reified D : Any> ktorRequestAsResource(
    crossinline request: suspend () -> HttpResponse,
    crossinline mapper: suspend (R) -> D,
): Resource<D> {
    return try {
        val httpResponse = request()
        val response = httpResponse.body<R>()
        Resource.Success(mapper(response))
    } catch (e: Exception) {
        Resource.Failure(e.asRestErrorEntity())
    }
}

/**
 * Maps [Throwable] and its children to [ErrorEntity.Rest]
 */
fun Throwable.asRestErrorEntity() = when (this) {
    is HttpRequestTimeoutException, is ConnectTimeoutException, is SocketTimeoutException -> {
        RestErrorEntity.Network(isTimeout = true, cause = this)
    }

    is IOException -> {
        RestErrorEntity.Network(isTimeout = false, cause = this)
    }

    // Covers RedirectResponseException, ClientRequestException, ServerResponseException
    is ResponseException -> {
        RestErrorEntity.Http(code = response.status.value, cause = this)
    }

    else -> {
        RestErrorEntity.Unknown(cause = this)
    }
}