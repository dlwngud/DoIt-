package com.dlwngud.ch11_ex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.dlwngud.ch11_ex.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fm = supportFragmentManager
        val fragmentTransaction = fm.beginTransaction()
        fragmentTransaction.add(R.id.content, OneFragment())
        fragmentTransaction.commit()

        // 뷰 페이저에 어댑터 적용
        val adapter = MyFragmentPagerAdapter(this)
        binding.vp.adapter = adapter

        binding.toolbar.inflateMenu(R.menu.menu)

        // ActionBarDrawerToggle 버튼 적용
        toggle = ActionBarDrawerToggle(
            this,
            binding.drawer,
            R.string.drawer_opened,
            R.string.drawer_closed
        )
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toggle.syncState()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        //  이벤트가 토글 버튼에서 발생하면
        if(toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
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



    // 뷰 페이저 어댑터
    class MyFragmentPagerAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {
        val fragments: List<Fragment>

        init {
            fragments = listOf(OneFragment(), TwoFragment())
        }

        override fun getItemCount(): Int {
            return fragments.size
        }

        override fun createFragment(position: Int): Fragment {
            return fragments[position]
        }
    }
}