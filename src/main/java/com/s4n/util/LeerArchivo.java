package com.s4n.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LeerArchivo {

    private List<String> rutas = new ArrayList<String>();


    public List<String> getRutas(String nombreArchivo) throws IOException {
        if(!rutas.isEmpty()){
            limpiarRutas();
        }

        String cadena;
        ClassLoader loader = this.getClass().getClassLoader();

        File file = new File(loader.getResource(nombreArchivo).getFile());

        FileReader f = new FileReader(file);
        BufferedReader buffer = new BufferedReader(f);

        while((cadena = buffer.readLine()) != null){
            rutas.add(cadena);
        }

        buffer.close();

        return  rutas;

    }

    private void limpiarRutas(){
        this.rutas = new ArrayList<>();
    }
}
