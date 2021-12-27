package com.choi.oimarket.db.post

import com.choi.oimarket.db.Converters

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@TypeConverters(Converters::class)
@Database(entities = [Post::class], version = 1, exportSchema = false)
abstract class PostDatabase : RoomDatabase() {
    abstract fun postDao(): PostDao

    private class PostDatabaseCallback(
        private val scope: CoroutineScope,
    ) : RoomDatabase.Callback() {
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let { database ->
                scope.launch {
                    //TODO: pre-fill database
                }
            }
        }
    }

    companion object {

        @Volatile
        private var INSTANCE: PostDatabase? = null

        fun getDatabase(
            context: Context, scope: CoroutineScope,
        ): PostDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PostDatabase::class.java,
                    "post_database"
                )
                    .addCallback(PostDatabaseCallback(scope))
                    .allowMainThreadQueries()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}