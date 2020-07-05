package com.s4n.logica;

import com.s4n.excepciones.FueraDeLimiteException;
import com.s4n.interfaces.IDron;
import com.s4n.modelo.FabricaDron;
import com.s4n.util.Constantes;
import com.s4n.util.Constantes.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ControlDron{

    private IDron dron;

    private FabricaDron fabricaDron = new FabricaDron();

    private List<String> listaReporte = new ArrayList<String>();


    public void CrearDron(int id){
        this.dron = fabricaDron.crearDron(id);
    }

    public void moverDron(List<String> movimientos) throws FueraDeLimiteException {

        for(String movimiento: movimientos) {
            for (int i = 0; i < movimiento.length(); i++) {
                if ('A' == movimiento.charAt(i))
                    dron.moverAdelante();
                else if ('I' == movimiento.charAt(i)) {
                    dron.cambiarDireccionIzquierda();
                } else {
                    dron.cambiarDireccionDerecha();
                }
            }
            if(!validarPosicion()){
                throw new FueraDeLimiteException();
            }
            listaReporte.add(this.dron.reportar());
        }

    }

    public List<String> traerReporte(){
        List<String> resultado = this.listaReporte;
        this.listaReporte = new ArrayList<String>();
        return resultado;
    }

    public IDron traerDron(){
        return this.dron;
    }


    private boolean validarPosicion(){
        return this.dron.reportarPosicion().getX()< Constantes.LIMITE_CUADRAS
                && this.dron.reportarPosicion().getX() > - Constantes.LIMITE_CUADRAS
                && this.dron.reportarPosicion().getY() < Constantes.LIMITE_CUADRAS
                && this.dron.reportarPosicion().getY() > - Constantes.LIMITE_CUADRAS;
    }

}
