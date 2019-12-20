package com.example.android_clean_arc_components.modules.dashboard.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.android_clean_arc_components.R
import com.example.android_clean_arc_components.modules.dashboard.model.SearchResponse

class SearchResponseAdapter(val blogList: List<SearchResponse>?) :
    RecyclerView.Adapter<SearchResponseAdapter.ViewHolder>() {


    override fun getItemCount() = blogList!!.size

    private var mContext: Context? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        this.mContext = parent.context;

        val view =
            LayoutInflater.from(parent.context).inflate(
                R.layout.list_view,
                parent,
                false
            )

        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val mBlog = blogList!!.get(position);


        if (mBlog.title != null) {
            holder.tvTitle.setText(mBlog.title);
        }

        if (mBlog.body != null) {
            holder.tvDescription.setText(mBlog.body);
        }

    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val tvTitle: TextView = itemView.findViewById(R.id.title);
        val tvDescription: TextView = itemView.findViewById(R.id.description);

    }
}