package com.matswa;

import java.util.ArrayList;

public abstract class Dyr {
    private String type;
    public int id;
    private String kjønn;
    private String dato;
    private String sted;
    private double lengde;
    private double vekt;

    ArrayList<Gjenfangst> gjenfangst = new ArrayList<>();

    public Dyr(String type, int id, String kjønn, String dato, String sted, double lengde, double vekt){
        this.type = type;
        this.id = id;
        this.kjønn = kjønn;
        this.dato = dato;
        this.sted = sted;
        this.lengde = lengde;
        this.vekt = vekt;
    }

    public String toFile(){
        return (type + "," + id + "," + kjønn + "," + dato + "," + sted + "," + lengde + "," + vekt);
    }

    public String toString(){
        return (type + id + ", " + "Kjønn: " + kjønn + ", " + "Fanget: " + dato + ", " + "Sted: " + sted + ", " + lengde + " cm" + ", " + vekt + " kg");
    }

    public String getType(){
        return type;
    }

    public int getId(){
        return id;
    }

    public void regHareGjenfangst(String dato, String sted, double lengde, double vekt, String pels){
        gjenfangst.add(new GjenfangstHare(dato, sted, lengde, vekt, pels));
    }
    public void regGaupeGjenfangst(String dato, String sted, double lengde, double vekt, double øreHårLengde){
        gjenfangst.add(new GjenfangstGaupe(dato, sted, lengde, vekt, øreHårLengde));
    }
}

