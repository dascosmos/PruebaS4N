package com.s4n;

import com.s4n.logica.Corrientazo;
import com.s4n.util.Constantes;
import org.apache.log4j.Logger;


public class Main {

    private static final Logger logger = Logger.getLogger(Main.class);
    public static void main(String args[]){
        Corrientazo corrientazo = new Corrientazo();
        try{
            for(int i = 1; i <= Constantes.CATNIDAD_DRONES; i++){
                corrientazo.crearDron(i);
                corrientazo.run();
            }
        }catch(Exception e){
            logger.info(e);
        }
    }

}
