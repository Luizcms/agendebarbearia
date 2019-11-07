package com.example.agendebarbearia;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class Main5Activity extends AppCompatActivity {

    private static final String TAG = "Main5Activity";

    DatabaseHelper databaseHelper;

    TextView txt;
    Button agend,end,cont,insta,face;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        insta=(Button)findViewById(R.id.instagram);
        face=(Button)findViewById(R.id.faceb);
        end=(Button)findViewById(R.id.endereco);
        cont=(Button)findViewById(R.id.contato);
        agend=(Button)findViewById(R.id.agendar);
        txt=(TextView) findViewById(R.id.txt);
       Button sair=(Button)findViewById(R.id.sair);


        Bundle c = new Bundle();
        c = getIntent().getExtras();
        final String nome = c.getString("name");
        final String nome1 = c.getString("name1");
        final String nome2 = c.getString("name2");
        final String nome3 = c.getString("name3");


        agend.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                int ndias=Integer.parseInt(nome3);
                if(ndias>2){
                    ndias = ndias - 1;
                }

                AlarmManager alarmMgr = (AlarmManager) Main5Activity.this.getSystemService(Context.ALARM_SERVICE);
                Intent intent = new Intent(Main5Activity.this, onReceiver.class);

                Calendar calendar = Calendar.getInstance();

                PendingIntent alarmIntent = PendingIntent.getBroadcast(Main5Activity.this, 0, intent, 0);
                alarmMgr.set(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis() + ndias * 60 * 60 * 1000  , alarmIntent);
                Toast.makeText(getApplicationContext(), "Lembrete adicionado", Toast.LENGTH_LONG).show();


    }
});
        sair.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity();
            }
        });


        String dado =("Agendado para = "+ nome + " " + nome2 +"\nhorario = "+ nome1+ " horas." );
        txt.setText("Agendado para "+ nome + " " + nome2 +"\nhorario = "+ nome1+ " horas." );


        databaseHelper= new DatabaseHelper(this);


                String newEntry = dado.toString();
                if (dado.length() != 0) {
                    AddData(newEntry);

                } else {
                   // Toast.makeText(Main5Activity.this, " adicionado", LENGTH_SHORT).show();
                }

    }

    public void AddData(String newEntry) {
        boolean insertData = databaseHelper.addData(newEntry);
        if (insertData == true){
          //  Toast.makeText(Main5Activity.this, "adicionado", LENGTH_SHORT).show();
        }else{

        //Toast.makeText(Main5Activity.this, "não adicionado", LENGTH_SHORT).show();
    }
        face.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String uri = "http://www.facebook.com";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent);
            }
        });
        insta.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String uri = "http://instagram.com";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent);
            }
        });
    end.setOnClickListener(new OnClickListener() {
                               @Override
                               public void onClick(View v) {
                                   String uri = "http://maps.google.com/maps?saddr=" + "&daddr=Jose Acacio moreira 1663,Tubarao, SC";
                                   Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                                   startActivity(intent);
                               }
                           });
        cont.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                String uri = "tel:"+"48991569856";
                intent.setData(Uri.parse(uri));
                startActivity(intent);

            }
        });
    }
}

