package com.example.test_bb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import java.io.IOException

class MainActivity : AppCompatActivity() {
    private lateinit var bbAdapter: BBAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bbAdapter = BBAdapter(mutableListOf())
        rvBBc.adapter = bbAdapter
        rvBBc.layoutManager = LinearLayoutManager(this)

        val client = OkHttpClient();


        fun run() {
            val request = Request.Builder()
                .url("https://www.breakingbadapi.com/api/characters")
                .build()


            client.newCall(request).enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    e.printStackTrace()
                }

                override fun onResponse(call: Call, response: Response) {
                    response.use {
                        if (!response.isSuccessful) throw IOException("Unexpected code $response")

                        for ((name, value) in response.headers) {
                            println("$name: $value")

                            this@MainActivity.runOnUiThread(java.lang.Runnable {
                                val char = CharacterBB(name,value)
                                bbAdapter.addChar(char)
                            })
                        }

                        println(response.body!!.string())
                    }
                }
            })



        }

        run();

        // val char = CharacterBB(name,value)
        //bbAdapter.addChar(char)





        println("testtest")
    }
}