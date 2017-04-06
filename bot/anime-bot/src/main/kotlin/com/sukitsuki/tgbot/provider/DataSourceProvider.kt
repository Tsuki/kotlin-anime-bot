package com.sukitsuki.tgbot.provider

import com.google.inject.Inject
import com.google.inject.Provider
import com.google.inject.name.Named
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import javax.sql.DataSource


/**Created by Alicex on 4/6/17.**/
class DataSourceProvider : Provider<DataSource> {

    @Inject
    @Named("db.class.name")
    private val dataSourceClassName: String? = null
    @Inject
    @Named("db.username")
    private val dbUser: String? = null
    @Inject
    @Named("db.password")
    private val dbPassword: String? = null
    @Inject
    @Named("db.name")
    private val dbName: String? = null

    override fun get(): DataSource {
        val config = HikariConfig()
        config.dataSourceClassName = dataSourceClassName
        config.addDataSourceProperty("databaseName", dbName)
        config.addDataSourceProperty("user", dbUser)
        config.addDataSourceProperty("password", dbPassword)
        return HikariDataSource(config)
    }
}