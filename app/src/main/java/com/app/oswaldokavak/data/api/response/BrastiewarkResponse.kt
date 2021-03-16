package com.app.oswaldokavak.data.api.response


import com.app.oswaldokavak.data.model.Brastlewark
import com.google.gson.annotations.SerializedName

data class BrastiewarkResponse(
    @SerializedName("Brastlewark") val brastlewark: List<Brastlewark>
)