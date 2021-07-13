package cu.uci.apklisupdate.model

import com.google.gson.annotations.SerializedName

data class LastRelease(
    @SerializedName("apk_file") var apk_file: String?,
    @SerializedName("changelog") var changelog: String,
    @SerializedName("human_readable_size") var human_readable_size: String,
    @SerializedName("icon") var icon: String,
    @SerializedName("id") var id: Int,
    @SerializedName("permissions") var permissions: List<Permission>,
    @SerializedName("public") var `public`: Boolean,
    @SerializedName("published") var published: String,
    @SerializedName("screenshots") var screenshots: List<Any>,
    @SerializedName("sha256") var sha256: String,
    @SerializedName("size") var size: Int,
    @SerializedName("version_code") var version_code: Int,
    @SerializedName("version_name") var version_name: String,
    @SerializedName("version_sdk") var version_sdk: Int,
    @SerializedName("version_sdk_name") var version_sdk_name: String,
    @SerializedName("version_target_sdk") var version_target_sdk: Int,
    @SerializedName("version_target_sdk_name") var version_target_sdk_name: String
)