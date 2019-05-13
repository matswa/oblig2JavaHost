package com.matswa;

public class Main {

    public static void main(String[] args) {
        Programkontroll programflyt = new Programkontroll(); //Lager objektet programflyt fra klassen programkontroll
        programflyt.lese();

        Grensesnitt nyttGrenseSnitt = new Grensesnitt();
        nyttGrenseSnitt.hovedMeny(programflyt); //Sender over samme objektet jeg laget isted til klassen grensesnitt, slik at ikke flere instanser av objektet kjører.

        programflyt.lagre();

    }
}
