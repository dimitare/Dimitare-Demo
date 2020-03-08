package com.dimitare.angdim.services.remote

sealed class RemoteResource<DataType, ErrorType> {
    data class Success<DataType, ErrorType>(val data: DataType? = null) : RemoteResource<DataType, ErrorType>()
    data class Error<DataType, ErrorType>
    @JvmOverloads constructor(val data: DataType? = null,
                              val errorData: ErrorType? = null,
                              val errorMessage: String? = null) : RemoteResource<DataType, ErrorType>()
    class Loading<DataType, ErrorType> : RemoteResource<DataType, ErrorType>()
}