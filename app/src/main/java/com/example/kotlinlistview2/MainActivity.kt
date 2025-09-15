package com.example.kotlinlistview2

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), View.OnClickListener, AdapterView.OnItemClickListener {

    lateinit var listView: ListView
    var list: ArrayList<Person> = ArrayList<Person>()


    lateinit var builder: AlertDialog.Builder
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ///
        list.add(Person(R.drawable.andrea, "Andrea"))
        list.add(Person(R.drawable.anne, "Anne"))
        list.add(Person(R.drawable.barbie, "Barbie"))
        list.add(Person(R.drawable.ella, "Ella"))
        list.add(Person(R.drawable.janella, "Janella"))
        list.add(Person(R.drawable.loisa, "Loisa"))
        list.add(Person(R.drawable.maris, "Maris"))


        listView = findViewById<ListView>(R.id.listView1)
        var adapter: ItemAdapter = ItemAdapter(this,list)
        listView.adapter = adapter

        builder = AlertDialog.Builder(this)
        builder.setTitle("Selected Person")
        builder.setNegativeButton("okey", null)

        listView.setOnItemClickListener(this)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onItemClick(
        parent: AdapterView<*>?,
        view: View?,
        position: Int,
        id: Long
    ) {
        var selectedItem = listView.getItemAtPosition(position) as Person
        builder.setIcon(selectedItem.image)
        builder.setMessage(selectedItem.name)
        var dialog: AlertDialog = builder.create()
        dialog.show()
    }

    override fun onClick(v: View?) {
        TODO("Not yet implemented")
    }
}