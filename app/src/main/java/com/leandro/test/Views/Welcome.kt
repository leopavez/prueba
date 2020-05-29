package com.leandro.test.Views

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.leandro.test.R
import com.leandro.test.ViewModel.IndicadoresViewModel


class Welcome : AppCompatActivity() {
    private lateinit var layoutManager: RecyclerView.LayoutManager
    lateinit var adapter: RecyclerView.Adapter<*>
    lateinit var indicadoresViewModel: IndicadoresViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        val nombre_usuario = intent.getStringExtra("nombre_usuario")
        supportActionBar?.title = "Hola "+ nombre_usuario

        indicadoresViewModel = IndicadoresViewModel()
        indicadoresViewModel.getdataapi()
        layoutManager = GridLayoutManager(this,3) as RecyclerView.LayoutManager
        val listaindicadores = findViewById<ListView>(R.id.listaindicadores)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.activity_welcome_actions, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val intent = Intent(this, MainActivity::class.java).apply {this}
        startActivity(intent)
        finish()
        when (item.itemId){
            R.id.btnlogout-> intent
        }
        return super.onOptionsItemSelected(item)
    }



}
