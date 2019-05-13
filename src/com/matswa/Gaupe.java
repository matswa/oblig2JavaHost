package com.matswa;

public class Gaupe extends Dyr {
    public double øreHårLengde;

    public Gaupe(String type, int id, String kjønn, String dato, String sted, double lengde, double vekt, double øreHårLengde){
        super(type, id, kjønn, dato, sted, lengde, vekt);
        this. øreHårLengde = øreHårLengde;
    }

    public String toFile(){
        return (super.toFile() + "," + øreHårLengde);
    }

    public String toString(){
        return ("Gaupe nr: " + super.toString() + ", " + øreHårLengde + " cm");
    }
}
