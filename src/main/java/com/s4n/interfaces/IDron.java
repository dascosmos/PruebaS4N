package com.s4n.interfaces;

import java.awt.geom.Point2D;

public interface IDron {

    void moverAdelante();

    void cambiarDireccionIzquierda();

    void cambiarDireccionDerecha();

    String reportar();

    Point2D reportarPosicion();

}
