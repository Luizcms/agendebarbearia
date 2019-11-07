package com.example.agendebarbearia

import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.ImageView
import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.storage.FileDownloadTask
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import java.io.File
import java.io.IOException


class Main2Activity : AppCompatActivity() {

     internal lateinit var reserva: Button;
    internal lateinit var endereco:Button;
    internal lateinit var contato:Button;
    internal lateinit var storageRef: StorageReference
    internal lateinit var storage: FirebaseStorage

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


        reserva = findViewById(R.id.reservar) as Button;
        endereco = findViewById(R.id.textView8) as Button;
        contato = findViewById(R.id.contato) as Button;
        var faceb = findViewById(R.id.faceb) as Button;
        var insta = findViewById(R.id.instagram) as Button;

        //conexao imagens do firebase para galeria
        
        storage = FirebaseStorage.getInstance()
        var logo2 = storage.getReferenceFromUrl("gs://hrbarbearia-26ab4.appspot.com/logo.jpg")
        try {
            val localFile = File.createTempFile("images", "jpg")
            logo2.getFile(localFile)
                .addOnSuccessListener(OnSuccessListener<FileDownloadTask.TaskSnapshot> {
                    val bitmap = BitmapFactory.decodeFile(localFile.getAbsolutePath())

                    var img = findViewById<ImageView>(R.id.logo2)
                    img.setImageBitmap(bitmap)

                }).addOnFailureListener(OnFailureListener { })
        } catch (e: IOException) {
        }
        var amb1 = storage.getReferenceFromUrl("gs://hrbarbearia-26ab4.appspot.com/ambiente1.jpg")
        try {
            val localFile = File.createTempFile("images", "jpg")
            amb1.getFile(localFile)
                .addOnSuccessListener(OnSuccessListener<FileDownloadTask.TaskSnapshot> {
                    val bitmap = BitmapFactory.decodeFile(localFile.getAbsolutePath())

                    var img = findViewById<ImageView>(R.id.ambiente1)
                    img.setImageBitmap(bitmap)

                }).addOnFailureListener(OnFailureListener { })
        } catch (e: IOException) {
        }
        var amb2 = storage.getReferenceFromUrl("gs://hrbarbearia-26ab4.appspot.com/ambiente2.jpg")
        try {
            val localFile = File.createTempFile("images", "jpg")
            amb2.getFile(localFile)
                .addOnSuccessListener(OnSuccessListener<FileDownloadTask.TaskSnapshot> {
                    val bitmap = BitmapFactory.decodeFile(localFile.getAbsolutePath())
                    var img = findViewById<ImageView>(R.id.ambiente2)
                    img.setImageBitmap(bitmap)
                }).addOnFailureListener(OnFailureListener { })
        } catch (e: IOException) {
        }

        var amb3 = storage.getReferenceFromUrl("gs://hrbarbearia-26ab4.appspot.com/ambiente3.jpg")
        try {
            val localFile = File.createTempFile("images", "jpg")
            amb3.getFile(localFile)
                .addOnSuccessListener(OnSuccessListener<FileDownloadTask.TaskSnapshot> {
                    val bitmap = BitmapFactory.decodeFile(localFile.getAbsolutePath())

                    var img = findViewById<ImageView>(R.id.ambiente3)
                    img.setImageBitmap(bitmap)

                }).addOnFailureListener(OnFailureListener { })
        } catch (e: IOException) {
        }

        var st1 = storage.getReferenceFromUrl("gs://hrbarbearia-26ab4.appspot.com/imagen1.jpg")
        try {
            val localFile = File.createTempFile("images", "jpg")
            st1.getFile(localFile)
                .addOnSuccessListener(OnSuccessListener<FileDownloadTask.TaskSnapshot> {
                    val bitmap = BitmapFactory.decodeFile(localFile.getAbsolutePath())

                    var img = findViewById<ImageView>(R.id.galeria1)
                    img.setImageBitmap(bitmap)

                }).addOnFailureListener(OnFailureListener { })
        } catch (e: IOException) {
        }
        var st2 = storage.getReferenceFromUrl("gs://hrbarbearia-26ab4.appspot.com/imagen2.jpg")
        try {
            val localFile = File.createTempFile("images", "jpg")
            st2.getFile(localFile)
                .addOnSuccessListener(OnSuccessListener<FileDownloadTask.TaskSnapshot> {
                    val bitmap = BitmapFactory.decodeFile(localFile.getAbsolutePath())
                    var img = findViewById<ImageView>(R.id.galeria2)
                    img.setImageBitmap(bitmap)
                }).addOnFailureListener(OnFailureListener { })
        } catch (e: IOException) {
        }

        var st3 = storage.getReferenceFromUrl("gs://hrbarbearia-26ab4.appspot.com/imagen3.jpg")
        try {
            val localFile = File.createTempFile("images", "jpg")
            st3.getFile(localFile)
                .addOnSuccessListener(OnSuccessListener<FileDownloadTask.TaskSnapshot> {
                    val bitmap = BitmapFactory.decodeFile(localFile.getAbsolutePath())

                    var img = findViewById<ImageView>(R.id.galeria3)
                    img.setImageBitmap(bitmap)

                }).addOnFailureListener(OnFailureListener { })
        } catch (e: IOException) {
        }

        var st4 = storage.getReferenceFromUrl("gs://hrbarbearia-26ab4.appspot.com/imagen4.jpg")
        try {
            val localFile = File.createTempFile("images", "jpg")
            st4.getFile(localFile)
                .addOnSuccessListener(OnSuccessListener<FileDownloadTask.TaskSnapshot> {
                    val bitmap = BitmapFactory.decodeFile(localFile.getAbsolutePath())

                    var img = findViewById<ImageView>(R.id.galeria4)
                    img.setImageBitmap(bitmap)

                }).addOnFailureListener(OnFailureListener { })
        } catch (e: IOException) {
        }
        var st5 = storage.getReferenceFromUrl("gs://hrbarbearia-26ab4.appspot.com/imagen5.jpg")
        try {
            val localFile = File.createTempFile("images", "jpg")
            st5.getFile(localFile)
                .addOnSuccessListener(OnSuccessListener<FileDownloadTask.TaskSnapshot> {
                    val bitmap = BitmapFactory.decodeFile(localFile.getAbsolutePath())

                    var img = findViewById<ImageView>(R.id.galeria5)
                    img.setImageBitmap(bitmap)

                }).addOnFailureListener(OnFailureListener { })
        } catch (e: IOException) {
        }
        var st6 = storage.getReferenceFromUrl("gs://hrbarbearia-26ab4.appspot.com/imagen6.jpg")
        try {
            val localFile = File.createTempFile("images", "jpg")
            st6.getFile(localFile)
                .addOnSuccessListener(OnSuccessListener<FileDownloadTask.TaskSnapshot> {
                    val bitmap = BitmapFactory.decodeFile(localFile.getAbsolutePath())
                    var img = findViewById<ImageView>(R.id.galeria6)
                    img.setImageBitmap(bitmap)
                }).addOnFailureListener(OnFailureListener { })
        } catch (e: IOException) {
        }

        var st7 = storage.getReferenceFromUrl("gs://hrbarbearia-26ab4.appspot.com/imagen7.jpg")
        try {
            val localFile = File.createTempFile("images", "jpg")
            st7.getFile(localFile)
                .addOnSuccessListener(OnSuccessListener<FileDownloadTask.TaskSnapshot> {
                    val bitmap = BitmapFactory.decodeFile(localFile.getAbsolutePath())

                    var img = findViewById<ImageView>(R.id.galeria7)
                    img.setImageBitmap(bitmap)

                }).addOnFailureListener(OnFailureListener { })
        } catch (e: IOException) {
        }

        var st8 = storage.getReferenceFromUrl("gs://hrbarbearia-26ab4.appspot.com/imagen8.jpg")
        try {
            val localFile = File.createTempFile("images", "jpg")
            st8.getFile(localFile)
                .addOnSuccessListener(OnSuccessListener<FileDownloadTask.TaskSnapshot> {
                    val bitmap = BitmapFactory.decodeFile(localFile.getAbsolutePath())

                    var img = findViewById<ImageView>(R.id.galeria8)
                    img.setImageBitmap(bitmap)

                }).addOnFailureListener(OnFailureListener { })
        } catch (e: IOException) {
        }
        var st9 = storage.getReferenceFromUrl("gs://hrbarbearia-26ab4.appspot.com/imagen9.jpg")
        try {
            val localFile = File.createTempFile("images", "jpg")
            st9.getFile(localFile)
                .addOnSuccessListener(OnSuccessListener<FileDownloadTask.TaskSnapshot> {
                    val bitmap = BitmapFactory.decodeFile(localFile.getAbsolutePath())

                    var img = findViewById<ImageView>(R.id.galeria9)
                    img.setImageBitmap(bitmap)

                }).addOnFailureListener(OnFailureListener { })
        } catch (e: IOException) {
        }
        var st10 = storage.getReferenceFromUrl("gs://hrbarbearia-26ab4.appspot.com/imagen10.jpg")
        try {
            val localFile = File.createTempFile("images", "jpg")
            st10.getFile(localFile)
                .addOnSuccessListener(OnSuccessListener<FileDownloadTask.TaskSnapshot> {
                    val bitmap = BitmapFactory.decodeFile(localFile.getAbsolutePath())

                    var img = findViewById<ImageView>(R.id.galeria10)
                    img.setImageBitmap(bitmap)

                }).addOnFailureListener(OnFailureListener { })
        } catch (e: IOException) {
        }



        //Picasso.with(this).load("gs://hrbarbearia-26ab4.appspot.com/fotos/barber1.jpg").into(imageView6)




       reserva.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@Main2Activity, Main6Activity::class.java)

            startActivity(intent)
        })
        faceb.setOnClickListener(View.OnClickListener {
            val uri = "http://www.facebook.com"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(uri))
            startActivity(intent)
        })
        insta.setOnClickListener(View.OnClickListener {
            val uri = "http://instagram.com"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(uri))
            startActivity(intent)
        })
        endereco.setOnClickListener(View.OnClickListener {
            val uri = "http://maps.google.com/maps?saddr=" + "&daddr=Jose Acacio moreira 1663,Tubarao, SC"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(uri))
            startActivity(intent)
        })
        contato.setOnClickListener(View.OnClickListener {
            val telefone = "48991569856"
            val uri = Uri.parse("tel:$telefone")
            val intent = Intent(Intent.ACTION_DIAL, uri)

            startActivity(intent)
        })

    }
}
