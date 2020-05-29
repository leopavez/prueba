package com.leandro.test.Views

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys
import com.leandro.test.R
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val txtusername = findViewById(R.id.txtuser) as EditText
        val txtpassword = findViewById(R.id.txtpassword) as EditText
        val btnlogin = findViewById(R.id.btnlogin) as Button

        encriptardatos()

        btnlogin.setOnClickListener{
            login()

        }

    }


    private fun encriptardatos() {
        //ciframos las credenciales del usuario
        val key = MasterKeys.AES256_GCM_SPEC
        val encriptar = MasterKeys.getOrCreate(key)

        val sharedPreferences = EncryptedSharedPreferences.create("users",encriptar,this, EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM)
        sharedPreferences.edit()
            .putString("username","test")
            .putString("password","1234")
            .putString("nombre","TESTING")
            .apply()

    }

    private fun login(){

        val user = txtuser.text
        val pass = txtpassword.text

        //Iniciamos nuevamente el sharedpreferences para obtener el dato cifrado
        val key = MasterKeys.AES256_GCM_SPEC
        val encriptar = MasterKeys.getOrCreate(key)
        val sharedPreferences = EncryptedSharedPreferences.create("users",encriptar,this, EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM)
        val usuario = sharedPreferences.getString("username", "")
        val password = sharedPreferences.getString("password","")

        if (user.isEmpty() || pass.isEmpty()){
            Toast.makeText(this,"Por favor, rellene todos los campos",Toast.LENGTH_SHORT).show()
        }else{
            if (!user.toString().equals(usuario) || !pass.toString().equals(password)){
                Toast.makeText(this,"Usuario o password invalido, intente otra vez",Toast.LENGTH_SHORT).show()
                txtuser.setText("")
                txtpassword.setText("")
            }else{
                val nombre = sharedPreferences.getString("nombre","")
                val intent = Intent(this, Welcome::class.java).apply {
                    putExtra("nombre_usuario",nombre)
                }
                startActivity(intent)
                finish()
            }

        }

    }

}
