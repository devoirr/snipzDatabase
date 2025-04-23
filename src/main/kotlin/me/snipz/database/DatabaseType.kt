package me.snipz.database

enum class DatabaseType(val local: Boolean) {

    SQLITE(true),
    H2(true),
    MYSQL(false);

}