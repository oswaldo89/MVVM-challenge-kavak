/**
 * Created by Oswaldo GH on 15/03/21.
 */

package com.app.oswaldokavak.data.remote

import com.app.oswaldokavak.data.api.RetrofitClient
import com.app.oswaldokavak.data.api.response.BrastiewarkResponse
import com.app.oswaldokavak.data.model.Brastlewark
import com.app.oswaldokavak.domain.DataSource
import com.app.oswaldokavak.utils.Resource

class RemoteDataSourceImpl : DataSource {
    override suspend fun getList(): Resource<BrastiewarkResponse> {
        return Resource.Success(RetrofitClient.webservice.getList())
    }
}