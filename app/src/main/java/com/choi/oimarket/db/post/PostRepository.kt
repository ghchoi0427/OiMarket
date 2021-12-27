package com.choi.oimarket.db.post

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

class PostRepository(private val postDao: PostDao) {

    val allPosts: Flow<List<Post>> = postDao.loadAllPosts()

    @WorkerThread
    suspend fun insert(post: Post) {
        postDao.insertPosts(post)
    }

    @WorkerThread
    fun selectWithId(rowId: Int): Post {
        return postDao.findPostWithId(rowId)
    }

    @WorkerThread
    fun selectWithTitle(search: String?): List<Post> {
        return postDao.findPostWithTitle(search)
    }

    @WorkerThread
    fun deleteWithId(rowId: Int) {
        postDao.deletePostWithId(rowId)
    }

}