package com.example.fragmentos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {

    private var fragmentoActual: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnFragmento2 = findViewById<Button>(R.id.desplFragmento2)
        val btnFragmento3 = findViewById<Button>(R.id.desplFragmento3)

        if (savedInstanceState != null) {
            if (savedInstanceState.getString("Fragmento") == "Fragmento1") {
                actualizaFragmento(Fragmento1(), "Fragmento1")
            } else if (savedInstanceState.getString("Fragmento") == "Fragmento2") {
                actualizaFragmento(Fragmento2(), "Fragmento2")
            } else if (savedInstanceState.getString("Fragmento") == "Fragmento3") {
                actualizaFragmento(Fragmento3(), "Fragmento3")
            }
        } else {
            actualizaFragmento(Fragmento1(), "Fragmento1")
        }

        /*
        btnFragmento2.setOnClickListener {
            actualizaFragmento(Fragmento2())
        }

        btnFragmento3.setOnClickListener {
            actualizaFragmento(Fragmento3())
        }*/

    }

    private fun actualizaFragmento(fragmento: Fragment, tag: String?) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentos, fragmento)
        fragmentTransaction.commit()
        fragmentoActual = tag
    }

    fun onClick(v: View) {
        if (v.id == R.id.desplFragmento2)
          cambiarFragmento2()
        else if (v.id == R.id.desplFragmento3)
          cambiarFragmento3()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("Fragmento", fragmentoActual)
    }


    fun cambiarFragmento1() {
        actualizaFragmento(Fragmento1(), "Fragmento1")
    }
    private fun cambiarFragmento2() {
        actualizaFragmento(Fragmento2(),"Fragmento2")
    }
    private fun cambiarFragmento3() {
        actualizaFragmento(Fragmento3(),"Fragmento3")
    }
}
