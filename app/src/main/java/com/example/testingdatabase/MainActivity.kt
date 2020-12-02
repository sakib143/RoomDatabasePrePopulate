package com.example.testingdatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.testingdatabase.db.AppDatabase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private var database: AppDatabase? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        database = AppDatabase.invoke(this)

        GlobalScope.launch {
            Log.e("=>"," city list checking ??? " + database!!.cityDao().getAllNamzList().size)
        }
    }
}