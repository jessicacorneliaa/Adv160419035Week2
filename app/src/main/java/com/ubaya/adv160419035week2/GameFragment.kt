package com.ubaya.adv160419035week2

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_game.*
import kotlin.math.log
import kotlin.random.Random

class GameFragment : Fragment() {
    var scoree=0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var playerName=""

        val random1= List(1){ Random.nextInt(1,100)}
        val random2= List(1){ Random.nextInt(1,100)}
        txtAngka1.text=random1.first().toString()
        txtAngka2.text=random2.first().toString()

        val angka1= Integer.parseInt(txtAngka1.text.toString())
        val angka2= Integer.parseInt(txtAngka2.text.toString())

        var hasil= angka1+angka2


        arguments?.let {
            playerName= GameFragmentArgs.fromBundle(requireArguments()).playerName
            txtTurn.text="$playerName's Turn"

            var score= GameFragmentArgs.fromBundle(requireArguments()).score
            scoree=score
            Log.e("scoreargs","$scoree")
        }
        btnSubmit.setOnClickListener {
            Log.e("soal","$angka1+$angka2")
            Log.e("Hasil=",hasil.toString())
            Log.e("Jawaban=",editAnswer.text.toString())

            if (hasil.toString() == editAnswer.text.toString()){
                scoree++
                Log.e("scoreif","$scoree")

                val action= GameFragmentDirections.actionGameFragmentSelf(playerName,scoree)
                Navigation.findNavController(it).navigate(action)
            }else{
                Log.e("else","salah")
                // Get Action yang ingin di jalankan (actionGame)
                val action= GameFragmentDirections.actionResultFragment(scoree)
                // Jalankan action tersebut
                Navigation.findNavController(it).navigate(action)
            }
        }
    }
}