package com.example.test_bb

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.CropCircleTransformation
import kotlinx.android.synthetic.main.item_bb.view.*
class BBAdapter (
    private val chars: MutableList<CharacterBB>,
    private val onItemClicked: (position: Int) -> Unit
        ) : RecyclerView.Adapter<BBAdapter.CharBBViewHolder>() {
    class CharBBViewHolder (itemView: View,private val onItemClicked: (position: Int) -> Unit) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharBBViewHolder {
       return CharBBViewHolder(
           LayoutInflater.from(parent.context).inflate(
               R.layout.item_bb,parent,false
           ),onItemClicked

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
            Picasso.get().load(curChar.img).transform(CropCircleTransformation()).into(ivBBc)
            setOnClickListener { onItemClicked(curChar.char_id) }
            //Picasso.get().load(curChar.img).into(ivBBc)
            //ivBBc.setImageURI(curChar.img);
        }
    }

    override fun getItemCount(): Int {
        return chars.size
    }
}