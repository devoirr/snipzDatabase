package me.snipz.database

import java.sql.Connection
import java.sql.ResultSet
import kotlin.use

abstract class GeneralDatabase {

    abstract fun getConnection(): Connection

    private fun <T> withConnection(action: (Connection) -> T): T {
        return getConnection().use { connection ->
            action(connection)
        }
    }

    fun query(sql: String, resultSetHandler: (ResultSet) -> Unit, vararg params: Any?) {
        withConnection { connection ->
            connection.prepareStatement(sql).use {
                params.forEachIndexed { index, param ->
                    it.setObject(index + 1, param)
                }

                it.executeQuery().use { resultSet ->
                    resultSetHandler.invoke(resultSet)
                }
            }
        }
    }
    fun update(sql: String, vararg params: Any?): Int {
        var updateRows = 0
        withConnection { connection ->
            connection.prepareStatement(sql).use {
                params.forEachIndexed { index, param ->
                    it.setObject(index + 1, param)
                }

                updateRows = it.executeUpdate()
            }
        }

        return updateRows
    }
}