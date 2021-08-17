package com.example.cloudfirestore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun setDB() {

        val db = Firebase.firestore

        val data = hashMapOf(
            "1" to "test"
        )

        db.collection("test")
            .document("1")
            .set(data)
            .addOnSuccessListener {
                Log.e("success", "success!")
            }
            .addOnFailureListener {
                Log.e("error", "error : $it")
            }
    }

    fun getDB() {
        val mainTv: TextView = findViewById(R.id.mainTv)


        val db = Firebase.firestore

        db.collection("test")
            .document("1")
            .get()
            .addOnCompleteListener {
                val snapshot = it.result
                val text: String = snapshot!!.get("1") as String
                mainTv.text = text;
            }
    }
}
