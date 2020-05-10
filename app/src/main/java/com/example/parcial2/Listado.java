package com.example.parcial2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleObserver;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;


public class Listado extends AppCompatActivity implements LifecycleObserver {
    ListView lista;
    ArrayList<Registro> listat;
    ControladorBaseD control;
ListAdap adapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);

        lista = findViewById(R.id.listado);
        control = new ControladorBaseD(getApplicationContext());
        listat = control.obtener();
        ListAdap adap = new ListAdap(getApplicationContext(), R.layout.dato, listat);
        lista.setAdapter(adap);

        registerForContextMenu(lista);

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 2) {
            if (resultCode == Activity.RESULT_OK) {
                ArrayList<Registro> listaServis = control.obtener();
                ListAdap adap = new ListAdap(getApplicationContext(), R.layout.dato, listaServis);
                lista.setAdapter(adap);
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                Toast.makeText(getApplicationContext(), "modificacion cancelada", Toast.LENGTH_SHORT).show();
            }
        }
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_main, menu);
    }



    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        switch (item.getItemId()) {
            case R.id.itmod:
                modificar(menuInfo.position);
                return true;
            case R.id.iteli:
                eliminar(menuInfo.position);
                return true;
        }
        return super.onContextItemSelected(item);
    }

    private void modificar(int posicion) {
        Intent intent = new Intent(this, modificar.class);
        intent.putExtra("indice", posicion);
        startActivityForResult(intent, 2);
    }

    private void eliminar(int posicion) {
        int retorno = control.borrarRegistro(listat.get(posicion));
        if (retorno == 1) {
            Toast.makeText(getApplicationContext(), "Eliminado", Toast.LENGTH_SHORT).show();
            listat = control.obtener();
            adapter = new ListAdap(getApplicationContext(), R.layout.dato, listat);
            lista.setAdapter(adapter);
        } else {
            Toast.makeText(getApplicationContext(), "error al eliminar", Toast.LENGTH_SHORT).show();
        }
    }


}
