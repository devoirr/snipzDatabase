package me.snipz.database.impl

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import me.snipz.database.GeneralDatabase
import java.sql.Connection
import java.util.Properties
import javax.sql.DataSource

class MySQLDatabase(
    host: String,
    port: Int,
    database: String,
    username: String,
    password: String,
    maximumPoolSize: Int
): GeneralDatabase() {

    private val dataSource: DataSource

    init {
        val props = Properties()

        props.setProperty("dataSourceClassName", "org.mariadb.jdbc.MariaDbDataSource")
        props.setProperty("dataSource.serverName", host)
        props.setProperty("dataSource.portNumber", port.toString())
        props.setProperty("dataSource.user", username)
        props.setProperty("dataSource.password", password)
        props.setProperty("dataSource.databaseName", database)

        val config = HikariConfig(props)
        config.maximumPoolSize = maximumPoolSize

        this.dataSource = HikariDataSource(config)
    }

    override fun getConnection(): Connection = dataSource.connection
}