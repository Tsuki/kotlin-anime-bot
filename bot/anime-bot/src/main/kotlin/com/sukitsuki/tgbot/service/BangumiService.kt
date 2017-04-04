package com.sukitsuki.tgbot.service

/**Created by Alicex on 4/3/17.**/
import com.sukitsuki.tgbot.entities.Recent
import com.sukitsuki.tgbot.entities.Tag
import okhttp3.MediaType
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import java.nio.file.Files
import com.google.gson.annotations.SerializedName as Name
import java.io.File as IoFile

private val PLAIN_TEXT_MIME = MediaType.parse("text/plain")
private val APPLICATION_JSON_MIME = MediaType.parse("application/json")

data class Response<out T>(val result: T?)

fun inputFile(file: java.io.File, mimeType: String? = null): RequestBody {
    return RequestBody.create(MediaType.parse(mimeType ?: Files.probeContentType(file.toPath())), file)
}

fun requestString(text: String) = RequestBody.create(PLAIN_TEXT_MIME, text)

fun requestJson(text: String) = RequestBody.create(APPLICATION_JSON_MIME, text)

interface BangumiService {
    @GET("bangumi/recent")
    fun recent(): Call<List<Recent>>


    @POST("tag/fetch")
    fun tag(@Body json: RequestBody): Call<List<Tag>>

}