package com.sukitsuki.tgbot.entities

import com.google.gson.annotations.SerializedName as Name

class Tag {
    @Name("_id")
    var id: String = ""
    @Name("activity")
    var activity: Long = 0
    @Name("locale")
    var locale: Locale = Locale()
    @Name("name")
    var name: String = ""
    @Name("syn_lowercase")
    var synLowercase: List<String> = emptyList()
    @Name("synonyms")
    var synonyms: List<String> = emptyList()
    @Name("type")
    var type: String = ""

    override fun toString(): String {
        return "${locale.zhTw}"
    }
}
