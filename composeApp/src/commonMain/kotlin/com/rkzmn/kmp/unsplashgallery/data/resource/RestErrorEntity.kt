package com.rkzmn.kmp.unsplashgallery.data.resource

/**
 * An [ErrorEntity] for representing error related to REST API calls.
 */
sealed class RestErrorEntity(
    override val message: String? = null,
    override val cause: Throwable? = null
) : ErrorEntity(message, cause) {

    /**
     * Represents that **NULL** is received as server's response body.
     */
    class NullResponse(
        override val message: String? = "HTTP Response body is null.",
        override val cause: Throwable? = null
    ) : RestErrorEntity(message, cause)

    /**
     * Represents failure of establish connection to server due to
     *
     * - No internet access (device is offline)
     * - Poor internet connection
     * - Laggy sever
     *
     * @property isTimeout  - **true** if took too long to get server response due to
     * poor internet connection or laggy server
     * - **false** if no internet access.
     */
    class Network(
        val isTimeout: Boolean,
        override val message: String? = null,
        override val cause: Throwable? = null
    ) : RestErrorEntity(message, cause) {

        override fun toString(): String {
            return "Network Error Entity [isTimeout : $isTimeout]"
        }
    }

    /**
     * Represents an unsuccessful HTTP status code is received
     * in response i.e, not within 200..299.
     *
     * @property [HTTP Status Code](https://tinyurl.com/ybsa8qmz)
     */
    class Http(
        val code: Int,
        override val message: String? = null,
        override val cause: Throwable? = null
    ) : RestErrorEntity(message, cause) {

        /**
         * **true** if [code] is between 500 and 599
         */
        val isServerError: Boolean
            get() = code >= INTERNAL_SERVER_ERROR

    }

    /**
     * Represents other unhandled errors.
     */
    class Unknown(
        override val message: String? = null,
        override val cause: Throwable? = null
    ) : RestErrorEntity(message, cause)

    companion object{
        private const val INTERNAL_SERVER_ERROR = 500
    }
}