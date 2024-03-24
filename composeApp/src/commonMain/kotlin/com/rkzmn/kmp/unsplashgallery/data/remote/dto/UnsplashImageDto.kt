package com.rkzmn.kmp.unsplashgallery.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UnsplashImageDto(
    @SerialName("id") val id: String = "",
    @SerialName("description") val description: String = "",
    @SerialName("alt_description") val shortDescription: String = "",
    @SerialName("likes") val totalLikes: Int = 0,
    @SerialName("width") val width: Int = 0,
    @SerialName("height") val height: Int = 0,
    @SerialName("color") val color: String = "",
    @SerialName("created_at") val createdAt: String = "",
    @SerialName("updated_at") val updatedAt: String = "",
    @SerialName("urls") val urls: Urls = Urls(),
    @SerialName("links") val links: Links = Links(),
    @SerialName("user") val user: UserDto = UserDto()
) {
    @Serializable
    data class Urls(
        @SerialName("full") val full: String = "",
        @SerialName("raw") val raw: String = "",
        @SerialName("regular") val regular: String = "",
        @SerialName("small") val small: String = "",
        @SerialName("thumb") val thumbnail: String = ""
    )

    @Serializable
    data class Links(
        @SerialName("download") val download: String = "",
        @SerialName("html") val html: String = "",
        @SerialName("self") val self: String = ""
    )
}