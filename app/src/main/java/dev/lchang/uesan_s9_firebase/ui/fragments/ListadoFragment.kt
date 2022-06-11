package dev.lchang.uesan_s9_firebase.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.firestore.DocumentChange
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import dev.lchang.uesan_s9_firebase.R
import dev.lchang.uesan_s9_firebase.ui.fragments.adapter.CourseAdapter
import dev.lchang.uesan_s9_firebase.ui.fragments.models.CourseModel


class ListadoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View =  inflater.inflate(R.layout.fragment_listado, container, false)
        val db = FirebaseFirestore.getInstance()

        val lstCursos: ArrayList<CourseModel> = ArrayList()
        val rvCourse : RecyclerView = view.findViewById(R.id.rvCourse)

        db.collection("courses")
            .addSnapshotListener{snapshots, e->
                //lstCursos.clear()
                if(e!=null){
                    Snackbar.make(view, "Error al cargar la información",Snackbar.LENGTH_LONG).show()
                    return@addSnapshotListener
                }

                for(dc in snapshots!!.documentChanges){
                    when (dc.type){
                        DocumentChange.Type.ADDED,
                        DocumentChange.Type.MODIFIED,
                        DocumentChange.Type.REMOVED -> {
                            lstCursos.add(
                                CourseModel(dc.document.data["description"].toString(),
                                            dc.document.data["score"].toString())
                            )
                        }
                    }
                    }
                rvCourse.adapter = CourseAdapter(lstCursos)
                rvCourse.layoutManager = LinearLayoutManager(context)

                }
        return view
    }
}