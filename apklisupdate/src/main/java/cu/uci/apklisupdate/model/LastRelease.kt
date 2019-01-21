package cu.uci.apklisupdate.model

data class LastRelease(
    var apk_file: String,
    var changelog: String,
    var human_readable_size: String,
    var icon: String,
    var id: Int,
    var permissions: List<Permission>,
    var `public`: Boolean,
    var published: String,
    var screenshots: List<Any>,
    var sha256: String,
    var size: Int,
    var version_code: Int,
    var version_name: String,
    var version_sdk: Int,
    var version_sdk_name: String,
    var version_target_sdk: Int,
    var version_target_sdk_name: Int
)