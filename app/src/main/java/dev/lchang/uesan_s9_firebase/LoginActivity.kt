package dev.lchang.uesan_s9_firebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val txtCorreo: EditText = findViewById(R.id.txtEmail)
        val txtClave: EditText = findViewById(R.id.txtPassword)
        val btnLogin: Button = findViewById(R.id.btnLogin)
        val db= FirebaseAuth.getInstance()

        btnLogin.setOnClickListener {
            val correo: String = txtCorreo.text.toString()
            val clave: String = txtClave.text.toString()

            db.signInWithEmailAndPassword(correo, clave)
                .addOnCompleteListener(this){task ->
                    if(task.isSuccessful){
                        Toast.makeText(this,"Ingreso exitoso",Toast.LENGTH_LONG).show()
                        startActivity(Intent(this,MainActivity::class.java))
                    }else{
                        Toast.makeText(this,"Correo y/o Clave inválida",Toast.LENGTH_LONG).show()
                    }
                }
        }


    }
}