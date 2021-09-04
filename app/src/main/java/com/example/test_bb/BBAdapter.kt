package com.example.test_bb

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_bb.view.*
class BBAdapter (
    private val chars: MutableList<CharacterBB>
        ) : RecyclerView.Adapter<BBAdapter.CharBBViewHolder>() {
    class CharBBViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharBBViewHolder {
       return CharBBViewHolder(
           LayoutInflater.from(parent.context).inflate(
               R.layout.item_bb,parent,false
           )
       )
    }
    fun addChar(char: CharacterBB) {
        chars.add(char)
        notifyItemInserted(chars.size - 1)
    }
    override fun onBindViewHolder(holder: CharBBViewHolder, position: Int) {
        val curChar=chars[position]


        holder.itemView.apply {
          tvBBc.text = curChar.name
            //ivBBc.setImageURI(curChar.img);
        }
    }

    override fun getItemCount(): Int {
        return chars.size
    }
}