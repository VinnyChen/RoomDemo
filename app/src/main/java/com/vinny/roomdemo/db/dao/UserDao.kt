package com.vinny.roomdemo.db.dao

import androidx.room.*
import com.vinny.roomdemo.db.entity.UserEntity

/**
 * Description : UserDao 用户数据表访问对象
 * Created : CGG
 * Time : 2020/4/29
 * Version : 0.0.1
 */
@Dao
interface UserDao {

  /************************************增加****************************************/
  /**
   * 增加
   */
  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun insert(element: UserEntity)

  /**
   * 插入一个列表
   */
  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun insertList(list: List<UserEntity>)


  /************************************删除****************************************/
  /**
   * 删除一个元素
   */
  @Delete
  fun delete(element: UserEntity)

  /**
   * 删除多个元素（逗号隔开）
   */
  @Delete
  fun delete(vararg elements: UserEntity)

  /**
   * 根据userId删除某一行
   */
  @Query("delete from UserEntity where user_id = :userId")
  fun deleteById(userId: String)

  /**
   * 删除表中所有元素(此时使用@Query注解执行sql语句)
   */
  @Query("delete from UserEntity")
  fun deleteAll()


  /************************************修改****************************************/
  /**
   * 修改
   */
  @Update
  fun update(element: UserEntity)

  /**
   * 根据id查找某一行，再修改这一行的用户名
   */
  @Query("update UserEntity set user_name = :name where user_id = :userId")
  fun update(userId: String, name: String)


  /************************************查询****************************************/
  /**
   * 查询整个列表
   */
  @Query("select * from UserEntity")
  fun query(): List<UserEntity>

  /**
   * 根据id查询对应的行
   */
  @Query("select * from UserEntity where user_id = :userId")
  fun query(userId: String): List<UserEntity>

}