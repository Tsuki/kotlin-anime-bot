package com.sukitsuki.tgbot.entities

import com.google.gson.annotations.SerializedName as Name


/**Created by Alicex on 4/3/17.**/
data class Recent(
        @Name("_id")
        val id: String = "",
        @Name("name")
        val name: String = "",
        @Name("credit")
        val credit: String = "",
        @Name("startDate")
        val startDate: Long = 0,
        @Name("endDate")
        val endDate: Long = 0,
        @Name("showOn")
        val showOn: Int = 0,
        @Name("tag_id")
        val tagId: String = "",
        @Name("icon")
        val icon: String = "",
        @Name("cover")
        val cover: String = "",
        @Name("acgdb_id")
        val acgdbId: String = ""
) {
    override fun toString(): String = name
}