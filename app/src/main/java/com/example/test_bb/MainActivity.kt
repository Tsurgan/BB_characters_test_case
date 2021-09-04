package com.example.test_bb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
class MainActivity : AppCompatActivity() {
    private lateinit var bbAdapter: BBAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bbAdapter = BBAdapter(mutableListOf())
        rvBBc.adapter = bbAdapter
        rvBBc.layoutManager = LinearLayoutManager(this)
        val name="PlaceHolder";
        val char = CharacterBB(name)
        bbAdapter.addChar(char)
        bbAdapter.addChar(char)
        bbAdapter.addChar(char)
        bbAdapter.addChar(char)
        bbAdapter.addChar(char)
        bbAdapter.addChar(char)
        bbAdapter.addChar(char)
        bbAdapter.addChar(char)
        bbAdapter.addChar(char)
        bbAdapter.addChar(char)
        bbAdapter.addChar(char)
        bbAdapter.addChar(char)

        println("testtest")
    }
}