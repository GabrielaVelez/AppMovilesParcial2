package com.example.parcial2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class ControladorBaseD {
    private BaseDatos basedatos;

    public ControladorBaseD (Context context){
        this.basedatos =  new BaseDatos(context, ModBD.Nombre_db,null,1);
    }

    public long agRegistro (Registro registro){

            SQLiteDatabase database = basedatos.getWritableDatabase();
            ContentValues val = new ContentValues();
            val.put(ModBD.col_cedula, registro.getCedula());
            val.put(ModBD.col_nombre, registro.getNombre());
            val.put(ModBD.col_estrato, registro.getEstrato());
            val.put(ModBD.col_salario,registro.getSalario());
           val.put(ModBD.col_neducativo,registro.getNEducativo());
            return database.insert(ModBD.Nombre_Tabla,null,val);

    }
    public int actRegistro(Registro registro) {
        try {
            SQLiteDatabase database = basedatos.getWritableDatabase();
            ContentValues VA = new ContentValues();
            VA.put(ModBD.col_cedula, registro.getCedula());
            VA.put(ModBD.col_nombre, registro.getNombre());
            VA.put(ModBD.col_estrato, registro.getEstrato());
            VA.put(ModBD.col_salario,registro.getSalario());
            VA.put(ModBD.col_neducativo,registro.getNEducativo());

            String CA = ModBD.col_cedula + " = ?";
            String[] AC = {String.valueOf(registro.getCedula())};

            return database.update(ModBD.Nombre_Tabla, VA, CA, AC);
        } catch (Exception e) {
            return 0;
        }
    }

    public int borrarRegistro(Registro tomas) {
        try {
            SQLiteDatabase database = basedatos.getWritableDatabase();
            String[] arg = {String.valueOf(tomas.getCedula())};
            return database.delete(ModBD.Nombre_Tabla, ModBD.col_cedula + " = ?", arg);
        } catch (Exception e) {
            return 0;
        }
    }
    public Registro bus(String id) {
        Registro reg;
        SQLiteDatabase database = basedatos.getReadableDatabase();
        String[] colBuscar = {ModBD.col_cedula,ModBD.col_nombre,ModBD.col_estrato,ModBD.col_salario,ModBD.col_neducativo};
        String[] argvector = {id};
        Cursor c = database.query(ModBD.Nombre_Tabla,colBuscar,ModBD.col_cedula+" = ?",argvector,null,null,null);
        if (c==null){
            return null;
        }
        if (!c.moveToFirst()){
            return null;
        }
        do {

             reg = new Registro(c.getString(0),c.getString(1),
                    c.getInt(2),c.getString(3),c.getInt(4));

        } while (c.moveToNext());
        c.close();
        return reg;
    }
    public ArrayList<Registro> obtener() {
        ArrayList<Registro> registros = new ArrayList<>();
    SQLiteDatabase database = basedatos.getReadableDatabase();
    String[] colBuscar = {ModBD.col_cedula,ModBD.col_nombre,ModBD.col_estrato,ModBD.col_salario,ModBD.col_neducativo};
        Cursor c = database.query(ModBD.Nombre_Tabla,colBuscar,null,null,null,null,null);
        if (c==null){
            return registros;
        }
        if (!c.moveToFirst()){
            return registros;
        }
        do {

            Registro tom = new Registro(c.getString(0),c.getString(1),
                    c.getInt(2),c.getString(3),c.getInt(4));
            registros.add(tom);
        } while (c.moveToNext());
        c.close();
        return registros;
    }
}
