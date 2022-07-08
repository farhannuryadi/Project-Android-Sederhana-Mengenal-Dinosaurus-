package com.farhan.mengenaldinosaurus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvDinos: RecyclerView
    private var list: ArrayList<Dino> = arrayListOf()

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_DETAIL = "extra_detail"
        const val EXTRA_GAMBAR = "extra_gambar"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvDinos = findViewById(R.id.rv_dino)
        rvDinos.setHasFixedSize(true)

        list.addAll(DinosData.listData)
        showRecyclerList()
    }

    private fun showRecyclerList(){
        rvDinos.layoutManager = LinearLayoutManager(this)
        val listDinoAdapter = ListDinoAdapter(list)
        rvDinos.adapter = listDinoAdapter

        listDinoAdapter.setOnItemClickCallback(object : ListDinoAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Dino) {
                startActivity(
                    Intent(this@MainActivity,DetailActivity::class.java)
                            .putExtra(EXTRA_NAME, data.name)
                            .putExtra(EXTRA_DETAIL, data.detail)
                            .putExtra(EXTRA_GAMBAR, data.gambar)
                )
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.custom_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }
    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.action_profile -> {
                val moveProfile = Intent(this@MainActivity, ProfileActivity::class.java)
                startActivity(moveProfile)
            }
        }
    }

}