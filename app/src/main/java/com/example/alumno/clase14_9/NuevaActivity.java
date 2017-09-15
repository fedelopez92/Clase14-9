package com.example.alumno.clase14_9;

import android.content.Intent;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class NuevaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nueva);

        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true); //activa el boton de back

        Intent intent = getIntent();//trae los datos del intent (No se pueden pasar objetos, solo datos primitivos)
        String valor1 = intent.getStringExtra("clave1");
        int valor2 = intent.getIntExtra("clave2", 0);//le paso 0 por si no me puede traer el int. En ese caso traera 0
        Log.d("valor", valor1);
        Log.d("valor", valor2 + "");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) { //en en este metodo se crea el menu
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) { //en este metodo se pone lo que debe hacer cada opcion
        switch (item.getItemId()){

            case android.R.id.home: //hace referencia al boton de back
                finish();//sale de la aplicacion
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
