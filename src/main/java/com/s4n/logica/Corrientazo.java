package com.s4n.logica;

import com.s4n.excepciones.FueraDeLimiteException;
import com.s4n.util.Constantes;
import com.s4n.util.EscribirArchivo;
import com.s4n.util.LeerArchivo;
import com.s4n.util.Constantes.*;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.List;


public class Corrientazo implements Runnable {

    private  final Logger LOGGER = Logger.getLogger(this.getClass());

    ControlDron controlDron;

    LeerArchivo leerArchivo;

    EscribirArchivo escribirArchivo;

    int idDron;

    public Corrientazo(){
        this.controlDron = new ControlDron();
        this.escribirArchivo = new EscribirArchivo();
        this.leerArchivo = new LeerArchivo();
    }




    public void crearDron(int idDron){
        this.idDron = idDron;
        this.controlDron.CrearDron(this.idDron);
    }

    public void enviarInstrucciones() throws IOException, FueraDeLimiteException {

        String nombreArchivo = Constantes.NOMBRE_ARCHIVO_ENTRADA + this.idDron + ".txt";
        List<String> instrucciones = leerArchivo.getRutas(nombreArchivo);
        this.controlDron.moverDron(instrucciones);
    }

    public String generarReporte() throws IOException {
        String nombreArchivo = Constantes.NOMBRE_ARCHIVO_SALIDA + this.idDron+".txt";
        List<String> reporte = this.controlDron.traerReporte();
        String exito = escribirArchivo.escribirOutput(nombreArchivo, reporte);
        return exito;
    }

    @Override
    public void run() {
        try {
            this.enviarInstrucciones();
            String exito = this.generarReporte();
            LOGGER.info(exito);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (FueraDeLimiteException e) {
            e.printStackTrace();
        }

    }
}
