package com.example.parcial2;

public class ModBD {

    public static final String Nombre_db = "REGISTRO";
    public static final String Nombre_Tabla = "registro";
    public static final String col_cedula = "cedula";
    public static final String col_nombre = "nombre";
    public static final String col_estrato = "estrato";
    public static final String col_salario = "salario";
    public static final String col_neducativo = "neducativo";

    public static final String CREAR_TABLA_TOMAS = "CREATE TABLE " +
            ""+ Nombre_Tabla +" ( "+col_cedula+" TEXT, "+
            " " + col_nombre + " TEXT, "+ col_estrato + " TEXT, "
            +  col_salario +" TEXT, "+col_neducativo +" TEXT)";
}
