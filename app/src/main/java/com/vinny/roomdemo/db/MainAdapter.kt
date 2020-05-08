package com.vinny.roomdemo.db

import android.content.Context
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.vinny.roomdemo.R
import com.vinny.roomdemo.db.entity.UserEntity

/**
 * Description : MainAdapter
 * Created : CGG
 * Time : 2020/5/8
 * Version : 0.0.1
 */
class MainAdapter(private val context: Context) :
  BaseQuickAdapter<UserEntity, BaseViewHolder>(R.layout.item_main) {
  override fun convert(helper: BaseViewHolder, item: UserEntity?) {
    item?.run {
      helper.setText(R.id.tvUserId, userId)
        .setText(R.id.tvUserName, userName)
        .setText(R.id.tvUserAge, "$userAge")
        .setText(R.id.tvUserSex, getSex())
    }
  }
}