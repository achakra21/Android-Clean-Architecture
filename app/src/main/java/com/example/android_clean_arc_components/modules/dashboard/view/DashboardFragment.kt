package com.example.android_clean_arc_components.modules.dashboard.view

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

import com.example.android_clean_arc_components.R
import com.example.android_clean_arc_components.modules.dashboard.model.SearchResponse
import com.example.android_clean_arc_components.modules.dashboard.viewmodel.DashboardViewModel
import kotlinx.android.synthetic.main.fragment_dashboard.*

class DashboardFragment : Fragment() {

    private lateinit var dashboardViewModel: DashboardViewModel
    var mBlogAdapter: SearchResponseAdapter? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        dashboardViewModel =
            ViewModelProviders.of(this).get(DashboardViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_dashboard, container, false)



        getPopularBlog()

        return root
    }

    fun getPopularBlog() {
        dashboardViewModel!!.allBlog.observe(this, Observer { blogList ->
            prepareRecyclerView(blogList)
        })
    }

    private fun prepareRecyclerView(blogList: List<SearchResponse>) {
        mBlogAdapter = SearchResponseAdapter(blogList)
        if (this.resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {

            recyclerview.setLayoutManager(LinearLayoutManager(activity))
        } else {
            recyclerview.setLayoutManager(GridLayoutManager(activity, 4))
        }
        //recyclerview.setItemAnimator(DefaultItemAnimator())
        recyclerview.setAdapter(mBlogAdapter)
    }
}


