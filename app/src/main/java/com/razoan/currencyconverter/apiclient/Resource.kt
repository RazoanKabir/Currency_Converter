package com.razoan.currencyconverter.apiclient

class Resource<T>(val status: Status, val data: T?, val message: String?) {
    // A good way to handle various api statuses. I have copied this class from online as a good reference.
    companion object {
        fun <T> success(data: T?): Resource<T> {
            return Resource(Status.SUCCESS, data, null)
        }

        fun <T> error(msg: String, data: T? = null): Resource<T> {
            return Resource(Status.ERROR, data, msg)
        }

        fun <T> loading(data: T? = null): Resource<T> {
            return Resource(Status.LOADING, data, null)
        }
    }

    enum class Status { SUCCESS, ERROR, LOADING }
}