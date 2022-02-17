package com.ubaya.adv160419035week2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_game.*
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnStart.setOnClickListener {
            // Get playerName
            val playerName=txtName.text.toString()
            // Get Action yang ingin di jalankan (actionGame)
            val action= MainFragmentDirections.actionGameFragment(playerName, 0)
            // Jalankan action tersebut
            Navigation.findNavController(it).navigate(action)
        }
    }
}