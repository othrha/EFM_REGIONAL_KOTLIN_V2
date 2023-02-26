package com.example.efmkotlin1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var button:Button
    lateinit var input:EditText
    lateinit var emptyOrBlankText:TextView
    lateinit var sigle1:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button=findViewById(R.id.button)
        input=findViewById(R.id.inputtext)
        emptyOrBlankText=findViewById(R.id.emptyOrBlank)
        sigle1=findViewById(R.id.sigle)

        button.setOnClickListener {
            val stringEnterByUser:String=input.text.toString()
            verifierString(stringEnterByUser)
            sigle1.text=stringEnterByUser.sigle()
        }
    }
    fun verifierString(str:String){
        if (str.isBlank()){
            emptyOrBlankText.text="it is Blank"
        }else if(str.isEmpty()){
            emptyOrBlankText.text="it is Empty"
        }else {
            emptyOrBlankText.text="not blank or empty"
        }
    }
    fun String.sigle(): String {
        val mots= this.split(" ").filter { it.isNotBlank() }
        val sigle = StringBuilder()
        for (mot in mots) {
            sigle.append(mot[0].toUpperCase())
        }
        return sigle.toString()}
}