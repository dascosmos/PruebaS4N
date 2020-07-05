package com.s4n.enums;

public enum Coordenadas {

    N("N", "Norte"),
    S("S", "Sur"),
    E("E", "Este"),
    O("O", "Oeste");

    private String codigo;
    private String nombre;


    Coordenadas(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }
}
