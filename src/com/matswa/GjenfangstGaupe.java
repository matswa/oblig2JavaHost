package com.matswa;

public class GjenfangstGaupe extends Gjenfangst {
    public double øreHårLengde;


    public GjenfangstGaupe(String dato, String sted, double lengde, double vekt, double øreHårLengde){
        super(dato, sted, lengde, vekt);
        this.øreHårLengde = øreHårLengde;
    }

    public String toString(){
        return ("Gjenfangst data: " + dato + "," + sted + ", " + lengde + ", " + vekt + ", " + øreHårLengde + "\n");
    }
}
