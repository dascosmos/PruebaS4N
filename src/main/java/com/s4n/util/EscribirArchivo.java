package com.s4n.util;


import java.io.*;
import java.net.URL;
import java.util.List;

public class EscribirArchivo {

    public String escribirOutput(String nombreArchivo, List<String> reporte) throws IOException {
        ClassLoader loader = this.getClass().getClassLoader();
        File file = new File("./results/"+nombreArchivo);
        BufferedWriter bw;
        if(file.exists()){
            bw = new BufferedWriter(new FileWriter(file));
            reporte.stream().forEach(e ->{
                try {
                    bw.write(e+"\n");
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            });
        }else{
            bw = new BufferedWriter(new FileWriter(file));
            reporte.stream().forEach(e ->{
                try {
                    bw.write(e+"\n");
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            });
        }
        bw.close();
        return "reporte escrito correctamente";
    }


}
