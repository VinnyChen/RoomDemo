package com.vinny.roomdemo.db.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

/**
 * Description : UserEntity 用户表
 * Created : CGG
 * Time : 2020/4/29
 * Version : 0.0.1
 */
@Entity
data class UserEntity(

  @PrimaryKey //主键
  @ColumnInfo(name = "user_id") //注定表的列名
  var userId: String,

  @ColumnInfo(name = "user_name")
  var userName: String = "",

  @NonNull //变量不能为null
  var userAge: Int,

  @Ignore //忽略该变量，在Room数据库中，即创建表时，不在作为表的一项列名
  var userSex: Int
) {
  constructor() : this("", "", 20, 2)

  /**
   * 获取性别，为2表示表中没有该字段(为了验证@Ignore注解的作用)
   */
  fun getSex(): String {
    return when (userAge) {
      0 -> "女"
      1 -> "男"
      else -> "/"
    }
  }
}

