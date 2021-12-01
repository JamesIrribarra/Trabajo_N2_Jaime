package com.example.trabajo_n2_jaime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button Iniciar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Iniciar = (Button)findViewById(R.id.bTIniciar);

        Iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Iniciar = new Intent(MainActivity.this,MainActivity_02.class);
                startActivity(Iniciar);
            }
        });
    }
}