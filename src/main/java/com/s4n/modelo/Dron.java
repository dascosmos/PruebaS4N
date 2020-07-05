package com.s4n.modelo;

import com.s4n.enums.Coordenadas;
import com.s4n.interfaces.IDron;

import java.awt.geom.Point2D;


public class Dron implements IDron {

    private int id;

    private int posX;

    private int posY;

    private char direccion;

    Point2D posicion;



    public Dron(int id) {
        this.id = id;
        this.posX = 0;
        this.posY = 0;
        this.direccion = 'N';
        this.posicion = new Point2D.Double(0, 0);
    }


    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public char getDireccion() {
        return direccion;
    }

    public void setDireccion(char direccion) {
        this.direccion = direccion;
    }

    public void moverAdelante() {
        if (this.direccion == 'N') {
            this.posY += 1;
        } else if (this.direccion == 'O') {
            this.posX -= 1;
        } else if (this.direccion == 'E') {
            this.posX += 1;
        } else if (this.direccion == 'S') {
            this.posY -= 1;
        }else{
            this.posX = 0;
            this.posY = 0;
        }

        this.posicion.setLocation(this.posX, this.posY);
    }

    public void cambiarDireccionIzquierda() {
        if (this.direccion == 'N') {
            this.direccion = 'O';
        } else if (this.direccion == 'O') {
            this.direccion = 'S';
        } else if (this.direccion == 'E') {
            this.direccion = 'N';
        } else if (this.direccion == 'S') {
            this.direccion = 'E';
        }else{
            this.direccion = 'N';
        }
    }

    public void cambiarDireccionDerecha() {
        if (this.direccion == 'N') {
            this.direccion = 'E';
        } else if (this.direccion == 'O') {
            this.direccion = 'N';
        } else if (this.direccion == 'E') {
            this.direccion = 'S';
        } else if (this.direccion == 'S') {
            this.direccion = 'O';
        }else{
            this.direccion = 'N';
        }
    }

    public String reportar(){
        return "(" + this.posX + ", " + this.posY  + ") " +
                "direccion " + Coordenadas.valueOf(String.valueOf(this.direccion)).getNombre();
    }

    public Point2D reportarPosicion(){
        return this.posicion;
    }

}
