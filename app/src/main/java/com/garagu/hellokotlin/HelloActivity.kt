package com.garagu.hellokotlin

/**
 * Created by garagu.
 */
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_hello.*

class HelloActivity : AppCompatActivity(), HelloAdapter.OnItemClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hello)
        initList()
    }

    fun initList() {
        with(recyclerView) {
            addItemDecoration(DividerItemDecoration(this@HelloActivity, DividerItemDecoration.VERTICAL))
            layoutManager = LinearLayoutManager(this@HelloActivity)
            adapter = HelloAdapter(getItems(), this@HelloActivity)
        }
    }

    fun getItems(): List<HelloModel> {
        val list: MutableList<HelloModel> = mutableListOf()
        for (i in 1..10) list.add(HelloModel("name " + i, i, "address " + i))
        return list
    }

    override fun onClick(item: HelloModel) {
        Toast.makeText(this@HelloActivity, "Hi " + item.name, Toast.LENGTH_SHORT).show()
    }

}