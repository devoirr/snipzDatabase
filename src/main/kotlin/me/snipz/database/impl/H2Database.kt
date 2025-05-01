package me.snipz.database.impl

import me.snipz.database.GeneralDatabase
import java.sql.Connection
import java.sql.DriverManager

class H2Database(private val path: String): GeneralDatabase() {

    init {
        Class.forName("org.h2.Driver")
    }

    override fun getConnection(): Connection {
        val connection = DriverManager.getConnection("jdbc:h2:file:$path;MODE=MySQL", "sa", "")
        return connection
    }

}