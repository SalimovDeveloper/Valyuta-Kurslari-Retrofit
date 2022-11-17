package uz.salimovdeveloper.valyutakurslari.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.salimovdeveloper.valyutakurslari.R
import uz.salimovdeveloper.valyutakurslari.databinding.ItemRvBinding
import uz.salimovdeveloper.valyutakurslari.models.MyValyuta

class RvAdapter(var list: List<MyValyuta>) : RecyclerView.Adapter<RvAdapter.Vh>() {
    inner class Vh(val itemRvBinding: ItemRvBinding) : RecyclerView.ViewHolder(itemRvBinding.root) {
        fun onBind(myValyuta: MyValyuta) {
            itemRvBinding.itemName.text = myValyuta.CcyNm_UZ
            itemRvBinding.itemDate.text = myValyuta.Date
            itemRvBinding.itemNumber.text = myValyuta.Rate + " So'm"

            itemRvBinding.itemDifOff.text = myValyuta.Diff
            itemRvBinding.itemDifOnn.text = myValyuta.Diff

//            if (itemRvBinding.itemDifOff.text.toString().toFloat() < 0){
//                itemRvBinding.itemDifOff.visibility = View.VISIBLE
//                itemRvBinding.itemDifOff.text = myValyuta.Diff
//            }else {
//                itemRvBinding.itemDifOnn.visibility = View.VISIBLE
//                itemRvBinding.itemDifOnn.text = myValyuta.Diff
//            }
//
//            itemRvBinding.itemDiffOn.visibility = View.VISIBLE
//            itemRvBinding.itemDiffOn.text = myValyuta.Diff

//            if (myValyuta.Diff!!.toFloat() < 0.0) {
//                itemRvBinding.itemDiffOff.visibility = View.VISIBLE
//                itemRvBinding.itemDiffOff.text = myValyuta.Diff
//            }else {
//                itemRvBinding.itemDiffOn.visibility = View.VISIBLE
//                itemRvBinding.itemDiffOn.text = myValyuta.Diff
//            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemRvBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size


}