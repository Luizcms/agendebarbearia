package com.example.agendebarbearia

import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FileDownloadTask
import com.google.firebase.storage.FirebaseStorage
import java.io.File
import java.io.IOException
import java.util.*

class MainActivity : AppCompatActivity() {

    internal lateinit var entrar: Button;
    internal lateinit var meuTexto: TextView;
    internal lateinit var objetoRef: FirebaseDatabase;
    internal lateinit var ref: DatabaseReference;
    internal lateinit var storage: FirebaseStorage


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var agto = findViewById(R.id.agto) as Button;
        entrar = findViewById(R.id.entrar) as Button;
        meuTexto = findViewById(R.id.txt) as TextView;
        var admin = findViewById(R.id.admin) as Button;
        var s1 = findViewById<EditText>(R.id.senha1) as EditText
        var s2 = findViewById<EditText>(R.id.senha2) as EditText




        admin.setOnClickListener {
            s1.visibility = View.VISIBLE
            s2.visibility = View.VISIBLE
            if (s1.getText().toString().equals("adminBarber")&& s2.getText().toString().equals("12345b")) {

                val intent = Intent(this@MainActivity, Painel_Admin::class.java)
                startActivity(intent)
            }
        }


        agto.setOnClickListener {
            val intent = Intent(this@MainActivity, lista::class.java)

            startActivity(intent)
        }

        entrar.setOnClickListener {
            val intent = Intent(this@MainActivity, Main2Activity::class.java)

            startActivity(intent)
        }


        objetoRef = FirebaseConfig.getDatabase()

        ref = objetoRef.getReferenceFromUrl("https://hrbarbearia-26ab4.firebaseio.com/inicio")
        ref.addValueEventListener(object : com.google.firebase.database.ValueEventListener {
            override fun onDataChange(dataSnapshot: com.google.firebase.database.DataSnapshot) {
                var mensagem = dataSnapshot.getValue(String::class.java)
                meuTexto.setText(mensagem)
            }

            override fun onCancelled(databaseError: DatabaseError) {

            }
        })
        storage = FirebaseStorage.getInstance()
        var capa = storage.getReferenceFromUrl("gs://hrbarbearia-26ab4.appspot.com/capa.jpg")
        try {
            val localFile = File.createTempFile("images", "jpg")
            capa.getFile(localFile)
                .addOnSuccessListener(OnSuccessListener<FileDownloadTask.TaskSnapshot> {
                    val bitmap = BitmapFactory.decodeFile(localFile.getAbsolutePath())

                    var img = findViewById<ImageView>(R.id.img)
                    img.setImageBitmap(bitmap)

                }).addOnFailureListener(OnFailureListener { })
        } catch (e: IOException) {
        }
        val calendar = Calendar.getInstance(TimeZone.getDefault())
        val days = calendar.get(Calendar.DAY_OF_WEEK)
        val hour = calendar.get(Calendar.HOUR_OF_DAY)


if (days == 2 && hour >= 8) {
     var r = objetoRef.getReferenceFromUrl("https://hrbarbearia-26ab4.firebaseio.com/segunda/8")
        r.addValueEventListener(object : com.google.firebase.database.ValueEventListener {
            override fun onDataChange(dataSnapshot: com.google.firebase.database.DataSnapshot) {
                var mensagem = dataSnapshot.getValue(String::class.java)
                if (mensagem.toString().contains("reservado")) {
                    r.setValue("disponivel")
                }
            }
            override fun onCancelled(databaseError: DatabaseError) {

            }
        })
}
if (days == 2 && hour >= 9) {
    var r1 = objetoRef.getReferenceFromUrl("https://hrbarbearia-26ab4.firebaseio.com/segunda/9")
    r1.addValueEventListener(object : com.google.firebase.database.ValueEventListener {
        override fun onDataChange(dataSnapshot: com.google.firebase.database.DataSnapshot) {
            val mensagem = dataSnapshot.getValue(String::class.java)
            if (mensagem.toString().contains("reservado")) {
                r1.setValue("disponivel")
            }
        }

        override fun onCancelled(databaseError: DatabaseError) {
        }
    })

}
if (days == 2 && hour >= 10 ){
 var ref1 = objetoRef.getReferenceFromUrl("https://hrbarbearia-26ab4.firebaseio.com/segunda/10")
 ref1.addValueEventListener(object : com.google.firebase.database.ValueEventListener {
 override fun onDataChange(dataSnapshot: com.google.firebase.database.DataSnapshot) {
     val mensagem = dataSnapshot.getValue(String::class.java)

    if (mensagem.toString().contains("reservado"))
     { ref1.setValue("disponivel") }
 }
 override fun onCancelled(databaseError: DatabaseError) {
 }
})
}
        var ref2 = objetoRef.getReferenceFromUrl("https://hrbarbearia-26ab4.firebaseio.com/segunda/11")
ref2.addValueEventListener(object : com.google.firebase.database.ValueEventListener {
 override fun onDataChange(dataSnapshot: com.google.firebase.database.DataSnapshot) {
     val mensagem = dataSnapshot.getValue(String::class.java)

     if ((days == 2 && hour >= 11 ) && mensagem.toString().equals("reservado",ignoreCase = true)) { ref2.setValue("disponivel") }
 }
 override fun onCancelled(databaseError: DatabaseError) {
 }
})
        var ref3 = objetoRef.getReferenceFromUrl("https://hrbarbearia-26ab4.firebaseio.com/segunda/12")
ref3.addValueEventListener(object : com.google.firebase.database.ValueEventListener {
 override fun onDataChange(dataSnapshot: com.google.firebase.database.DataSnapshot) {
     val mensagem = dataSnapshot.getValue(String::class.java)

     if ((days == 2 && hour >= 12 ) && mensagem.toString().equals("reservado",ignoreCase = true)) { ref3.setValue("disponivel") }
 }
 override fun onCancelled(databaseError: DatabaseError) {
 }
})
        var ref4 = objetoRef.getReferenceFromUrl("https://hrbarbearia-26ab4.firebaseio.com/segunda/13")
ref4.addValueEventListener(object : com.google.firebase.database.ValueEventListener {
 override fun onDataChange(dataSnapshot: com.google.firebase.database.DataSnapshot) {
     val mensagem = dataSnapshot.getValue(String::class.java)

     if ((days == 2 && hour >= 13 ) && mensagem.toString().equals("reservado",ignoreCase = true)) { ref4.setValue("disponivel") }
 }
 override fun onCancelled(databaseError: DatabaseError) {
 }
})
        var ref5 = objetoRef.getReferenceFromUrl("https://hrbarbearia-26ab4.firebaseio.com/segunda/14")
ref5.addValueEventListener(object : com.google.firebase.database.ValueEventListener {
 override fun onDataChange(dataSnapshot: com.google.firebase.database.DataSnapshot) {
     val mensagem = dataSnapshot.getValue(String::class.java)

     if ((days == 2 && hour >= 14 ) && mensagem.toString().equals("reservado",ignoreCase = true)) { ref5.setValue("disponivel") }
 }
 override fun onCancelled(databaseError: DatabaseError) {
 }
})
        var ref6 = objetoRef.getReferenceFromUrl("https://hrbarbearia-26ab4.firebaseio.com/segunda/15")
ref6.addValueEventListener(object : com.google.firebase.database.ValueEventListener {
 override fun onDataChange(dataSnapshot: com.google.firebase.database.DataSnapshot) {
     val mensagem = dataSnapshot.getValue(String::class.java)

     if ((days == 2 && hour >= 15 ) && mensagem.toString().equals("reservado",ignoreCase = true)) { ref6.setValue("disponivel") }
 }
 override fun onCancelled(databaseError: DatabaseError) {
 }
})
        var ref7 = objetoRef.getReferenceFromUrl("https://hrbarbearia-26ab4.firebaseio.com/segunda/16")
ref7.addValueEventListener(object : com.google.firebase.database.ValueEventListener {
 override fun onDataChange(dataSnapshot: com.google.firebase.database.DataSnapshot) {
     val mensagem = dataSnapshot.getValue(String::class.java)

     if ((days == 2 && hour >= 16 ) && mensagem.toString().equals("reservado",ignoreCase = true)) { ref7.setValue("disponivel") }
 }
 override fun onCancelled(databaseError: DatabaseError) {
 }
})
        var ref8 = objetoRef.getReferenceFromUrl("https://hrbarbearia-26ab4.firebaseio.com/segunda/17")
ref8.addValueEventListener(object : com.google.firebase.database.ValueEventListener {
 override fun onDataChange(dataSnapshot: com.google.firebase.database.DataSnapshot) {
     val mensagem = dataSnapshot.getValue(String::class.java)

     if ((days == 2 && hour >= 17 ) && mensagem.toString().equals("reservado",ignoreCase = true)) { ref8.setValue("disponivel") }
 }
 override fun onCancelled(databaseError: DatabaseError) {
 }
})
        var ref9 = objetoRef.getReferenceFromUrl("https://hrbarbearia-26ab4.firebaseio.com/segunda/18")
ref9.addValueEventListener(object : com.google.firebase.database.ValueEventListener {
 override fun onDataChange(dataSnapshot: com.google.firebase.database.DataSnapshot) {
     val mensagem = dataSnapshot.getValue(String::class.java)

     if ((days == 2 && hour >= 18 ) && mensagem.toString().equals("reservado",ignoreCase = true)) { ref9.setValue("disponivel") }
 }
 override fun onCancelled(databaseError: DatabaseError) {
 }
})
        var ref10 = objetoRef.getReferenceFromUrl("https://hrbarbearia-26ab4.firebaseio.com/terca/8")
ref10.addValueEventListener(object : com.google.firebase.database.ValueEventListener {
 override fun onDataChange(dataSnapshot: com.google.firebase.database.DataSnapshot) {
     val mensagem = dataSnapshot.getValue(String::class.java)

     if ((days == 3 && hour >= 8 ) && mensagem.toString().equals("reservado",ignoreCase = true)) { ref10.setValue("disponivel") }
 }
 override fun onCancelled(databaseError: DatabaseError) {
 }
})
        var ref11 = objetoRef.getReferenceFromUrl("https://hrbarbearia-26ab4.firebaseio.com/terca/9")
ref11.addValueEventListener(object : com.google.firebase.database.ValueEventListener {
 override fun onDataChange(dataSnapshot: com.google.firebase.database.DataSnapshot) {
     val mensagem = dataSnapshot.getValue(String::class.java)

     if ((days == 3 && hour >= 9 ) && mensagem.toString().equals("reservado",ignoreCase = true)) { ref11.setValue("disponivel") }
 }
 override fun onCancelled(databaseError: DatabaseError) {
 }
})
        var ref12 = objetoRef.getReferenceFromUrl("https://hrbarbearia-26ab4.firebaseio.com/terca/10")
ref12.addValueEventListener(object : com.google.firebase.database.ValueEventListener {
 override fun onDataChange(dataSnapshot: com.google.firebase.database.DataSnapshot) {
     val mensagem = dataSnapshot.getValue(String::class.java)

     if ((days == 3 && hour >= 10 ) && mensagem.toString().equals("reservado",ignoreCase = true)) { ref12.setValue("disponivel") }
 }
 override fun onCancelled(databaseError: DatabaseError) {
 }
})
        var ref13 = objetoRef.getReferenceFromUrl("https://hrbarbearia-26ab4.firebaseio.com/terca/11")
ref13.addValueEventListener(object : com.google.firebase.database.ValueEventListener {
 override fun onDataChange(dataSnapshot: com.google.firebase.database.DataSnapshot) {
     val mensagem = dataSnapshot.getValue(String::class.java)

     if ((days == 3 && hour >= 11 ) && mensagem.toString().equals("reservado",ignoreCase = true)) { ref13.setValue("disponivel") }
 }
 override fun onCancelled(databaseError: DatabaseError) {
 }
})
        var ref14 = objetoRef.getReferenceFromUrl("https://hrbarbearia-26ab4.firebaseio.com/terca/12")
ref14.addValueEventListener(object : com.google.firebase.database.ValueEventListener {
 override fun onDataChange(dataSnapshot: com.google.firebase.database.DataSnapshot) {
     val mensagem = dataSnapshot.getValue(String::class.java)

     if ((days == 3 && hour >= 12 ) && mensagem.toString().equals("reservado",ignoreCase = true)) { ref14.setValue("disponivel") }
 }
 override fun onCancelled(databaseError: DatabaseError) {
 }
})
        var ref15 = objetoRef.getReferenceFromUrl("https://hrbarbearia-26ab4.firebaseio.com/terca/13")
ref15.addValueEventListener(object : com.google.firebase.database.ValueEventListener {
 override fun onDataChange(dataSnapshot: com.google.firebase.database.DataSnapshot) {
     val mensagem = dataSnapshot.getValue(String::class.java)

     if ((days == 3 && hour >= 13 ) && mensagem.toString().equals("reservado",ignoreCase = true)) { ref15.setValue("disponivel") }
 }
 override fun onCancelled(databaseError: DatabaseError) {
 }
})
        var ref16 = objetoRef.getReferenceFromUrl("https://hrbarbearia-26ab4.firebaseio.com/terca/14")
ref16.addValueEventListener(object : com.google.firebase.database.ValueEventListener {
 override fun onDataChange(dataSnapshot: com.google.firebase.database.DataSnapshot) {
     val mensagem = dataSnapshot.getValue(String::class.java)

     if ((days == 3 && hour >= 14 ) && mensagem.toString().equals("reservado",ignoreCase = true)) { ref16.setValue("disponivel") }
 }
 override fun onCancelled(databaseError: DatabaseError) {
 }
})
        var ref17 = objetoRef.getReferenceFromUrl("https://hrbarbearia-26ab4.firebaseio.com/terca/15")
ref17.addValueEventListener(object : com.google.firebase.database.ValueEventListener {
 override fun onDataChange(dataSnapshot: com.google.firebase.database.DataSnapshot) {
     val mensagem = dataSnapshot.getValue(String::class.java)

     if ((days == 3 && hour >= 15 ) && mensagem.toString().equals("reservado",ignoreCase = true)) { ref17.setValue("disponivel") }
 }
 override fun onCancelled(databaseError: DatabaseError) {
 }
})
        var ref18 = objetoRef.getReferenceFromUrl("https://hrbarbearia-26ab4.firebaseio.com/terca/16")
ref18.addValueEventListener(object : com.google.firebase.database.ValueEventListener {
 override fun onDataChange(dataSnapshot: com.google.firebase.database.DataSnapshot) {
     val mensagem = dataSnapshot.getValue(String::class.java)

     if ((days == 3 && hour >= 16 ) && mensagem.toString().equals("reservado",ignoreCase = true)) { ref18.setValue("disponivel") }
 }
 override fun onCancelled(databaseError: DatabaseError) {
 }
})
        var ref19 = objetoRef.getReferenceFromUrl("https://hrbarbearia-26ab4.firebaseio.com/terca/17")
ref19.addValueEventListener(object : com.google.firebase.database.ValueEventListener {
 override fun onDataChange(dataSnapshot: com.google.firebase.database.DataSnapshot) {
     val mensagem = dataSnapshot.getValue(String::class.java)

     if ((days == 3 && hour >= 17 ) && mensagem.toString().equals("reservado",ignoreCase = true)) { ref19.setValue("disponivel") }
 }
 override fun onCancelled(databaseError: DatabaseError) {
 }
})
        var ref20 = objetoRef.getReferenceFromUrl("https://hrbarbearia-26ab4.firebaseio.com/terca/18")
ref20.addValueEventListener(object : com.google.firebase.database.ValueEventListener {
 override fun onDataChange(dataSnapshot: com.google.firebase.database.DataSnapshot) {
     val mensagem = dataSnapshot.getValue(String::class.java)

     if ((days == 3 && hour >= 18 ) && mensagem.toString().equals("reservado",ignoreCase = true)) { ref20.setValue("disponivel") }
 }
 override fun onCancelled(databaseError: DatabaseError) {
 }
})
        var ref21 = objetoRef.getReferenceFromUrl("https://hrbarbearia-26ab4.firebaseio.com/quarta/8")
ref21.addValueEventListener(object : com.google.firebase.database.ValueEventListener {
 override fun onDataChange(dataSnapshot: com.google.firebase.database.DataSnapshot) {
     val mensagem = dataSnapshot.getValue(String::class.java)

     if (mensagem.toString().equals("reservado",ignoreCase = true) && (days == 4 && hour >= 7)) { ref21.setValue( "disponivel")
     }
 }
 override fun onCancelled(databaseError: DatabaseError) {
 }
})
        var ref22 = objetoRef.getReferenceFromUrl("https://hrbarbearia-26ab4.firebaseio.com/quarta/9")
ref22.addValueEventListener(object : com.google.firebase.database.ValueEventListener {
 override fun onDataChange(dataSnapshot: com.google.firebase.database.DataSnapshot) {
     val mensagem = dataSnapshot.getValue(String::class.java)

     if ((days == 4 && hour >= 9 ) && mensagem.toString().equals("reservado",ignoreCase = true)) { ref22.setValue("disponivel") }
 }
 override fun onCancelled(databaseError: DatabaseError) {
 }
})
        var ref23 = objetoRef.getReferenceFromUrl("https://hrbarbearia-26ab4.firebaseio.com/quarta/10")
ref23.addValueEventListener(object : com.google.firebase.database.ValueEventListener {
 override fun onDataChange(dataSnapshot: com.google.firebase.database.DataSnapshot) {
     val mensagem = dataSnapshot.getValue(String::class.java)

     if ((days == 4 && hour >= 10 ) && mensagem.toString().equals("reservado",ignoreCase = true)) { ref23.setValue("disponivel") }
 }
 override fun onCancelled(databaseError: DatabaseError) {
 }
})
        var ref24 = objetoRef.getReferenceFromUrl("https://hrbarbearia-26ab4.firebaseio.com/quarta/11")
ref24.addValueEventListener(object : com.google.firebase.database.ValueEventListener {
 override fun onDataChange(dataSnapshot: com.google.firebase.database.DataSnapshot) {
     val mensagem = dataSnapshot.getValue(String::class.java)

     if ((days == 4 && hour >= 11 ) && mensagem.toString().equals("reservado",ignoreCase = true)) { ref24.setValue("disponivel") }
 }
 override fun onCancelled(databaseError: DatabaseError) {
 }
})
        var ref25 = objetoRef.getReferenceFromUrl("https://hrbarbearia-26ab4.firebaseio.com/quarta/12")
ref25.addValueEventListener(object : com.google.firebase.database.ValueEventListener {
 override fun onDataChange(dataSnapshot: com.google.firebase.database.DataSnapshot) {
     val mensagem = dataSnapshot.getValue(String::class.java)

     if ((days == 4 && hour >= 12 ) && mensagem.toString().equals("reservado",ignoreCase = true)) { ref25.setValue("disponivel") }
 }
 override fun onCancelled(databaseError: DatabaseError) {
 }
})
        var ref26 = objetoRef.getReferenceFromUrl("https://hrbarbearia-26ab4.firebaseio.com/quarta/13")
ref26.addValueEventListener(object : com.google.firebase.database.ValueEventListener {
 override fun onDataChange(dataSnapshot: com.google.firebase.database.DataSnapshot) {
     val mensagem = dataSnapshot.getValue(String::class.java)

     if ((days == 4 && hour >= 13 ) && mensagem.toString().equals("reservado",ignoreCase = true)) { ref26.setValue("disponivel") }
 }
 override fun onCancelled(databaseError: DatabaseError) {
 }
})
        var ref27 = objetoRef.getReferenceFromUrl("https://hrbarbearia-26ab4.firebaseio.com/quarta/14")
ref27.addValueEventListener(object : com.google.firebase.database.ValueEventListener {
 override fun onDataChange(dataSnapshot: com.google.firebase.database.DataSnapshot) {
     val mensagem = dataSnapshot.getValue(String::class.java)

     if ((days == 4 && hour >= 14 ) && mensagem.toString().equals("reservado",ignoreCase = true)) { ref27.setValue("disponivel") }
 }
 override fun onCancelled(databaseError: DatabaseError) {
 }
})
        var ref28 = objetoRef.getReferenceFromUrl("https://hrbarbearia-26ab4.firebaseio.com/quarta/15")
ref28.addValueEventListener(object : com.google.firebase.database.ValueEventListener {
 override fun onDataChange(dataSnapshot: com.google.firebase.database.DataSnapshot) {
     val mensagem = dataSnapshot.getValue(String::class.java)

     if ((days == 4 && hour >= 15 ) && mensagem.toString().equals("reservado",ignoreCase = true)) { ref28.setValue("disponivel") }
 }
 override fun onCancelled(databaseError: DatabaseError) {
 }
})
        var ref29 = objetoRef.getReferenceFromUrl("https://hrbarbearia-26ab4.firebaseio.com/quarta/16")
ref29.addValueEventListener(object : com.google.firebase.database.ValueEventListener {
 override fun onDataChange(dataSnapshot: com.google.firebase.database.DataSnapshot) {
     val mensagem = dataSnapshot.getValue(String::class.java)

     if ((days == 4 && hour >= 16 ) && mensagem.toString().equals("reservado",ignoreCase = true)) { ref29.setValue("disponivel") }
 }
 override fun onCancelled(databaseError: DatabaseError) {
 }
})
        var ref30 = objetoRef.getReferenceFromUrl("https://hrbarbearia-26ab4.firebaseio.com/quarta/17")
ref30.addValueEventListener(object : com.google.firebase.database.ValueEventListener {
 override fun onDataChange(dataSnapshot: com.google.firebase.database.DataSnapshot) {
     val mensagem = dataSnapshot.getValue(String::class.java)

     if ((days == 4 && hour >= 17 ) && mensagem.toString().equals("reservado",ignoreCase = true)) { ref30.setValue("disponivel") }
 }
 override fun onCancelled(databaseError: DatabaseError) {
 }
})
        var ref31 = objetoRef.getReferenceFromUrl("https://hrbarbearia-26ab4.firebaseio.com/quarta/18")
ref31.addValueEventListener(object : com.google.firebase.database.ValueEventListener {
 override fun onDataChange(dataSnapshot: com.google.firebase.database.DataSnapshot) {
     val mensagem = dataSnapshot.getValue(String::class.java)

     if ((days == 4 && hour >= 18 ) && mensagem.toString().equals("reservado",ignoreCase = true)) { ref31.setValue("disponivel") }
 }
 override fun onCancelled(databaseError: DatabaseError) {
 }
})
        var ref32 = objetoRef.getReferenceFromUrl("https://hrbarbearia-26ab4.firebaseio.com/quinta/8")
ref32.addValueEventListener(object : com.google.firebase.database.ValueEventListener {
 override fun onDataChange(dataSnapshot: com.google.firebase.database.DataSnapshot) {
     val mensagem = dataSnapshot.getValue(String::class.java)

     if ((days == 4 && hour >=8 ) && mensagem.toString().equals("reservado",ignoreCase = true)) { ref32.setValue("disponivel") }
 }
 override fun onCancelled(databaseError: DatabaseError) {
 }
})
        var ref33 = objetoRef.getReferenceFromUrl("https://hrbarbearia-26ab4.firebaseio.com/quinta/9")
ref33.addValueEventListener(object : com.google.firebase.database.ValueEventListener {
 override fun onDataChange(dataSnapshot: com.google.firebase.database.DataSnapshot) {
     val mensagem = dataSnapshot.getValue(String::class.java)

     if ((days == 5 && hour >= 9 ) && mensagem.toString().equals("reservado",ignoreCase = true)) { ref33.setValue("disponivel") }
 }
 override fun onCancelled(databaseError: DatabaseError) {
 }
})
        var ref34 = objetoRef.getReferenceFromUrl("https://hrbarbearia-26ab4.firebaseio.com/quinta/10")
ref34.addValueEventListener(object : com.google.firebase.database.ValueEventListener {
 override fun onDataChange(dataSnapshot: com.google.firebase.database.DataSnapshot) {
     val mensagem = dataSnapshot.getValue(String::class.java)

     if ((days == 5 && hour >= 10 ) && mensagem.toString().equals("reservado",ignoreCase = true)) { ref34.setValue("disponivel") }
 }
 override fun onCancelled(databaseError: DatabaseError) {
 }
})
        var ref35 = objetoRef.getReferenceFromUrl("https://hrbarbearia-26ab4.firebaseio.com/quinta/11")
ref35.addValueEventListener(object : com.google.firebase.database.ValueEventListener {
 override fun onDataChange(dataSnapshot: com.google.firebase.database.DataSnapshot) {
     val mensagem = dataSnapshot.getValue(String::class.java)

     if ((days == 5 && hour >= 11 ) && mensagem.toString().equals("reservado",ignoreCase = true)) { ref35.setValue("disponivel") }
 }
 override fun onCancelled(databaseError: DatabaseError) {
 }
})
        var ref36 = objetoRef.getReferenceFromUrl("https://hrbarbearia-26ab4.firebaseio.com/quinta/12")
ref36.addValueEventListener(object : com.google.firebase.database.ValueEventListener {
 override fun onDataChange(dataSnapshot: com.google.firebase.database.DataSnapshot) {
     val mensagem = dataSnapshot.getValue(String::class.java)

     if ((days == 5 && hour >= 12 ) && mensagem.toString().equals("reservado",ignoreCase = true)) { ref36.setValue("disponivel") }
 }
 override fun onCancelled(databaseError: DatabaseError) {
 }
})
        var ref37 = objetoRef.getReferenceFromUrl("https://hrbarbearia-26ab4.firebaseio.com/quinta/13")
ref37.addValueEventListener(object : com.google.firebase.database.ValueEventListener {
 override fun onDataChange(dataSnapshot: com.google.firebase.database.DataSnapshot) {
     val mensagem = dataSnapshot.getValue(String::class.java)

     if ((days == 5 && hour >= 13 ) && mensagem.toString().equals("reservado",ignoreCase = true)) { ref37.setValue("disponivel") }
 }
 override fun onCancelled(databaseError: DatabaseError) {
 }
})
        var ref38 = objetoRef.getReferenceFromUrl("https://hrbarbearia-26ab4.firebaseio.com/quinta/14")
ref38.addValueEventListener(object : com.google.firebase.database.ValueEventListener {
 override fun onDataChange(dataSnapshot: com.google.firebase.database.DataSnapshot) {
     val mensagem = dataSnapshot.getValue(String::class.java)

     if ((days == 5 && hour >= 14 ) && mensagem.toString().equals("reservado",ignoreCase = true)) { ref38.setValue("disponivel") }
 }
 override fun onCancelled(databaseError: DatabaseError) {
 }
})
        var ref39 = objetoRef.getReferenceFromUrl("https://hrbarbearia-26ab4.firebaseio.com/quinta/15")
ref39.addValueEventListener(object : com.google.firebase.database.ValueEventListener {
 override fun onDataChange(dataSnapshot: com.google.firebase.database.DataSnapshot) {
     val mensagem = dataSnapshot.getValue(String::class.java)

     if ((days == 5 && hour >= 15 ) && mensagem.toString().equals("reservado",ignoreCase = true)) { ref39.setValue("disponivel") }
 }
 override fun onCancelled(databaseError: DatabaseError) {
 }
})
        var ref40 = objetoRef.getReferenceFromUrl("https://hrbarbearia-26ab4.firebaseio.com/quinta/16")
ref40.addValueEventListener(object : com.google.firebase.database.ValueEventListener {
 override fun onDataChange(dataSnapshot: com.google.firebase.database.DataSnapshot) {
     val mensagem = dataSnapshot.getValue(String::class.java)

     if ((days == 5 && hour >= 16 ) && mensagem.toString().equals("reservado",ignoreCase = true)) { ref40.setValue("disponivel") }
 }
 override fun onCancelled(databaseError: DatabaseError) {
 }
})
        var ref41 = objetoRef.getReferenceFromUrl("https://hrbarbearia-26ab4.firebaseio.com/quinta/17")
ref41.addValueEventListener(object : com.google.firebase.database.ValueEventListener {
 override fun onDataChange(dataSnapshot: com.google.firebase.database.DataSnapshot) {
     val mensagem = dataSnapshot.getValue(String::class.java)

     if ((days == 5 && hour >= 17 ) && mensagem.toString().equals("reservado",ignoreCase = true)) { ref41.setValue("disponivel") }
 }
 override fun onCancelled(databaseError: DatabaseError) {
 }
})
        var ref42 = objetoRef.getReferenceFromUrl("https://hrbarbearia-26ab4.firebaseio.com/quinta/18")
ref42.addValueEventListener(object : com.google.firebase.database.ValueEventListener {
 override fun onDataChange(dataSnapshot: com.google.firebase.database.DataSnapshot) {
     val mensagem = dataSnapshot.getValue(String::class.java)

     if ((days == 5 && hour >= 18 ) && mensagem.toString().equals("reservado",ignoreCase = true)) { ref42.setValue("disponivel") }
 }
 override fun onCancelled(databaseError: DatabaseError) {
 }
})
        var ref43 = objetoRef.getReferenceFromUrl("https://hrbarbearia-26ab4.firebaseio.com/sexta/8")
ref43.addValueEventListener(object : com.google.firebase.database.ValueEventListener {
 override fun onDataChange(dataSnapshot: com.google.firebase.database.DataSnapshot) {
     val mensagem = dataSnapshot.getValue(String::class.java)

     if ((days == 6 && hour >= 8 ) && mensagem.toString().equals("reservado",ignoreCase = true)) { ref43.setValue("disponivel") }
 }
 override fun onCancelled(databaseError: DatabaseError) {
 }
})
        var ref44 = objetoRef.getReferenceFromUrl("https://hrbarbearia-26ab4.firebaseio.com/sexta/9")
ref44.addValueEventListener(object : com.google.firebase.database.ValueEventListener {
 override fun onDataChange(dataSnapshot: com.google.firebase.database.DataSnapshot) {
     val mensagem = dataSnapshot.getValue(String::class.java)

     if ((days == 6 && hour >= 9 ) && mensagem.toString().equals("reservado",ignoreCase = true)) { ref44.setValue("disponivel") }
 }
 override fun onCancelled(databaseError: DatabaseError) {
 }
})
        var ref45 = objetoRef.getReferenceFromUrl("https://hrbarbearia-26ab4.firebaseio.com/sexta/10")
ref45.addValueEventListener(object : com.google.firebase.database.ValueEventListener {
 override fun onDataChange(dataSnapshot: com.google.firebase.database.DataSnapshot) {
     val mensagem = dataSnapshot.getValue(String::class.java)

     if ((days == 6 && hour >= 10 ) && mensagem.toString().equals("reservado",ignoreCase = true)) { ref45.setValue("disponivel") }
 }
 override fun onCancelled(databaseError: DatabaseError) {
 }
})
        var ref46 = objetoRef.getReferenceFromUrl("https://hrbarbearia-26ab4.firebaseio.com/sexta/11")
ref46.addValueEventListener(object : com.google.firebase.database.ValueEventListener {
 override fun onDataChange(dataSnapshot: com.google.firebase.database.DataSnapshot) {
     val mensagem = dataSnapshot.getValue(String::class.java)

     if ((days == 6 && hour >= 11 ) && mensagem.toString().equals("reservado",ignoreCase = true)) { ref46.setValue("disponivel") }
 }
 override fun onCancelled(databaseError: DatabaseError) {
 }
})
        var ref47 = objetoRef.getReferenceFromUrl("https://hrbarbearia-26ab4.firebaseio.com/sexta/12")
ref47.addValueEventListener(object : com.google.firebase.database.ValueEventListener {
 override fun onDataChange(dataSnapshot: com.google.firebase.database.DataSnapshot) {
     val mensagem = dataSnapshot.getValue(String::class.java)

     if ((days == 6 && hour >= 12 ) && mensagem.toString().equals("reservado",ignoreCase = true)) { ref47.setValue("disponivel") }
 }
 override fun onCancelled(databaseError: DatabaseError) {
 }
})
        var ref48 = objetoRef.getReferenceFromUrl("https://hrbarbearia-26ab4.firebaseio.com/sexta/13")
ref48.addValueEventListener(object : com.google.firebase.database.ValueEventListener {
 override fun onDataChange(dataSnapshot: com.google.firebase.database.DataSnapshot) {
     val mensagem = dataSnapshot.getValue(String::class.java)

     if ((days == 6 && hour >= 13 ) && mensagem.toString().equals("reservado",ignoreCase = true)) { ref48.setValue("disponivel") }
 }
 override fun onCancelled(databaseError: DatabaseError) {
 }
})
        var ref49 = objetoRef.getReferenceFromUrl("https://hrbarbearia-26ab4.firebaseio.com/sexta/14")
ref49.addValueEventListener(object : com.google.firebase.database.ValueEventListener {
 override fun onDataChange(dataSnapshot: com.google.firebase.database.DataSnapshot) {
     val mensagem = dataSnapshot.getValue(String::class.java)

     if ((days == 6 && hour >= 14 ) && mensagem.toString().equals("reservado",ignoreCase = true)) { ref49.setValue("disponivel") }
 }
 override fun onCancelled(databaseError: DatabaseError) {
 }
})
        var ref50 = objetoRef.getReferenceFromUrl("https://hrbarbearia-26ab4.firebaseio.com/sexta/15")
ref50.addValueEventListener(object : com.google.firebase.database.ValueEventListener {
 override fun onDataChange(dataSnapshot: com.google.firebase.database.DataSnapshot) {
     val mensagem = dataSnapshot.getValue(String::class.java)

     if ((days == 6 && hour >= 15 ) && mensagem.toString().equals("reservado",ignoreCase = true)) { ref50.setValue("disponivel") }
 }
 override fun onCancelled(databaseError: DatabaseError) {
 }
})
        var ref51 = objetoRef.getReferenceFromUrl("https://hrbarbearia-26ab4.firebaseio.com/sexta/16")
ref51.addValueEventListener(object : com.google.firebase.database.ValueEventListener {
 override fun onDataChange(dataSnapshot: com.google.firebase.database.DataSnapshot) {
     val mensagem = dataSnapshot.getValue(String::class.java)

     if ((days == 6 && hour >= 16 ) && mensagem.toString().equals("reservado",ignoreCase = true)) { ref51.setValue("disponivel") }
 }
 override fun onCancelled(databaseError: DatabaseError) {
 }
})
        var ref52 = objetoRef.getReferenceFromUrl("https://hrbarbearia-26ab4.firebaseio.com/sexta/17")
ref52.addValueEventListener(object : com.google.firebase.database.ValueEventListener {
 override fun onDataChange(dataSnapshot: com.google.firebase.database.DataSnapshot) {
     val mensagem = dataSnapshot.getValue(String::class.java)

     if ((days == 6 && hour >= 17 ) && mensagem.toString().equals("reservado",ignoreCase = true)) { ref52.setValue("disponivel") }
 }
 override fun onCancelled(databaseError: DatabaseError) {
 }
})
        var ref53 = objetoRef.getReferenceFromUrl("https://hrbarbearia-26ab4.firebaseio.com/sexta/18")
ref53.addValueEventListener(object : com.google.firebase.database.ValueEventListener {
 override fun onDataChange(dataSnapshot: com.google.firebase.database.DataSnapshot) {
     val mensagem = dataSnapshot.getValue(String::class.java)

     if ((days == 6 && hour >= 18 ) && mensagem.toString().equals("reservado",ignoreCase = true)) { ref53.setValue("disponivel") }
 }
 override fun onCancelled(databaseError: DatabaseError) {
 }
})
        var ref54 = objetoRef.getReferenceFromUrl("https://hrbarbearia-26ab4.firebaseio.com/sabado/8")
ref54.addValueEventListener(object : com.google.firebase.database.ValueEventListener {
 override fun onDataChange(dataSnapshot: com.google.firebase.database.DataSnapshot) {
     val mensagem = dataSnapshot.getValue(String::class.java)

     if ((days == 7 && hour >= 8 ) && mensagem.toString().equals("reservado",ignoreCase = true)) { ref54.setValue("disponivel") }
 }
 override fun onCancelled(databaseError: DatabaseError) {
 }
})
        var ref55 = objetoRef.getReferenceFromUrl("https://hrbarbearia-26ab4.firebaseio.com/sabado/9")
ref55.addValueEventListener(object : com.google.firebase.database.ValueEventListener {
 override fun onDataChange(dataSnapshot: com.google.firebase.database.DataSnapshot) {
     val mensagem = dataSnapshot.getValue(String::class.java)

     if ((days == 7 && hour >= 9 ) && mensagem.toString().equals("reservado",ignoreCase = true)) { ref55.setValue("disponivel") }
 }
 override fun onCancelled(databaseError: DatabaseError) {
 }
})
        var ref56 = objetoRef.getReferenceFromUrl("https://hrbarbearia-26ab4.firebaseio.com/sabado/10")
ref56.addValueEventListener(object : com.google.firebase.database.ValueEventListener {
 override fun onDataChange(dataSnapshot: com.google.firebase.database.DataSnapshot) {
     val mensagem = dataSnapshot.getValue(String::class.java)

     if ((days == 7 && hour >= 10 ) && mensagem.toString().equals("reservado",ignoreCase = true)) { ref56.setValue("disponivel") }
 }
 override fun onCancelled(databaseError: DatabaseError) {
 }
})
        var ref57 = objetoRef.getReferenceFromUrl("https://hrbarbearia-26ab4.firebaseio.com/sabado/11")
ref57.addValueEventListener(object : com.google.firebase.database.ValueEventListener {
 override fun onDataChange(dataSnapshot: com.google.firebase.database.DataSnapshot) {
     val mensagem = dataSnapshot.getValue(String::class.java)

     if ((days == 7 && hour >= 11 ) && mensagem.toString().equals("reservado",ignoreCase = true)) { ref57.setValue("disponivel") }
 }
 override fun onCancelled(databaseError: DatabaseError) {
 }
})
        var ref58 = objetoRef.getReferenceFromUrl("https://hrbarbearia-26ab4.firebaseio.com/sabado/12")
ref58.addValueEventListener(object : com.google.firebase.database.ValueEventListener {
 override fun onDataChange(dataSnapshot: com.google.firebase.database.DataSnapshot) {
     val mensagem = dataSnapshot.getValue(String::class.java)

     if ((days == 7 && hour >= 12 ) && mensagem.toString().equals("reservado",ignoreCase = true)) { ref58.setValue("disponivel") }
 }
 override fun onCancelled(databaseError: DatabaseError) {
 }
})
        var ref59 = objetoRef.getReferenceFromUrl("https://hrbarbearia-26ab4.firebaseio.com/sabado/13")
ref59.addValueEventListener(object : com.google.firebase.database.ValueEventListener {
 override fun onDataChange(dataSnapshot: com.google.firebase.database.DataSnapshot) {
     val mensagem = dataSnapshot.getValue(String::class.java)

     if ((days == 7 && hour >= 13 ) && mensagem.toString().equals("reservado",ignoreCase = true)) { ref59.setValue("disponivel") }
 }
 override fun onCancelled(databaseError: DatabaseError) {
 }
})
        var ref60 = objetoRef.getReferenceFromUrl("https://hrbarbearia-26ab4.firebaseio.com/sabado/14")
ref60.addValueEventListener(object : com.google.firebase.database.ValueEventListener {
 override fun onDataChange(dataSnapshot: com.google.firebase.database.DataSnapshot) {
     val mensagem = dataSnapshot.getValue(String::class.java)

     if ((days == 7 && hour >= 14 ) && mensagem.toString().equals("reservado",ignoreCase = true)) { ref60.setValue("disponivel") }
 }
 override fun onCancelled(databaseError: DatabaseError) {
 }
})
        var ref61 = objetoRef.getReferenceFromUrl("https://hrbarbearia-26ab4.firebaseio.com/sabado/15")
ref61.addValueEventListener(object : com.google.firebase.database.ValueEventListener {
 override fun onDataChange(dataSnapshot: com.google.firebase.database.DataSnapshot) {
     val mensagem = dataSnapshot.getValue(String::class.java)

     if ((days == 7 && hour >= 15 ) && mensagem.toString().equals("reservado",ignoreCase = true)) { ref61.setValue("disponivel") }
 }
 override fun onCancelled(databaseError: DatabaseError) {
 }
})
        var ref62 = objetoRef.getReferenceFromUrl("https://hrbarbearia-26ab4.firebaseio.com/sabado/16")
ref62.addValueEventListener(object : com.google.firebase.database.ValueEventListener {
 override fun onDataChange(dataSnapshot: com.google.firebase.database.DataSnapshot) {
     val mensagem = dataSnapshot.getValue(String::class.java)

     if ((days == 7 && hour == 16 ) && mensagem.toString().equals("reservado",ignoreCase = true)) { ref62.setValue("disponivel") }
 }
 override fun onCancelled(databaseError: DatabaseError) {
 }
})
        var ref63 = objetoRef.getReferenceFromUrl("https://hrbarbearia-26ab4.firebaseio.com/sabado/17")
ref63.addValueEventListener(object : com.google.firebase.database.ValueEventListener {
 override fun onDataChange(dataSnapshot: com.google.firebase.database.DataSnapshot) {
     val mensagem = dataSnapshot.getValue(String::class.java)

     if ((days == 7 && hour >= 17 ) && mensagem.toString().equals("reservado",ignoreCase = true)) { ref63.setValue("disponivel") }
 }
 override fun onCancelled(databaseError: DatabaseError) {
 }
})
        var ref64 = objetoRef.getReferenceFromUrl("https://hrbarbearia-26ab4.firebaseio.com/sabado/18")
ref64.addValueEventListener(object : com.google.firebase.database.ValueEventListener {
 override fun onDataChange(dataSnapshot: com.google.firebase.database.DataSnapshot) {
     val mensagem = dataSnapshot.getValue(String::class.java)

     if ((days == 7 && hour >= 18 ) && mensagem.toString().equals("reservado",ignoreCase = true)) { ref64.setValue("disponivel") }
 }
 override fun onCancelled(databaseError: DatabaseError) {
 }
})
}


}
