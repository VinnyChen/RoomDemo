package com.vinny.roomdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.vinny.roomdemo.db.MainAdapter
import com.vinny.roomdemo.db.dao.UserDao
import com.vinny.roomdemo.db.database.AppDatabase
import com.vinny.roomdemo.db.entity.UserEntity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

  private var userDao: UserDao? = null
  private lateinit var mAdapter: MainAdapter
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    userDao = AppDatabase.getInstance(this@MainActivity)?.getUserDao()
    initView()
    initListener()

  }

  private fun initView() {
    with(main_list) {
      layoutManager = LinearLayoutManager(this@MainActivity)
      mAdapter = MainAdapter(this@MainActivity)
      adapter = mAdapter
    }
  }

  private fun initListener() {
    initAddListener()
    initDeleteListener()
    initUpdateListener()
    initQueryListener()
    initLiveData()
  }

  private fun initLiveData() {

  }

  private fun initAddListener() {
    //增加
    insert_one.setOnClickListener {
      userDao?.insert(UserEntity("100", "小A", 24, 1))
      updateList()
    }
    //增加列表
    insert_list.setOnClickListener {
      val entity = UserEntity("101", "小B", 25, 0)
      val entity1 = UserEntity("102", "小C", 24, 0)
      val entity2 = UserEntity("103", "小D", 20, 1)
      val list = ArrayList<UserEntity>()
      list.add(entity)
      list.add(entity1)
      list.add(entity2)
      userDao?.insertList(list)
      updateList()
    }
  }

  private fun initDeleteListener() {
    //删除
    delete_entity.setOnClickListener {
      val entity = UserEntity("100", "小A", 24, 0)
      userDao?.delete(entity)
      updateList()
    }
    // 根据id删除某一项
    delete_by_id.setOnClickListener {
      userDao?.deleteById("101")
      updateList()
    }
    // 删除多个
    delete_list.setOnClickListener {
      val entity = UserEntity("100", "小A", 24, 0)
      val entity1 = UserEntity("101", "小B", 25, 0)
      userDao?.delete(entity, entity1)
      updateList()
    }
    // 删除全部
    delete_all.setOnClickListener {
      userDao?.deleteAll()
      updateList()
    }
  }

  private fun initUpdateListener() {
    //修改
    update_entity.setOnClickListener {
      val entity = UserEntity("100", "小A刀刀", 30, 0)
      userDao?.update(entity)
      updateList()
    }
    update_by_id.setOnClickListener {
      userDao?.update("103", "A大大")
      updateList()
    }
  }

  private fun initQueryListener() {
    //查询
    query_by_id.setOnClickListener {
      mAdapter.setNewData(userDao?.query("102"))

    }
    query_all.setOnClickListener {
      updateList()
    }
  }

  /**
   * 更新列表
   */
  private fun updateList() {
    mAdapter.setNewData(userDao?.query())
  }
}
