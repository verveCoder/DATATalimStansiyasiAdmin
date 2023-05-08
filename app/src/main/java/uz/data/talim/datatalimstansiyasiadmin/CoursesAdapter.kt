package uz.data.talim.datatalimstansiyasiadmin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class CoursesHolder(view: View): ViewHolder(view)

class CoursesAdapter(private val CoursesList: List<Courses>): Adapter<CoursesHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoursesHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.courses, parent, false)

        return CoursesHolder(view)
    }

    override fun onBindViewHolder(holder: CoursesHolder, position: Int) {
        val course: Courses = CoursesList[position]
        val name: TextView = holder.itemView.findViewById(R.id.name)
        val duration: TextView = holder.itemView.findViewById(R.id.duration)
        val price: TextView = holder.itemView.findViewById(R.id.price)

        name.text = course.name
        duration.text = course.duration
        price.text = course.price
    }

    override fun getItemCount(): Int {
        return CoursesList.size
    }
}