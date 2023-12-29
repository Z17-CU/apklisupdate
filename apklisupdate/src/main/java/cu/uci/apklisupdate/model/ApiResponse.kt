package cu.uci.apklisupdate.model

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class ApiResponse(
    @SerializedName("count") val count: Int = 0,
    @SerializedName("results") val results: List<AppUpdateInfo> = listOf()
)