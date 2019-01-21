package cu.uci.apklisupdate.model

data class AppUpdateInfo(
    var categories: List<Category>,
    var deleted: Boolean,
    var description: String,
    var developer: Developer,
    var download_count: Int,
    var id: Int,
    var last_release: LastRelease,
    var last_updated: String,
    var name: String,
    var owner: Int,
    var package_name: String,
    var price: Int,
    var `public`: Boolean,
    var rating: Double,
    var releases_count: Int,
    var reviews_count: Int,
    var reviews_star_1: Int,
    var reviews_star_2: Int,
    var reviews_star_3: Int,
    var reviews_star_4: Int,
    var reviews_star_5: Int,
    var sponsored: Int,
    var update_from: String,
    var updated: String
)