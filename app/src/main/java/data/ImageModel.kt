package data

import com.google.gson.annotations.SerializedName
import java.util.Date

    data class ImageModel (
        @SerializedName("document")
        val documents: ArrayList<Documents>,
        @SerializedName("meta")
        val meta: Meta
    )

    data class Documents (
        @SerializedName("collection")
        val collection: String,
        @SerializedName("datetime")
        val dateTime: Date,
        @SerializedName("display_sitename")
        val displaySiteName: String,
        @SerializedName("doc_url")
        val docUrl: String,
        @SerializedName("height")
        val height: Int,
        @SerializedName("width")
        val width: Int,
        @SerializedName("image_url")
        val image_url: String,
        @SerializedName("thumbnail_url")
        val thumbnailUrl: String,
    )

    data class Meta (
        @SerializedName("pageable_count")
        val pagebleCount: Int,
        @SerializedName("total_count")
        val totalCount: Int?,
        @SerializedName("is_end")
        val isEnd: Boolean?
    )
