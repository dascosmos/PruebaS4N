package com.s4n.modelo;

import com.s4n.interfaces.IDron;

public class FabricaDron {


    public IDron crearDron(int id){
        return new Dron(id);
    }
}
