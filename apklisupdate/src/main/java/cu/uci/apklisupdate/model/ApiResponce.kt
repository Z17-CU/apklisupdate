package cu.uci.apklisupdate.model

import com.google.gson.annotations.SerializedName

data class ApiResponce(
    @SerializedName("count") val count: Int = 0,
    @SerializedName("results") val results: List<AppUpdateInfo> = listOf()
)