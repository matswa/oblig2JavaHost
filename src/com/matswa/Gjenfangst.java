package com.matswa;

public abstract class Gjenfangst {
    public String dato;
    public String sted;
    public double lengde;
    public double vekt;


    public Gjenfangst(String dato, String sted, double lengde, double vekt){
        this.dato = dato;
        this.sted = sted;
        this.lengde = lengde;
        this.vekt = vekt;
    }


}
