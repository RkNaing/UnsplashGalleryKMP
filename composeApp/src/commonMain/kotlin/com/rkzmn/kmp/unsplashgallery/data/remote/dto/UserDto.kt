package com.rkzmn.kmp.unsplashgallery.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
@Serializable
data class UserDto(
    @SerialName("id") val userId: String = "",
    @SerialName("first_name") val firstName: String = "",
    @SerialName("last_name") val lastName: String = "",
    @SerialName("name") val name: String = "",
    @SerialName("portfolio_url") val portfolioUrl: String = "",
    @SerialName("profile_image") val profileImage: ProfileImage = ProfileImage(),
    @SerialName("instagram_username") val instagramUsername: String? = "",
    @SerialName("twitter_username") val twitterUsername: String? = "",
    @SerialName("username") val username: String = ""
) {
    @Serializable
    data class ProfileImage(
        @SerialName("large") val large: String = "",
    )

}