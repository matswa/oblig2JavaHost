package com.matswa;

public class Hare extends Dyr {
    public char individ;
    public String pels;

    public Hare (String type, int id, String kjønn, String dato, String sted, double lengde, double vekt, char individ, String pels) {
        super(type, id, kjønn, dato, sted, lengde, vekt);
        this.individ = individ;
        this.pels = pels;
    }


    public String toFile(){
        return (super.toFile() + "," + individ + "," + pels);
    }

    public String toString(){
        return ("Hare nr: " + super.toString() + ", " + individ + ", " + pels);
    }
}
