package me.snipz.database

enum class DatabaseType(val local: Boolean) {

    SQLITE(true),
    MYSQL(false);

}