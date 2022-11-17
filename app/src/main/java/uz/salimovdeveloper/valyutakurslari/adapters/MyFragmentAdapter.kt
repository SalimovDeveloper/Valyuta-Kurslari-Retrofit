package uz.salimovdeveloper.valyutakurslari.adapters

import android.content.res.Resources
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.adapter.FragmentStateAdapter
import uz.salimovdeveloper.valyutakurslari.fragments.ConverterFragment
import uz.salimovdeveloper.valyutakurslari.fragments.ValyutaFragment

class MyFragmentAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                ValyutaFragment()
            }
            1 -> {
                ConverterFragment()
            }
            else ->{throw Resources.NotFoundException("Boshqa Fragment yoq")}
        }
    }
}