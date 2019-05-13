package com.matswa;
import javax.swing.*;

public class Grensesnitt {
    private String[] ALTERNATIV_HOVED_MENY = {"Avslutt", "Generer fangst rapport", "Søk etter dyr",
            "Register gjenfangst", "Registrer nytt dyr"};

    private Programkontroll programkontroll;

    private final int REG_DYR = 4;
    private final int REG_GJENFANGST = 3;
    private final int SOK = 2;
    private final int RAPPORT = 1;
    private final int AVSLUTT = 0;

    private String[] ALTERNATIV_SUB_MENY = {"Avslutt", "Gaupe", "Hare"};
    private final int GAUPE = 1;
    private final int HARE = 2;


    public void hovedMeny(Programkontroll programkontroll){
        this.programkontroll = programkontroll;
        boolean fortsett = true;
        while(fortsett){
            int valg = lesValgMain();
            switch (valg){
                case REG_DYR :
                    regDyr();
                    break;
                case REG_GJENFANGST :
                    regGjenfangst();
                    break;
                case SOK :
                    String sokId = JOptionPane.showInputDialog("Vennligst oppgi dyrets ID (eks. H1)");
                    String resultat = programkontroll.sok(sokId);
                    JOptionPane.showMessageDialog(null, resultat);
                    break;
                case RAPPORT :
                    String rapport = programkontroll.skrivUt();
                    JOptionPane.showMessageDialog(null, rapport);
                    break;
                case AVSLUTT :
                    fortsett = false;

            }
        }
    }

    public int lesValgMain(){
        int valg = JOptionPane.showOptionDialog(
                null,
                null,
                "Fangstrapport",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                ALTERNATIV_HOVED_MENY,
                ALTERNATIV_HOVED_MENY[0]
        );
        return valg;
    }

    public int lesValgSub(){
        int valg = JOptionPane.showOptionDialog(
                null,
                null,
                "Art",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                ALTERNATIV_SUB_MENY,
                ALTERNATIV_SUB_MENY[0]

        );
        return valg;
    }


    public void regDyr(){
        boolean fortsettRegDyr = true;
        while(fortsettRegDyr){
            int dyreValg = lesValgSub();
            switch(dyreValg){
                case HARE :
                    char individ;
                    String hareType = "H";
                    int id = programkontroll.idGenerator(hareType); //Generer id-nummer
                    String kjønn = JOptionPane.showInputDialog("Oppgi kjønn");
                    if (kjønn == null){
                        break;
                    }
                    String dato = JOptionPane.showInputDialog("Oppgi fangstdato (dag, måned, år)");
                    if (dato == null){
                        break;
                    }
                    String sted = JOptionPane.showInputDialog("Oppgi fangststed");
                    if (sted == null){
                        break;
                    }
                    double lengde = Double.parseDouble(JOptionPane.showInputDialog("Oppgi lengde"));
                    double vekt = Double.parseDouble(JOptionPane.showInputDialog("Oppgi vekt"));
                    String getChar = JOptionPane.showInputDialog("Oppgi individ"); //Kan ikke bruke showinputdialog med typen CHAR må konvertere.
                    if(getChar == null){ //Kontroll av bruker innput
                        break;
                    }
                    else if(getChar.length() == 0) {
                        break;
                    }
                    else{
                        individ = getChar.charAt(0);
                    }
                    String pels = JOptionPane.showInputDialog("Oppgi farge på pels");
                    if (pels == null){
                        break;
                    }

                    programkontroll.regHare(hareType, id, kjønn, dato, sted, lengde, vekt, individ, pels);
                    programkontroll.lagre();
                    break;
                case GAUPE :
                    String gaupeType = "G";
                    int id1 = programkontroll.idGenerator(gaupeType); // Genererer id-nummer
                    String kjønn1 = JOptionPane.showInputDialog("Oppgi kjønn");
                    if (kjønn1 == null){
                        break;
                    }
                    String dato1 = JOptionPane.showInputDialog("Oppgi fangsdato (dag, måned, år)");
                    if(dato1 == null){
                        break;
                    }
                    String sted1 = JOptionPane.showInputDialog("Oppgi fangststed");
                    if (sted1 == null){
                        break;
                    }
                    double lengde1 = Double.parseDouble(JOptionPane.showInputDialog("Oppgi lengde"));
                    double vekt1 = Double.parseDouble(JOptionPane.showInputDialog("Oppgi vekt"));
                    double øreHår = Double.parseDouble(JOptionPane.showInputDialog("Oppgi ørehårslengde"));

                    programkontroll.regGaupe(gaupeType, id1, kjønn1, dato1,sted1,lengde1,vekt1,øreHår);
                    programkontroll.lagre();
                    break;
                case AVSLUTT :
                    fortsettRegDyr = false;

            }
        }
    }

    public void regGjenfangst(){
        boolean fortsett = true;
        while(fortsett){
            int dyrevalg = lesValgSub();
            switch (dyrevalg){
                case HARE:
                    String dyreId = JOptionPane.showInputDialog("Vennligst oppgi dyrets ID (eks. H1) ");
                    programkontroll.regGjenfangstHare(dyreId);
                    break;
                case GAUPE:
                    String dyreId2 = JOptionPane.showInputDialog("Vennligst oppgi dyrets ID (eks. H1) ");
                    programkontroll.regGjenfangstGaupe(dyreId2);
                    break;
                case AVSLUTT:
                    fortsett = false;
            }
        }
    }

}
