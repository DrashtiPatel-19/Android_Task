package com.crm.task1

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface
{
    @GET("photos")
    fun getallPhotos() : Call<List<PhotosDataItem>>
}