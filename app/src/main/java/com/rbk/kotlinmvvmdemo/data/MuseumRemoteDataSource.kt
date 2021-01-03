package com.rbk.kotlinmvvmdemo.data

import com.rbk.kotlinmvvmdemo.model.Museum
import com.rbk.kotlinmvvmdemo.model.MuseumDataSource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MuseumRemoteDataSource(apiClient: ApiClient) : MuseumDataSource {

    private var call: Call<List<Museum>>? = null
    private val service = apiClient.build()

    override fun retrieveMuseums(callback: OperationCallback<Museum>) {

        call = service?.museums()
        call?.enqueue(object : Callback<List<Museum>> {
            override fun onFailure(call: Call<List<Museum>>, t: Throwable) {
                callback.onError(t.message)
            }

            override fun onResponse(
                call: Call<List<Museum>>,
                response: Response<List<Museum>>
            ) {
                response.body()?.let {
//                    if (response.isSuccessful && (it.isSuccess())) {
                    if (response.isSuccessful ) {
                        callback.onSuccess(it)
                    } else {
                        callback.onError("Error")
                    }
                }
            }
        })
    }

    override fun cancel() {
        call?.let {
            it.cancel()
        }
    }
}