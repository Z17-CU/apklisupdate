package cu.uci.apklisupdate.model

import com.google.gson.annotations.SerializedName

data class Category(
    @SerializedName("group") var group: String,
    @SerializedName("icon") var icon: String,
    @SerializedName("id") var id: Int,
    @SerializedName("name") var name: String
)