package com.example.fastcampus

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class FragmentOne : Fragment() {


    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("testt", "Fragment - onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("testt", "Fragment - onCreate")
        arguments?.run {
            val data: String? = this.getString("data")
            Log.d("testt", "data is " + data)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("testt", "Fragment - onCreateView")
        return inflater.inflate(R.layout.one_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d("testt", "Fragment - onActivityCreated")
    }

}