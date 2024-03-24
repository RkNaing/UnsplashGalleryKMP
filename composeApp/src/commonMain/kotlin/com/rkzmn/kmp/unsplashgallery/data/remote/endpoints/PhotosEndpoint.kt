package com.rkzmn.kmp.unsplashgallery.data.remote.endpoints

import com.rkzmn.kmp.unsplashgallery.data.remote.dtos.UnsplashImageDto
import com.rkzmn.kmp.unsplashgallery.data.resource.Resource

typealias UnsplashImageListResource = Resource<List<UnsplashImageDto>>

interface PhotosEndpoint {
    suspend fun getAllImages(
        page: Int,
        pageSize: Int
    ): UnsplashImageListResource

    suspend fun searchImages(
        query: String,
        page: Int,
        pageSize: Int
    ): UnsplashImageListResource
}