package uz.data.talim.datatalimstansiyasiadmin

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import uz.data.talim.datatalimstansiyasiadmin.databinding.FragmentAddBinding

class AddFragment: Fragment(R.layout.fragment_add) {
    private lateinit var binding: FragmentAddBinding

    private val firestore = Firebase.firestore

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentAddBinding.bind(view)

        binding.add.setOnClickListener {
            val newCourse = hashMapOf(
                "id" to binding.CourseID.text.toString(),
                "name" to binding.CourseName.text.toString(),
                "duration" to binding.CourseDuration.text.toString(),
                "price" to binding.CoursesPrice.text.toString()
            )

            firestore.collection("courses").document(binding.CourseID.text.toString())
                .set(newCourse)
                .addOnSuccessListener {
                    Toast.makeText(requireContext(), "New Course is Added", Toast.LENGTH_SHORT).show()
                    findNavController().navigate(R.id.from_add_to_catalog)
                }
        }
    }
}