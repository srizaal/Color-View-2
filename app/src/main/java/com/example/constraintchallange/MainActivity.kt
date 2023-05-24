package com.example.constraintchallange

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.example.constraintchallange.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        setListeners()
    }

    private fun changeColor(view: View){
        when (view.id) {
            R.id.blue_box -> setColor("Blue", R.color.blue)
            R.id.red_box -> setColor("Red", R.color.red)
            R.id.greenbox -> setColor("Green",R.color.green)
            R.id.orangebox -> setColor("Orange",R.color.orange)
            R.id.purple_box -> setColor("Purple",R.color.purple)
            R.id.grey_box -> setColor("Grey",R.color.grey)
            R.id.clearbox -> defaultColor()
        }
    }


    private fun setColor(warna: String, color: Int){
        binding.blueBox.setBackgroundResource(color)
        binding.redBox.setBackgroundResource(color)
        binding.greenbox.setBackgroundResource(color)
        binding.orangebox.setBackgroundResource(color)
        binding.purpleBox.setBackgroundResource(color)
        binding.greyBox.setBackgroundResource(color)
        binding.clearbox.setBackgroundResource(color)

        val toast = Toast.makeText(this, "Berhasil mengembalikan warna"+warna, Toast.LENGTH_SHORT)
        toast.setGravity(Gravity.TOP,0,0)
        toast.show()
    }


    private fun  defaultColor(){
        binding.blueBox.setBackgroundResource(R.color.blue)
        binding.redBox.setBackgroundResource(R.color.red)
        binding.greenbox.setBackgroundResource(R.color.green)
        binding.orangebox.setBackgroundResource(R.color.orange)
        binding.purpleBox.setBackgroundResource(R.color.purple)
        binding.greyBox.setBackgroundResource(R.color.grey)

        val toast = Toast.makeText(this, "Berhasil mengembalikan warna default", Toast.LENGTH_SHORT)
        toast.setGravity(Gravity.TOP,0,0)
        toast.show()

//        val snackB = Snackbar.make(requireViewById(R.id.greenbox),"test", Snackbar.LENGTH_SHORT)
//        snackB.view.setBackgroundResource(R.color.green)
//        snackB.setTextColor(getColor(R.color.black))
//        snackB.show()

    }


    private fun setListeners(){
        val oneBoxBlue = findViewById<TextView>(R.id.blue_box)
        val twoBoxRed = findViewById<TextView>(R.id.red_box)
        val threeBoxGreen = findViewById<TextView>(R.id.greenbox)
        val fourBoxOrange = findViewById<TextView>(R.id.orangebox)
        val fiveBoxPurple = findViewById<TextView>(R.id.purple_box)
        val sixBoxGrey = findViewById<TextView>(R.id.grey_box)
        val blackBox = findViewById<TextView>(R.id.clearbox)


        val rootConstraintLayout = findViewById<View>(R.id.constraint_layout)

        val clickableViews: List<View> =
            listOf(
                oneBoxBlue, twoBoxRed, threeBoxGreen, fourBoxOrange, fiveBoxPurple, sixBoxGrey, blackBox, rootConstraintLayout
            )

        for (item in clickableViews){
            item.setOnClickListener { (changeColor(it)) }
        }

    }
}