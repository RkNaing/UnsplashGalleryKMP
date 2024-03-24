package com.rkzmn.kmp.unsplashgallery.data.resource

sealed class ErrorEntity(
    override val message: String? = null,
    override val cause: Throwable? = null
) : Exception() {

    /**
     * An [ErrorEntity] for representing unhandled errors.
     */
    data object UnknownErrorEntity : ErrorEntity()
}