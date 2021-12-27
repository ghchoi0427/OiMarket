package com.choi.oimarket.db.user

import androidx.room.Entity
import androidx.room.Fts4
import androidx.room.PrimaryKey

@Fts4
@Entity(tableName = "user")
data class User(
    var name: String,
    var location: String,
    var posts: List<String>?
) {
    @PrimaryKey(autoGenerate = true)
    var rowid: Int = 0
}
