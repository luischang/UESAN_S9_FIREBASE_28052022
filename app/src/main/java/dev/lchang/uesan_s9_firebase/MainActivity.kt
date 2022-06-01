package dev.lchang.uesan_s9_firebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.google.firebase.firestore.DocumentChange
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Add TextView tvCurso
        val tvCurso: TextView = findViewById(R.id.tvCurso)
        val tvNota: TextView = findViewById(R.id.tvNota)
        val db = FirebaseFirestore.getInstance()

            db.collection("courses")
                .addSnapshotListener{ snapshots,e->
                    if(e!=null){
                        Log.w("Firebase Warning","Error",e)
                    }

                    for(dc in snapshots!!.documentChanges){
                        when(dc.type){
                            DocumentChange.Type.ADDED ->{
                                tvCurso.text = dc.document.data["description"].toString()
                                tvNota.text = dc.document.data["score"].toString()
                            }
                            DocumentChange.Type.MODIFIED ->{
                                tvCurso.text = dc.document.data["description"].toString()
                                tvNota.text = dc.document.data["score"].toString()
                            }
                            DocumentChange.Type.REMOVED ->{
                                tvCurso.text = "Curso Eliminado"
                                tvNota.text = "Nota Eliminada"
                            }


                        }
                    }
                }
    }
}