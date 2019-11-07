package com.example.agendebarbearia

import android.graphics.Color.GREEN
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.painel_admin.*
import java.util.*


class Painel_Admin : AppCompatActivity() {

    internal lateinit var objetoRef: FirebaseDatabase;
    internal lateinit var ref: DatabaseReference;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.painel_admin)

        var i = findViewById<EditText>(R.id.txtInicio)

        objetoRef = FirebaseConfig.getDatabase()

        val array = ArrayList<String>()
        val ar = array.asReversed()


        val adapter = object :
            ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, array) {
            override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
                val view = super.getView(position, convertView, parent)
                // Como o simple_list_item_1 retorna um TextView, esse cast pode ser feito sem problemas
                (view as TextView).setTextColor(GREEN)
                view.setBackgroundResource(R.drawable.borda)

                return view
            }
        }

        list_p.setAdapter(adapter)

        ref = objetoRef.getReference("Pessoa")
        ref.orderByChild("dia").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (s in dataSnapshot.children) {

                    var tel = s.child("telef").value!!.toString()
                    var nome = s.child("nome").value!!.toString()
                    var serv = s.child("servico").value!!.toString()
                    var dia = s.child("dia").value!!.toString()
                    var hora = s.child("hora").value!!.toString()
                    var msg = s.child("msg").value!!.toString()
                ar.add("Nome: "+nome+"\nTel: "+tel+"\nServico: "+serv+"\nData: "+dia+"\nHora: "+hora+"\nMsg: "+msg+"\n")

                }
            }
            override fun onCancelled(databaseError: DatabaseError) {
            }
        })
        var ref1 = objetoRef.getReferenceFromUrl("https://hrbarbearia-26ab4.firebaseio.com/inicio")

        button.setOnClickListener {
            val alertDialog = AlertDialog.Builder(this)
            alertDialog.setTitle("Texto da tela inicial.")
            alertDialog.setMessage("Deseja mudar a mensagem inicial?")
            alertDialog.setPositiveButton(
                "SIM"
            ) { dialog, which ->
                var a = i.getText().toString()

                ref1.setValue(a)

                Toast.makeText(applicationContext, "Alterado", Toast.LENGTH_SHORT).show()

            }.setNegativeButton(
                "NAO"
            ) { dialog, which ->
                Toast.makeText(applicationContext, "Ok", Toast.LENGTH_SHORT).show()
                dialog.cancel()
            }
            alertDialog.show()
        }
    }
}
