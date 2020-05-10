package com.example.parcial2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ListAdap extends ArrayAdapter<Registro> {
    private ArrayList<Registro> lista;
    private Context cont;
    private int layoutT;

    public ListAdap(@NonNull Context context, int resource, @NonNull ArrayList<Registro> objects) {
        super(context, resource, objects);
        this.lista = objects;
        this.cont = context;
        this.layoutT = resource;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view=convertView;
        if (view == null){
            view= LayoutInflater.from(cont).inflate(layoutT, null);
        }

        Registro registro = lista.get(position);
        TextView txtcedula = view.findViewById(R.id.cedula);
        TextView txtnombre = view.findViewById(R.id.nombre);
        TextView txtestrato = view.findViewById(R.id.estrato);
        TextView txtsalario = view.findViewById(R.id.salario);
        TextView txtNeducativo = view.findViewById(R.id.Neducativo);



        txtcedula.setText(registro.getCedula());
        txtnombre.setText(registro.getNombre());
        txtestrato.setText(String.valueOf(registro.getEstrato()+1));
        txtsalario.setText(registro.getSalario());

        switch (registro.getNEducativo()){
            case 0:
                txtNeducativo.setText("Bachillerato");
                break;
            case 1:
                txtNeducativo.setText("Pregrado");
                break;
            case 2:
                txtNeducativo.setText("Maestría");
                break;
            case 3:
                txtNeducativo.setText("Doctorado");
                break;

        }

        return view;

    }
}
