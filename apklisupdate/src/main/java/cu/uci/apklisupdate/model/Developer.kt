package cu.uci.apklisupdate.model

import com.google.gson.annotations.SerializedName

data class Developer(
    @SerializedName("avatar") var avatar: Any,
    @SerializedName("description") var description: String,
    @SerializedName("first_name") var first_name: String,
    @SerializedName("fullname") var fullname: String,
    @SerializedName("id") var id: Int,
    @SerializedName("is_active") var is_active: Boolean,
    @SerializedName("last_name") var last_name: String,
    @SerializedName("user") var user: Int,
    @SerializedName("username") var username: String
)