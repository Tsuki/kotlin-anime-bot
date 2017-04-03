package com.sukitsuki.tgbot.entities

import com.google.gson.annotations.SerializedName


/**Created by Alicex on 4/3/17.**/
data class Recent(
        @SerializedName("_id")
        val id: String? = null,
        @SerializedName("name")
        val name: String? = null,
        @SerializedName("credit")
        val credit: String? = null,
        @SerializedName("startDate")
        val startDate: Long? = null,
        @SerializedName("endDate")
        val endDate: Long? = null,
        @SerializedName("showOn")
        val showOn: Int? = null,
        @SerializedName("tag_id")
        val tagId: String? = null,
        @SerializedName("icon")
        val icon: String? = null,
        @SerializedName("cover")
        val cover: String? = null,
        @SerializedName("acgdb_id")
        val acgdbId: String? = null
                 ) {
    override fun toString(): String {
        return "$name"
//        return "Recent(id=$id, name=$name, credit=$credit, startDate=$startDate, endDate=$endDate, showOn=$showOn, tagId=$tagId, icon=$icon, cover=$cover, acgdbId=$acgdbId)"
    }
}