package uz.salimovdeveloper.valyutakurslari.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import uz.salimovdeveloper.valyutakurslari.adapters.RvAdapter
import uz.salimovdeveloper.valyutakurslari.databinding.FragmentValyutaBinding
import uz.salimovdeveloper.valyutakurslari.models.MyValyuta
import uz.salimovdeveloper.valyutakurslari.retrofit.ApiClient

class ValyutaFragment : Fragment() {
    private lateinit var binding: FragmentValyutaBinding
    private lateinit var rvAdapter: RvAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentValyutaBinding.inflate(layoutInflater)


        ApiClient.getRetrofitService().getAllTodo()
            .enqueue(object : Callback<List<MyValyuta>>{
                override fun onResponse(
                    call: Call<List<MyValyuta>>,
                    response: Response<List<MyValyuta>>
                ) {
                    if (response.isSuccessful){
                        rvAdapter = RvAdapter(response.body()!!)
                        binding.myRecyc.adapter = rvAdapter
                    }
                }

                override fun onFailure(call: Call<List<MyValyuta>>, t: Throwable) {
                    Toast.makeText(requireContext(), "Internetni tekshirin", Toast.LENGTH_SHORT)
                        .show()
                }
            })





//        list = ArrayList<MyValyuta>()

//
//        val uri = "http://cbu.uz/uzc/arkhiv-kursov-valyut/json/"
//
//        requestQueue = Volley.newRequestQueue(requireContext())
//
//        val jsonArrayRequest = JsonArrayRequest(
//            Request.Method.GET, uri, null,
//            object : Response.Listener<JSONArray> {
//                override fun onResponse(response: JSONArray?) {
//
//                    val type = object : TypeToken<List<MyValyuta>>() {}.type
//                    list = Gson().fromJson<ArrayList<MyValyuta>>(response.toString(), type)
//
//                    rvAdapter = RvAdapter(list)
//                    binding.myRecyc.adapter = rvAdapter
//
//                }
//            }, object : Response.ErrorListener {
//                override fun onErrorResponse(error: VolleyError?) {
//
//                }
//            })
//
//        requestQueue.add(jsonArrayRequest)

        return binding.root
    }

}