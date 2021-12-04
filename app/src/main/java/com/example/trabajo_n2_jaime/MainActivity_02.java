package com.example.trabajo_n2_jaime;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.trabajo_n2_jaime.Clases.Lugar;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

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
                Lugar lugar =new Lugar();
                //lugar.setIdAutor("123456");
                lugar.setIdAutor(UUID.randomUUID().toString());
                lugar.seteTNombre(eTNombre.getText().toString());
                lugar.seteTDireccion(eTDireccion.getText().toString());
                databaseReference.child("Lugar").child(lugar.geteTNombre()).setValue(lugar);
            }
        });

    }

    private void listarDatos() {
 databaseReference.child("Lugar").addValueEventListener(new ValueEventListener() {
     @Override
     public void onDataChange(@NonNull DataSnapshot snapshot) {
         ListLugar.clear();
         for (DataSnapshot objS : snapshot.getChildren()){
             Lugar lu = objS.getValue(Lugar.class);
             ListLugar.add(lu);
             arrayAdapterLugar = new ArrayAdapter<Lugar>(MainActivity_02.this, android.R.layout.simple_expandable_list_item_1,ListLugar);
             LvListadoLugar.setAdapter(arrayAdapterLugar);

         }
     }

     @Override
     public void onCancelled(@NonNull DatabaseError error) {

     }
 });

    }

    private void inicializarFireBase() {
        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }
}