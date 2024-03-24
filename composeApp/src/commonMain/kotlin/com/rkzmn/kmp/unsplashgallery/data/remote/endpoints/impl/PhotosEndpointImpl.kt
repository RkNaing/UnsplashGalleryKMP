package com.rkzmn.kmp.unsplashgallery.data.remote.endpoints.impl

import com.rkzmn.kmp.unsplashgallery.data.remote.HttpRoutes
import com.rkzmn.kmp.unsplashgallery.data.remote.endpoints.PhotosEndpoint
import com.rkzmn.kmp.unsplashgallery.data.remote.endpoints.UnsplashImageListResource
import com.rkzmn.kmp.unsplashgallery.data.remote.ktorRequestAsResource
import io.github.aakira.napier.Napier
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class PhotosEndpointImpl(
    private val client: HttpClient
) : PhotosEndpoint {
    override suspend fun getAllImages(page: Int, pageSize: Int): UnsplashImageListResource {
        Napier.d(
            message = "Called with: page = [$page], pageSize = [$pageSize]",
            tag = TAG
        )
        return ktorRequestAsResource {
            client.get(HttpRoutes.PHOTOS) {
                parameter(HttpRoutes.PARAM_PAGE, page)
                parameter(HttpRoutes.PARAM_PAGE_SIZE, pageSize)
            }
        }
    }

    override suspend fun searchImages(
        query: String,
        page: Int,
        pageSize: Int
    ): UnsplashImageListResource {
        Napier.d(
            message = "Called with: query = [$query], page = [$page], pageSize = [$pageSize]",
            tag = TAG
        )
        return ktorRequestAsResource {
            client.get(HttpRoutes.PHOTOS_SEARCH) {
                parameter(HttpRoutes.PARAM_PAGE, page)
                parameter(HttpRoutes.PARAM_PAGE_SIZE, pageSize)
                parameter(HttpRoutes.PARAM_QUERY, query)
            }
        }
    }

    companion object {
        private const val TAG = "PhotosEndpoint"
    }
}