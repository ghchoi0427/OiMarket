package com.choi.oimarket.db.user

import androidx.annotation.WorkerThread

class UserRepository(private val userDao: UserDao) {

    @WorkerThread
    suspend fun insert(user: User) {
        userDao.insertUser(user)
    }

    @WorkerThread
    fun selectWithId(rowId: Int): User {
        return userDao.findUserWithId(rowId)
    }

    @WorkerThread
    fun deleteWithId(rowId: Int) {
        userDao.deleteUserWithId(rowId)
    }

}