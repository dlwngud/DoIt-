package com.dlwngud.ch11_ex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fm = supportFragmentManager
        val fragmentTransaction = fm.beginTransaction()
        fragmentTransaction.add(R.id.content, OneFragment())
        fragmentTransaction.commit()
    }

    override fun onClick(v: View?) {
        var fr: Fragment? = null

        if(v?.id == R.id.button1){
            fr = OneFragment() //button1이 선택되면 FragmentOne을 보인다
        } else if(v?.id == R.id.button2){
            fr = TwoFragment() //button2이 선택되면 FragmentTwo를 보인다
        }

        val fm = supportFragmentManager
        val fragmentTransaction = fm.beginTransaction()

        // fragment 교체
        fragmentTransaction.replace(R.id.content, fr!!)

        // BackStack안에 들어가 있는 Fragment들이 Pause상태로 유지되고
        // 뒤로 가기를 누르면 담아두었던 Fragment가 다시 꺼내져 화면에 보여진다.
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }


}