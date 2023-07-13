package com.ahuaman.network

import android.util.Log
import com.ahuaman.domain.GeneralErrorResponse
import com.ahuaman.domain.InvalidExceptionGeneral
import com.google.gson.Gson
import retrofit2.Response
import timber.log.Timber

abstract class BaseDataSource {

    //for testing force error
    protected suspend fun <T> getResult(call: suspend () -> Response<T>, forceError: Boolean = false): T {
        if(forceError){
            throw Exception("force error for testing purpose only -- com.ahuaman.network.BaseDataSource.kt")
        }
        val response = call()
        if (response.isSuccessful) {
            val body = response.body()
            if (body != null) return body
        }

        if(response.code() in 400..499){
            val errorResponse = Gson().fromJson(response.errorBody()?.string()?:"", GeneralErrorResponse::class.java)
            Log.e("com.ahuaman.network.BaseDataSource","Error 400 -- ${errorResponse.error}")
            throw InvalidExceptionGeneral(errorResponse.error?:"Error 400")
        }
        throw Exception(" not e ${response.code()} ${response.body()}")
    }
}

