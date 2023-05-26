package com.dlwngud.ch11_ex

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dlwngud.ch11_ex.databinding.FragmentOneBinding
import com.dlwngud.ch11_ex.databinding.ItemOneFragmentBinding

class OneFragment : Fragment() {

    lateinit var binding: FragmentOneBinding
    lateinit var mainActivity: MainActivity

    // 항목에 필요한 뷰 객체를 가짐
    class MyViewHolder(val binding: ItemOneFragmentBinding) : RecyclerView.ViewHolder(binding.root)

    // 항목을 구성(데이터 대입)
    class MyAdapter(private val dataSet: MutableList<UserData>) :
        RecyclerView.Adapter<RecyclerView.ViewHolder>() {

        // 뷰 홀더의 뷰에 데이터를 출력
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
            MyViewHolder(
                ItemOneFragmentBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )

        // 항목의 뷰를 가지는 뷰 홀더를 준비
        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            val binding = (holder as MyViewHolder).binding

            val item = dataSet[position]
            // 뷰에 데이터 출력
            binding.imgUserIcon.setImageDrawable(dataSet[position].img)
            binding.txtUserId.text = dataSet[position].id
            binding.txtUserName.text = dataSet[position].name

            // 뷰에 이벤트 추가
//            binding.itemRoot.setOnClickListener{
//                // Toast.makeText(,"item root click : $position", Toast.LENGTH_SHORT).show()
//                Log.d("kkang","item root click : $position")
//            }
        }

        // 항목 개수를 판단
        override fun getItemCount(): Int = dataSet.size

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOneBinding.inflate(inflater, container, false)

        val dataSet = mutableListOf<UserData>()
        for(i in 1..10){
            dataSet.add(UserData(ContextCompat.getDrawable(requireActivity(), R.drawable.ic_baseline_man_24)!!,"$i","name $i"))
        }

        binding.rv.layoutManager = LinearLayoutManager(activity)
        binding.rv.adapter = MyAdapter(dataSet)
        binding.rv.addItemDecoration(DividerItemDecoration(activity, LinearLayoutManager.VERTICAL))

        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        // Context를 액티비티로 형변환해서 할당
        mainActivity = context as MainActivity
    }

}