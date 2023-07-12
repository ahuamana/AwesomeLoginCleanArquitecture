package com.ahuaman.domain

class InvalidExceptionGeneral(message: String): Exception(message)

class NoConnectivityException(message: String): Exception(message)

data class GeneralErrorResponse(
    val code: Int,
    val message: String,
    val error: String
)