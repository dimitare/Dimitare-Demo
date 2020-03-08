package com.dimitare.angdim.utils

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dimitare.angdim.fragments.*
import com.dimitare.angdim.model.ResumeError
import com.dimitare.angdim.model.ResumeItem
import com.dimitare.angdim.model.ResumeResponse
import com.dimitare.angdim.model.resume.*
import com.dimitare.angdim.services.remote.RemoteResource

@BindingAdapter("data")
fun <T> setRecyclerViewProperties(
    recyclerView: RecyclerView,
    items: Collection<ResumeItem>?
) {
    items?.let {
        (recyclerView.adapter as? HomeAdapter)?.setData(items)
        recyclerView.adapter?.notifyDataSetChanged()
    }
}

@BindingAdapter("skillsData")
fun <T> setSkillsRecyclerView(
    recyclerView: RecyclerView,
    items: Collection<SkillCategory>?
) {
    items?.let {
        (recyclerView.adapter as? SkillsAdapter)?.setData(items)
        recyclerView.adapter?.notifyDataSetChanged()
    }
}

@BindingAdapter("positionsData")
fun <T> setPositionsRecyclerView(
    recyclerView: RecyclerView,
    items: Collection<Positions>?
) {
    items?.let {
        (recyclerView.adapter as? PositionsAdapter)?.setData(items)
        recyclerView.adapter?.notifyDataSetChanged()
    }
}

@BindingAdapter("responsibilitiesData")
fun <T> setResponsibilitiesRecyclerView(
    recyclerView: RecyclerView,
    items: Collection<Responsibilities>?
) {
    items?.let {
        (recyclerView.adapter as? ResponsibilitiesAdapter)?.setData(items)
        recyclerView.adapter?.notifyDataSetChanged()
    }
}

@BindingAdapter("achievementsData")
fun <T> setAchievementsRecyclerView(
    recyclerView: RecyclerView,
    items: Collection<Achievements>?
) {
    items?.let {
        (recyclerView.adapter as? AchievementsAdapter)?.setData(items)
        recyclerView.adapter?.notifyDataSetChanged()
    }
}

@BindingAdapter("schoolsData")
fun <T> setSchoolsRecyclerView(
    recyclerView: RecyclerView,
    items: Collection<Schools>?
) {
    items?.let {
        (recyclerView.adapter as? SchoolsAdapter)?.setData(items)
        recyclerView.adapter?.notifyDataSetChanged()
    }
}

@BindingAdapter("app:avatarUrl")
fun loadAvatarImage(view: ImageView, url: String?) {
    url?.let {
        Glide.with(view).load(url).into(view)
    }
}

@BindingAdapter("app:error")
fun updateErrorText(view: TextView, status: RemoteResource<ResumeResponse?, ResumeError>?) {
    status?.let {
        when(it){
            is RemoteResource.Error -> {
                view.text = it.errorData?.message
            }
            else -> {
                view.text = null
            }
        }
    }
}

fun updateProgressBarVisibility(status: RemoteResource<ResumeResponse?, ResumeError>?): Int {
    status?.let {
        when (it) {
            is RemoteResource.Loading -> return View.VISIBLE
            else -> View.GONE
        }
    }
    return View.GONE
}

fun updateErrorTextViewVisibility(status: RemoteResource<ResumeResponse, ResumeError>?): Int {
    status?.let {
        when (it) {
            is RemoteResource.Error -> return View.VISIBLE
            else -> View.GONE
        }
    }
    return View.GONE
}

fun updateRecyclerViewVisibility(status: RemoteResource<ResumeResponse, ResumeError>?): Int {
    status?.let {
        when (it) {
            is RemoteResource.Error -> return View.GONE
            else -> View.VISIBLE
        }
    }
    return View.VISIBLE
}