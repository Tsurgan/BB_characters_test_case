package com.example.test_bb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import java.io.IOException

class MainActivity : AppCompatActivity() {


    private lateinit var bbAdapter: BBAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bbAdapter = BBAdapter(mutableListOf()){position->onListItemClick(position)}
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

                        }
                        val moshi = Moshi.Builder().build()
                        //
                        val listType = Types.newParameterizedType(List::class.java, CharacterBB::class.java)
                        val adapter: JsonAdapter<List<CharacterBB>> = moshi.adapter(listType)
                        val result = adapter.fromJson(response.body!!.string())
                        //
                        if (result!=null){
                            this@MainActivity.runOnUiThread(java.lang.Runnable {


                        for(s_char in result){
                            val char = CharacterBB(s_char.char_id,s_char.name,s_char.birthday,s_char.occupation,s_char.img,s_char.status,s_char.nickname,s_char.appearance,s_char.portrayed,s_char.category,s_char.better_call_saul_appearance)
                            bbAdapter.addChar(char)
                                             }
                            })
                        }
                        //val jsonAdapter = moshi.adapter(CharacterBB::class.java)
                        //val charinfo = jsonAdapter.fromJson(response.body!!.string())
                        //println(charinfo.toString())
                        println(result.toString())

                        //println(response.body!!.string())
                    }
                }
            })



        }

        run();

        // val char = CharacterBB(name,value)
        //bbAdapter.addChar(char)





        println("testtest")
    }
    private fun onListItemClick(position: Int) {

        val fragment=BlankFragment()
        val args = Bundle()
        // Send string data as key value format
        args.putString("char_id",position.toString())
        fragment.arguments=args
        replaceFragment(fragment)
    }
    fun AppCompatActivity.replaceFragment(fragment:Fragment){
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.host,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}