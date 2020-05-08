package com.vinny.roomdemo.db.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.vinny.roomdemo.db.dao.UserDao
import com.vinny.roomdemo.db.entity.UserEntity

/**
 * Description : AppDatabase 数据库
 * Created : CGG
 * Time : 2020/4/29
 * Version : 0.0.1
 */
@Database(entities = [UserEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    companion object {
        // 数据库名称
        private const val DB_NAME = "AppDatabase.db"
        @Volatile
        private var instance: AppDatabase? = null

        @Synchronized
        fun getInstance(context: Context): AppDatabase? {
            if (instance == null) {
                instance = create(context.applicationContext)
            }
            return instance
        }

        private fun create(context: Context): AppDatabase {
            return Room
                .databaseBuilder(context, AppDatabase::class.java, DB_NAME)
                .allowMainThreadQueries()//允许主线程执行
                .build()
        }
    }

    /**
     * 获取用户Dao
     */
    abstract fun getUserDao(): UserDao

}