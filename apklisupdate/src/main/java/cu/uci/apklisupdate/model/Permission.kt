package cu.uci.apklisupdate.model
import com.google.gson.annotations.SerializedName

data class Permission(
    @SerializedName("description") var description: String,
    @SerializedName("human_readable_name") var human_readable_name: String,
    @SerializedName("icon") var icon: String,
    @SerializedName("id") var id: Int,
    @SerializedName("name") var name: String
)