package com.sprint.gina.kotlinfuns1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    companion object {
        // put "static" properties and functions here
        val TAG = "MainActivityTag"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var textView = findViewById<TextView>(R.id.textView)
        textView.setText("Let's learn Kotlin in 20 mins!!")

        // kotlin is an open source, statically typed language
        // designed to fully interoperate with Java
        // kotlin syntax is short and sweet

        // variables
        // use var for a variable and use val for constants
        var x: Int = 5
        val constant = 10
        var y: Int
        y = 7

        // string templates
        Log.d(TAG, "onCreate: x=$x y=$y 2*y=${y * 2}")

        // nullable: a variable that is either a value or null
        var n: Int? = 5
        n = null
        // new operators
        // !! (not null assertion operator)
        // ?. (null safety operator)
        // ?: (elvis operator)

        var myStr: String? = "hello"
        Log.d(TAG, "onCreate: " + myStr!!.length) // crashes if myStr is null
        // better to use an if (myStr != null) first 
        Log.d(TAG, "onCreate: " + myStr?.length)
        val temp: String = myStr ?: ""
        
        // if, when, for, while they return a value
        val month = "December"
        val officeBuilding = if (month == "December") {
            "Bollier"
        }
        else {
            "Herak"
        }
        Log.d(TAG, "onCreate: officeBuilding=$officeBuilding")
        
        // lots of for loop styles
        for (i in 0..3) { // 3 inclusive
            Log.d(TAG, "onCreate: i=$i")
        }
        for (j in 5 downTo 0 step 1) {
            Log.d(TAG, "onCreate: j=$j")
        }
        
        // functions 
        val nums = listOf(1, 2, 3, 4, 5)
        val sum = sumList(nums)
        Log.d(TAG, "onCreate: sum=$sum")
        
        // OOP
        // default primary constructor is available immediately
        var dog = Dog("Odin", 9)
        Log.d(TAG, "onCreate: dog=$dog")
    }
    
    open class Dog(var name: String, var age: Int) { // declares properties as part of
        // the primary constructor
        init {
            // this is the body of the constructor
            Log.d(TAG, "in init: ")
        }

        override fun toString(): String {
            return name + " is a " + age + " year old dog"
        }
    }
    // classes are final by default (they can not be inherited)
    // add open to make it inheritable

    class ShowDog(name: String, age: Int, var numAwards: Int) : Dog(name, age) {

    }
    
    fun sumList(nums: List<Int>): Int { // Unit is like void
        var sum = 0
        for (num in nums) {
            sum += num 
        }
        return sum 
    }
}