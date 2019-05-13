package com.matswa;

public class GjenfangstHare extends Gjenfangst {
    public String pels;


    public GjenfangstHare(String dato, String sted, double lengde, double vekt, String pels){
        super(dato, sted, lengde, vekt);
        this.pels = pels;
    }

    public String toString(){
        return ("Gjenfangst data: " + dato + ", " + sted + ", " + lengde + ", " + vekt + ", " + pels + "\n");
    }
}
