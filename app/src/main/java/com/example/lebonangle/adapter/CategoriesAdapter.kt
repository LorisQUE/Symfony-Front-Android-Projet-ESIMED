package com.example.lebonangle.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.lebonangle.AdvertCreateActivity
import com.example.lebonangle.AdvertsActivity
import com.example.lebonangle.R
import com.example.lebonangle.api.CategoriesJson

class CategoriesAdapter(pContext:Context, pCategories:CategoriesJson):RecyclerView.Adapter<CategoriesAdapter.CategoriesViewHolder>() {

    val context:Context = pContext
    val categories:CategoriesJson = pCategories

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder {
        val inflater:LayoutInflater = LayoutInflater.from(context)
        val view:View = inflater.inflate(R.layout.category_row, parent, false)
        return CategoriesViewHolder(view)
    }

    override fun getItemCount(): Int {
        return categories.size
    }

    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
        val id = "#" + categories[position].id.toString()
        holder.txtId.setText(id)
        holder.txtName.setText(categories[position].name)

        holder.cardview.setOnClickListener(View.OnClickListener {

            val intent = Intent(context, AdvertsActivity::class.java)
            intent.putExtra("category", categories[position].id)
            startActivity(context, intent, null)

        })
    }


    class CategoriesViewHolder(row: View) : RecyclerView.ViewHolder(row) {
        val cardview: CardView = row.findViewById(R.id.cardViewCategories)
        val txtId:TextView = row.findViewById(R.id.txtViewCategoriesId)
        val txtName:TextView = row.findViewById(R.id.txtViewCategoriesName)
    }
}