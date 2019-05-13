package com.matswa;
import javax.swing.*;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Programkontroll {
    private ArrayList<Dyr> dyrene = new ArrayList<>();

    private final String FILNAVN = "fangstrapport.txt";


    public void regHare(String type, int id, String kjønn, String dato, String sted, double lengde, double vekt, char individ, String pels){
        dyrene.add(new Hare(type, id, kjønn, dato, sted, lengde, vekt, individ, pels));
    }

    public void regGaupe(String type, int id, String kjønn, String dato, String sted, double lengde, double vekt, double øreHårLengde){
        dyrene.add(new Gaupe(type, id, kjønn, dato, sted, lengde, vekt, øreHårLengde));
    }

    public void lagre(){
        try{
            PrintWriter utfil = Skrivlesfiler.lagSkriveForbindelse(FILNAVN);
            for(Dyr d : dyrene){
                utfil.println(d.toFile());
            }
            utfil.close();
        }catch(Exception e) {}
    }

    public void lese(){
        try{
            BufferedReader innfil = Skrivlesfiler.lagLeseForbindelse(FILNAVN);
            String linje = innfil.readLine();
            while(linje != null){
                StringTokenizer innhold = new StringTokenizer(linje, ",");
                String type = innhold.nextToken();
                if(type.equals("H")) {
                    lesHare(innhold);
                }
                else {
                    lesGaupe(innhold);
                }
                linje = innfil.readLine();
            }
            innfil.close();
        }catch(Exception e) {}
    }

    public void lesHare (StringTokenizer innhold){
        String type = "H";
        int id = Integer.parseInt(innhold.nextToken());
        String kjønn = innhold.nextToken();
        String dato = innhold.nextToken();
        String sted = innhold.nextToken();
        double lengde = Double.parseDouble(innhold.nextToken());
        double vekt = Double.parseDouble(innhold.nextToken());
        String getIndivid = innhold.nextToken();
        char individ = getIndivid.charAt(0);
        String pels = innhold.nextToken();
        dyrene.add(new Hare(type, id, kjønn, dato, sted, lengde, vekt, individ,pels));
    }

    public void lesGaupe (StringTokenizer innhold){
        String type = "G";
        int id = Integer.parseInt(innhold.nextToken());
        String kjønn = innhold.nextToken();
        String dato = innhold.nextToken();
        String sted = innhold.nextToken();
        double lengde = Double.parseDouble(innhold.nextToken());
        double vekt = Double.parseDouble(innhold.nextToken());
        double øreHår = Double.parseDouble(innhold.nextToken());
        dyrene.add(new Gaupe(type, id, kjønn, dato, sted, lengde, vekt, øreHår));
    }

    public int idGenerator(String type){
        int generertId;
        int hCnt = 0;
        int gCnt = 0;
        for(Dyr d : dyrene) {
            if (d.getType().equals("H")) {
                hCnt++;
            }
            else{
                gCnt++;
            }
        }
        if(type.equals("H")){
            generertId = hCnt + 1;
            return (generertId);
        }
        else{
            generertId = gCnt + 1;
            return (generertId);
        }

    }

    public String sok(String dyreId) {
        int midten = dyreId.length() / 2; //Finner midten av strengen
        String artId = dyreId.substring(0, midten);//deler strengen i 2 deler ved hjelp av substring
        String nummerId = dyreId.substring(midten);
        int nummerIdInt = Integer.parseInt(nummerId); //Konventerer til integer

        for (Dyr d : dyrene) {
            if (d.getId() == nummerIdInt && d.getType().equals(artId)) {
                //Retunere til grensesnitt
                return d.toString() + "\n" +  d.gjenfangst.toString(); //retunerer toString metoden for aktuelle dyret i array + toString metoden til dyret i gjenfangst array.

            }
        }
        return "Dyret du søker etter finnes ikke";
    }

    public void regGjenfangstHare(String dyreId){
        int midten = dyreId.length() / 2;
        String artId = dyreId.substring(0, midten);
        String nummerID = dyreId.substring(midten);
        int nummerIdInt = Integer.parseInt(nummerID);

        for (Dyr d : dyrene){
            if (d.getId() == nummerIdInt && d.getType().equals(artId)){
                String dato = JOptionPane.showInputDialog("Oppgi gjenfangst dato");
                String sted = JOptionPane.showInputDialog("Oppgi gjenfangst sted");
                double lengde = Double.parseDouble(JOptionPane.showInputDialog("Oppgi gjenfangst lengde"));
                double vekt = Double.parseDouble(JOptionPane.showInputDialog("Oppgi gjenfangst vekt"));
                String pels = JOptionPane.showInputDialog("Vennligst oppgi gjenfangs farge på pels");

                d.regHareGjenfangst(dato, sted, lengde, vekt, pels);
            }
        }
    }

    public void regGjenfangstGaupe(String dyreId){
        int midten = dyreId.length() / 2;
        String artId = dyreId.substring(0, midten);
        String nummerID = dyreId.substring(midten);
        int nummerIdInt = Integer.parseInt(nummerID);

        for (Dyr d : dyrene){
            if(d.getId() == nummerIdInt && d.getType().equals(artId)){
                String dato = JOptionPane.showInputDialog("Oppgi gjenfangst dato");
                String sted = JOptionPane.showInputDialog("Oppgi gjenfangst sted");
                double lengde = Double.parseDouble(JOptionPane.showInputDialog("Oppgi gjenfangst lengde"));
                double vekt = Double.parseDouble(JOptionPane.showInputDialog("Oppgi gjenfangst vekt"));
                double øreHårLengde = Double.parseDouble(JOptionPane.showInputDialog("Oppgi gjenfangst ørelengde"));

                d.regGaupeGjenfangst(dato, sted, lengde, vekt, øreHårLengde);
            }
        }
    }


    public String skrivUt(){
        String rapport= "";
        for(Dyr d: dyrene){
            rapport += d.toString() + "\n";
        }

        return rapport;
    }




}
