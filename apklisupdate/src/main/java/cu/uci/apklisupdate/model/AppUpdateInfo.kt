package cu.uci.apklisupdate.model

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class AppUpdateInfo(
    @SerializedName("categories") var categories: List<Category>,
    @SerializedName("deleted") var deleted: Boolean,
    @SerializedName("description") var description: String,
    @SerializedName("developer") var developer: Developer,
    @SerializedName("download_count") var download_count: Int,
    @SerializedName("id") var id: Int,
    @SerializedName("last_release") var last_release: LastRelease,
    @SerializedName("last_updated") var last_updated: String,
    @SerializedName("name") var name: String,
    @SerializedName("owner") var owner: Int,
    @SerializedName("package_name") var package_name: String,
    @SerializedName("price") var price: Int,
    @SerializedName("public") var `public`: Boolean,
    @SerializedName("rating") var rating: Double,
    @SerializedName("releases_count") var releases_count: Int,
    @SerializedName("reviews_count") var reviews_count: Int,
    @SerializedName("reviews_star_1") var reviews_star_1: Int,
    @SerializedName("reviews_star_2") var reviews_star_2: Int,
    @SerializedName("reviews_star_3") var reviews_star_3: Int,
    @SerializedName("reviews_star_4") var reviews_star_4: Int,
    @SerializedName("reviews_star_5") var reviews_star_5: Int,
    @SerializedName("sponsored") var sponsored: Int,
    @SerializedName("update_from") var update_from: String,
    @SerializedName("updated") var updated: String
)