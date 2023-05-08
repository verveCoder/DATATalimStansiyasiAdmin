package uz.data.talim.datatalimstansiyasiadmin

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import uz.data.talim.datatalimstansiyasiadmin.databinding.FragmentCatalogBinding

class CatalogFragment: Fragment(R.layout.fragment_catalog) {
    private lateinit var binding: FragmentCatalogBinding

    private val firestore = Firebase.firestore

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentCatalogBinding.bind(view)
        binding.corseslist.layoutManager = LinearLayoutManager(requireContext())

        firestore
            .collection("courses")
            .get()
            .addOnSuccessListener { snapshot ->

                val items: List<Courses> = snapshot.documents.map { document ->
                    Courses(
                        id = document.id,
                        name = document.getString("name") ?: "",
                        duration = document.getString("duration") ?: "",
                        price = document.getString("price") ?: "",
                    )
                }
                binding.corseslist.adapter = CoursesAdapter(items)
            }

        binding.addCourse.setOnClickListener {
            findNavController().navigate(R.id.from_catalog_to_add)
        }
    }
}