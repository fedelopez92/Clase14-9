package com.example.alumno.clase14_9;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {
//OnQueryTextListener es una interfaz que se utiliza para el SearchView

    private static final int PERMISO_REQUERIDO = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Solicito permiso para que realize la llamada
        if (ContextCompat.checkSelfPermission(this,Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CALL_PHONE)) {


            } else {

                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, PERMISO_REQUERIDO);
            }
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) { //en en este metodo se crea el menu
        getMenuInflater().inflate(R.menu.menu, menu);

        MenuItem searchItem = menu.findItem(R.id.opBuscar);//trae el item del SearchView
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);//trae la referencia del SearchView
        searchView.setOnQueryTextListener(this);
        //seteamos el listener que en este caso va a ser el MainActivity (porque la interfaz la implementamos en el MainActivity)

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) { //en este metodo se pone lo que debe hacer cada opcion
        switch (item.getItemId()) {
            case R.id.op1:
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:44444444"));//llama al 44444444
                startActivity(intent);
                break;

            case R.id.op4:
                Intent intent2 = new Intent(this,NuevaActivity.class);
                intent2.putExtra("clave1","valor String");//le paso valor a la otra activity
                intent2.putExtra("clave2",53);
                startActivity(intent2);
                break;

            case android.R.id.home: //hace referencia al boton de back
                finish();//sale de la aplicacion
                break;

            default:
                Log.d("Click", "Se hizo click en otra opcion");
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onQueryTextSubmit(String texto) { //se utiliza cuando se presiona enter en el SearchView
        Log.d("activity", "se buscó:" + texto);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String texto) { //se utiliza al escribir en el SearchView
        Log.d("activity", "cambio texto:" + texto);
        return false;
    }
}
