/**
 * Created by Oswaldo GH on 15/03/21.
 */

package com.app.oswaldokavak.domain

import com.app.oswaldokavak.data.api.response.BrastiewarkResponse
import com.app.oswaldokavak.data.model.Brastlewark
import com.app.oswaldokavak.utils.Resource

interface DataSource {
    suspend fun getList() : Resource<BrastiewarkResponse>
}