package com.choi.oimarket.db.user

import androidx.room.*

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user: User)

    @Update
    fun updateUser(user: User)

    @Delete
    fun deleteUser(user: User)

    @Query("SELECT *,rowid FROM user")
    fun loadAllUsers(): List<User>?

    @Query("SELECT *,rowid FROM user WHERE rowid LIKE :search")
    fun findUserWithId(search: Int): User

    @Query("DELETE FROM user WHERE rowid LIKE :search")
    fun deleteUserWithId(search: Int)
}