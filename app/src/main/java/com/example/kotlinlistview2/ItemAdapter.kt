package com.example.kotlinlistview2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import org.w3c.dom.Text

class ItemAdapter(var context: Context,var list: ArrayList<Person>): BaseAdapter() {
    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(position: Int): Any? {
        return list.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(
        position: Int,
        convertView: View?,
        parent: ViewGroup?
    ): View? {
        var view: View? = convertView
        var holder: PersonHolder
        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.itemlayout, null)
            holder = PersonHolder()
            holder.imageView = view.findViewById<ImageView>(R.id.imageView)
            holder.textView = view.findViewById<TextView>(R.id.textView)
            view.setTag(holder)
        }else holder = view.getTag() as PersonHolder
        ///
        holder.imageView!!.setImageResource(list.get(position).image)
        holder.textView!!.setText(list.get(position).name)
        return view
    }
    private class PersonHolder(){
        var imageView: ImageView?=null
        var textView: TextView?=null
    }
}
