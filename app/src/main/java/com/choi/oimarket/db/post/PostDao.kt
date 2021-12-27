package com.choi.oimarket.db.post

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface PostDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPosts(vararg posts: Post?)

    @Update
    fun updatePost(vararg posts: Post)

    @Delete
    fun deletePost(vararg posts: Post)

    @Query("SELECT *,rowid FROM post")
    fun loadAllPosts(): Flow<List<Post>>

    @Query("SELECT *,rowid FROM post WHERE title LIKE :search")
    fun findPostWithTitle(search: String?): List<Post>

    @Query("SELECT *,rowid FROM post WHERE rowid LIKE :search")
    fun findPostWithId(search: Int): Post

    @Query("DELETE FROM post WHERE rowid LIKE :search")
    fun deletePostWithId(search: Int)


}