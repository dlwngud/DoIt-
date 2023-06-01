package com.dlwngud.ch12_material

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(activity: FragmentActivity):FragmentStateAdapter(activity) {
    private val fragment = listOf(OneFragment(), TwoFragment(), ThreeFragment())
    override fun getItemCount(): Int = fragment.size

    override fun createFragment(position: Int): Fragment = fragment[position]
}