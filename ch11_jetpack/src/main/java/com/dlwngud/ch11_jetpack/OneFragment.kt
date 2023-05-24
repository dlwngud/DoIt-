package com.dlwngud.ch11_jetpack

import android.content.Context
import android.graphics.Canvas
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dlwngud.ch11_jetpack.databinding.ItemRecyclerviewBinding

class OneFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_one, container, false)
    }
}

// 항목 뷰를 가지는 역할
class MyViewHolder(val binding: ItemRecyclerviewBinding) : RecyclerView.ViewHolder(binding.root)

// 항목 구성자 (어뎁터)
class MyAdapter(val datas: MutableList<String>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    // 항목 뷰를 가지는 뷰 홀더를 준비하기 위해 자동 호출
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        MyViewHolder(
            ItemRecyclerviewBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )

    // 각 항목을 구성하기 위해 호출
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val binding = (holder as MyViewHolder).binding

        // 뷰에 데이터 출력
        binding.itemData.text = datas[position]
    }

    // 항목 개수를 판단하기 위해 자동 호출
    override fun getItemCount(): Int {
        return datas.size
    }
}