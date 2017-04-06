package com.sukitsuki.tgbot.module

/**Created by Alicex on 4/6/17.**/

import com.google.inject.AbstractModule
import com.google.inject.Singleton
import com.sukitsuki.tgbot.provider.DataSourceProvider
import com.sukitsuki.tgbot.provider.JooqProvider
import org.jooq.DSLContext
import javax.sql.DataSource

class DbModule : AbstractModule() {

    override fun configure() {
        bind(DataSource::class.java).toProvider(DataSourceProvider::class.java).`in`(Singleton::class.java)

        bind(DSLContext::class.java).toProvider(JooqProvider::class.java).`in`(Singleton::class.java)

    }
}