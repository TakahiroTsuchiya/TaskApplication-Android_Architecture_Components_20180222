package com.example.viewmodelsample

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v4.app.Fragment
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * A placeholder fragment containing a simple view.
 */
class MainActivityFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val userA = ViewModelProviders.of(this).get(UserViewModel::class.java)
        val userB = ViewModelProviders.of(activity!!).get(UserViewModel::class.java)
        val userC = ViewModelProviders.of(this).get(UserViewModel::class.java)

        Log.d("Fragment A", userA.toString())
        Log.d("Fragment B", userB.toString())
        Log.d("Fragment C", userC.toString())
        Log.d("Fragment AA", userA.getUser().toString())
        Log.d("Fragment BB", userB.getUser().toString())
        Log.d("Fragment CC", userC.getUser().toString())

        userA.getUser()?.observe(this, Observer {
            Log.d("OLYMPICS", it?.toString())
        })

        userB.getUser()?.observe(this, Observer {
            Log.d("OLYMPICS", it?.toString())
        })

        userC.getUser()?.observe(this, Observer {
            Log.d("OLYMPICS", it?.toString())
        })
    }
}
