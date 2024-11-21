package com.maestro.moviesapp.data.remote

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response

class RequestInterceptor (

):Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {

        //safely store the token
        val token = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJjMmQ0NTc0YzQwNWZjNTQ2OGZlMWFlYTI3ODJlYWQ3NyIsIm5iZiI6MTcyOTA1OTQ1Ny4yNzUyNywic3ViIjoiNjBjMWMyYjlmOWEzZmIwMDJjZDRjMmQ4Iiwic2NvcGVzIjpbImFwaV9yZWFkIl0sInZlcnNpb24iOjF9.YZF4get0JabNvjUIUocx1S5rqx5LgPVI5rbRUUctYhg"

        val newRequest = chain
            .request()
            .newBuilder()
            .addHeader("Authorization", "Bearer $token")
            .build()
        return chain.proceed(newRequest)
    }
}