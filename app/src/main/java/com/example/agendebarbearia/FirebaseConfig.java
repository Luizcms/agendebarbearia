package com.example.agendebarbearia;

import android.support.v7.app.AppCompatActivity;
import com.google.firebase.database.FirebaseDatabase;

public class FirebaseConfig extends AppCompatActivity {

    private static FirebaseDatabase mDatabase;

    public static FirebaseDatabase getDatabase() {
        if (mDatabase == null) {
            mDatabase = FirebaseDatabase.getInstance();
            mDatabase.setPersistenceEnabled(true);
        }
        return mDatabase;
    }
}
