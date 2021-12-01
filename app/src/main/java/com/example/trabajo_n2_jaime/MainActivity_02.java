package com.example.trabajo_n2_jaime;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MainActivity_02 extends AppCompatActivity {

    private List<Lugar> ListLugar =new ArrayList<Lugar>();
    ArrayAdapter<Lugar> arrayAdapterLugar;

    EditText eTNombre,eTDireccion;
    Button bTAgregar;
    ListView LvListadoLugar;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_02);

        eTNombre=findViewById(R.id.eTNombre);
        eTDireccion=findViewById(R.id.eTDireccion);
        bTAgregar=findViewById(R.id.bTAgregar);
        LvListadoLugar=findViewById(R.id.LvListadoLugar);

        inicializarFireBase();
        listarDatos();
        bTAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Lugar lugar = new Lugar();
                lugar.setIDAutor(UUID.randomUUID().toString());
                lugar.setDireccionLugar(eTDireccion.getText().toString());
                lugar.setNombreLugar(eTNombre.getText().toString());
                databaseReference.child("Latam").child(lugar.getIDAutor()).setValue(lugar);
            }
        });

    }

    private void listarDatos() {

    }

    private void inicializarFireBase() {
        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }
}