/**
 * Created by Oswaldo GH on 15/03/21.
 */

package com.app.oswaldokavak.data.api.services

import com.app.oswaldokavak.data.api.response.BrastiewarkResponse
import com.app.oswaldokavak.data.model.Brastlewark
import retrofit2.http.GET
interface ApiService {
    @GET("data.json")
    suspend fun getList(): BrastiewarkResponse
}