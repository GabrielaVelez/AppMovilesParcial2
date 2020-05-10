package com.example.parcial2;

public class Registro {
    private String cedula;
    private String nombre;
    private int estrato;
    private String salario;
    private int NEducativo;

    public Registro(String cedula, String nombre, int estrato, String salario, int NEducativo) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.estrato = estrato;
        this.salario = salario;
        this.NEducativo = NEducativo;
    }

    public Registro(String nombre, int estrato, String salario, int NEducativo) {
        this.nombre = nombre;
        this.estrato = estrato;
        this.salario = salario;
        this.NEducativo = NEducativo;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEstrato() {
        return estrato;
    }

    public void setEstrato(int estrato) {
        this.estrato = estrato;
    }

    public String getSalario() {
        return salario;
    }

    public void setSalario(String salario) {
        this.salario = salario;
    }

    public int getNEducativo() {
        return NEducativo;
    }

    public void setNEducativo(int NEducativo) {
        this.NEducativo = NEducativo;
    }
}
