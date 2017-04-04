package com.sukitsuki.tgbot.entities

import com.google.gson.annotations.SerializedName as Name

class Locale {

    @Name("zh_cn")
    var zhCn: String = ""
    @Name("zh_tw")
    var zhTw: String = ""
    @Name("ja")
    var ja: String = ""
    @Name("en")
    var en: String = ""

}
