@file:Suppress("SqlSourceToSinkFlow")

package me.snipz.database.impl

import me.snipz.database.GeneralDatabase
import java.sql.Connection
import java.sql.DriverManager

class SQLiteDatabase(private val path: String): GeneralDatabase() {

    override fun getConnection(): Connection {
        val connection = DriverManager.getConnection("jdbc:sqlite:$path")
        return connection
    }
}