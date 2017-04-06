package com.sukitsuki.tgbot.provider

import com.google.inject.Inject
import com.google.inject.Provider
import org.jooq.DSLContext
import org.jooq.SQLDialect
import org.jooq.impl.DSL
import org.jooq.impl.DefaultConfiguration
import javax.sql.DataSource


/**Created by Alicex on 4/6/17.**/
class JooqProvider @Inject
constructor(private val dataSource: DataSource) : Provider<DSLContext> {

    override fun get(): DSLContext {

        val configuration = DefaultConfiguration()
                .set(dataSource)
                .set(SQLDialect.POSTGRES)
        return DSL.using(configuration)
    }
}