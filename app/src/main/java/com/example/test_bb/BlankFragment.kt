package com.example.test_bb

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.google.android.material.snackbar.Snackbar;
import com.squareup.moshi.Json
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import kotlinx.android.synthetic.main.fragment_blank.*
import kotlinx.android.synthetic.main.fragment_blank.view.*

import android.widget.TextView
import androidx.core.view.isVisible
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.CropCircleTransformation
import kotlinx.android.synthetic.main.item_bb.view.*


// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val CHAR_ID = "1"


/**
 * A simple [Fragment] subclass.
 * Use the [BlankFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BlankFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var char_id_data: String? = null
    private var char_name:String? = null
    private var char_birthday:String? = null
    private var char_occupation:List<String>?=null
    private var char_img:String?=null
    private var char_status:String?=null
    private var char_nickname:String?=null
    private var char_appearance:List<Int>?=null
    private var char_portrayed:String?=null
    private var char_category:String?=null
    private var char_better_call_saul_appearance:List<Int>?=null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
           //char_id = CHAR_ID.toInt()
            println("testtest111")
            println(char_id_data)


        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v= inflater.inflate(R.layout.fragment_blank, container, false)
        char_id_data = arguments?.getString("char_id_data")
        char_id_data?.let {
            println("testtest222")
            println(char_id_data)
        }
        char_name=arguments?.getString("char_name")
        char_name?.let {
            v.tvname.text=char_name
        }
        char_birthday=arguments?.getString("char_birthday")
        char_birthday?.let {
            v.tvbirthday.text=char_birthday
        }
        char_occupation=arguments?.getStringArrayList("char_occupation")
        char_occupation?.let {
            v.tvoccupation.text=char_occupation.toString()
        }
        char_img=arguments?.getString("char_img")
        char_img?.let {
            Picasso.get().load(char_img).transform(CropCircleTransformation()).into(v.ivimg)
            Picasso.get().load(char_img).into(v.expandedImage)

        }
        char_status=arguments?.getString("char_status")
        char_status?.let {
            v.tvstatus.text=char_status
        }
        char_nickname=arguments?.getString("char_nickname")
        char_nickname?.let {
            v.tvnickname.text=char_nickname
        }
        char_appearance=arguments?.getIntegerArrayList("char_appearance")
        char_appearance?.let {
            v.tvabb.text=char_appearance.toString()
        }
        char_portrayed=arguments?.getString("char_portrayed")
        char_portrayed?.let {
            v.tvportrayed.text=char_portrayed
        }

        char_better_call_saul_appearance=arguments?.getIntegerArrayList("char_better_call_saul_appearance")
        char_better_call_saul_appearance?.let {
            v.tvabcs.text=char_better_call_saul_appearance.toString()
        }
        char_category=arguments?.getString("char_category")
        char_category?.let {

            if (char_category=="Breaking Bad"){
                v.tvcbcs.isVisible=false
                v.tvcbcs.isVisible=false

            }
            if (char_category=="Better Call Saul"){
                v.tvcbb.isVisible=false
                v.tvabb.isVisible=false
            }
            if (char_category=="Breaking Bad, Better Call Saul"){

            }
            v.bback.setOnClickListener { getActivity()?.onBackPressed();  }
        }
        return v;
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.

         * @return A new instance of fragment BlankFragment.
         */

        @JvmStatic
        fun newInstance(char_id: String) =
            BlankFragment().apply {
                arguments = Bundle().apply {
                    val char_id1= CHAR_ID

                }
            }
    }
}