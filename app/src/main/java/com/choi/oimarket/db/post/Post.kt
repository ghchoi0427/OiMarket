package com.choi.oimarket.db.post

import androidx.room.Entity
import androidx.room.Fts4
import androidx.room.PrimaryKey

@Fts4
@Entity(tableName = "post")
data class Post(
    var titlie: String?,
    var content: String?,
    var title: String?,
    var pictureUri: String?
) {
    @PrimaryKey(autoGenerate = true)
    var rowid: Int = 0
}
