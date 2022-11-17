package uz.salimovdeveloper.valyutakurslari.fragments

import android.content.res.Resources
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import uz.salimovdeveloper.valyutakurslari.R
import uz.salimovdeveloper.valyutakurslari.adapters.MyFragmentAdapter
import uz.salimovdeveloper.valyutakurslari.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var myFragmentAdapter: MyFragmentAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)


        binding.btnMenu.setOnClickListener {
            binding.draw.open()
        }

        setTab()

        binding.navView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.menu_app_about ->{
                    Toast.makeText(
                        requireContext(),
                        "Dastur asosan valyutala kurslari haqida ma'lumot olish uchun ishlab chiqildi",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                R.id.menu_developer_about->{
                    Toast.makeText(
                        requireContext(),
                        "Dastur Salimov Sardorbek tomonidan ishlab chiqildi!!!",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
            true
        }


        return binding.root
    }

    private fun setTab() {
        myFragmentAdapter = MyFragmentAdapter(requireActivity())

        binding.myViewPager2.adapter = myFragmentAdapter

        binding.tabLayout.tabIconTint = null

        TabLayoutMediator(binding.tabLayout, binding.myViewPager2){
            tab, position ->

            when(position){
                0->{
                    tab.setIcon(R.drawable.ic_home)
                    tab.icon?.setTint(ContextCompat.getColor(requireContext(), R.color.qoshimcha_rang))
                }
                1-> {
                    tab.setIcon(R.drawable.ic_converter)
//                    tab.icon?.setTint(ContextCompat.getColor(requireContext(), R.color.qoshimcha_rang))
                }
            }

        }.attach()

        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab?.icon?.setTint(ContextCompat.getColor(requireContext(), R.color.qoshimcha_rang))
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                tab?.icon?.setTint(ContextCompat.getColor(requireContext(), R.color.white))
            }

            override fun onTabReselected(tab: TabLayout.Tab) {
            }

        })
    }
}