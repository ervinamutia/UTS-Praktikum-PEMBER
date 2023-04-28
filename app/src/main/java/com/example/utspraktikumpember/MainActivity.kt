package com.example.utspraktikumpember

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private val list = ArrayList<data>()

    private val mRecyclerView=findViewById<RecyclerView>(R.id.recyclerview)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        list.addAll(getData())

        showLinear()
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_data, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.linear -> showLinear()
            R.id.grid -> showGrid()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun showGrid() {
        mRecyclerView.layoutManager=GridLayoutManager(this, 2)
        val adapter = adapter_gridLayout(list)
        findViewById<RecyclerView>(R.id.recyclerview).adapter=adapter
    }

    private fun showLinear() {
        mRecyclerView.layoutManager=LinearLayoutManager(this)
        val adapter = adapter_linearLayout(list)
        findViewById<RecyclerView>(R.id.recyclerview).adapter=adapter
    }

    private fun getData(): ArrayList<data> {
        val dataPic = resources.getIntArray(R.array.gambarnya)
        val dataNama = resources.getStringArray(R.array.nama)
        val dataKet = resources.getStringArray(R.array.keterangan)
        val dataNim = resources.getStringArray(R.array.nim)
        val listData = ArrayList<data>()
        for (i in dataPic.indices){
            val tokoh = data(dataPic[i], dataNama[i], dataKet[i], dataNim[i])
            listData.add(tokoh)
        }
        return listData
    }
}