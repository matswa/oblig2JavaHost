package com.matswa;
import java.io.*;

public class Skrivlesfiler {

    public static PrintWriter lagSkriveForbindelse(String filnavn){
        try{
            FileWriter filForbindelse = new FileWriter(filnavn);
            BufferedWriter skriveBuffer = new BufferedWriter(filForbindelse);
            PrintWriter skriver = new PrintWriter(skriveBuffer);
            return skriver;
        } catch(IOException e){return null;}
    }

    public static BufferedReader lagLeseForbindelse(String filnavn){
        try{
            FileReader filForbindelse = new FileReader(filnavn);
            BufferedReader leser = new BufferedReader(filForbindelse);
            return leser;
        }catch(IOException e){return null;}
    }
}
