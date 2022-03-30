import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

//Lösungsidee übernommen und
// weiter bearbeitet mit einem wörterbuch und einem simulierten Galgenmännchen


public class Hangman2 {
    private String gesuchtesWort;
    private char[] anzeigeText;
    int leben = 6;
    boolean richtigeEingabe = false;


    public Hangman2(String gesuchtesWort){
        this.gesuchtesWort = gesuchtesWort;
        this.anzeigeText = new char[this.gesuchtesWort.length()];
        java.util.Arrays.fill(anzeigeText, '-');
    }

    public String rateBuchstabe(char buchstabe){
        String text = "";

        richtigeEingabe = false;

        for(int i=0; i<this.gesuchtesWort.length(); i++){

            if(this.gesuchtesWort.charAt(i) == buchstabe){
                anzeigeText[i] = buchstabe;
                richtigeEingabe = true;
            }



        }

        for(char abc:anzeigeText){
            text += abc;
        }
        return text;


    }

    public boolean istGeloest(){
        boolean geloest = true;

        char abc;
        for(int i=0; i<anzeigeText.length; i++){
            abc = anzeigeText[i];
            if(abc=='-'){
                geloest=false;
            }

        }

        return geloest;
    }


    public static void main(String[] args) throws Exception  {
        System.out.println("Willkommen beim Galgenmännchen Spiel!");


        //Ein wörterbuch erstellen und scannen
        File wörterbuch = new File("C:/Users/Furkan/Desktop/Wörterbuch.txt"); //Fügen sie hier ihren den Wörterbuchpfad ein!
        Scanner textScannen = new Scanner(wörterbuch);
        Scanner sc = new Scanner(System.in);

        ArrayList<String> wörter = new ArrayList<>();
        while (textScannen.hasNextLine()) {
            wörter.add(textScannen.nextLine());
        }

       String versteckterText = wörter.get((int) (Math.random() * wörter.size()));

        Hangman2 raetsel = new Hangman2(versteckterText);

        String eingabe = "",
                antwort = "";


        char buchstabe;

        antwort = raetsel.rateBuchstabe('%');

            while (!raetsel.istGeloest()) {
                System.out.print(antwort + "\tRate einen Buchstaben ");
                eingabe = sc.next();

                if (eingabe.length() > 0) {
                    buchstabe = eingabe.charAt(0);
                    antwort = raetsel.rateBuchstabe(buchstabe);
                }

                if (!raetsel.richtigeEingabe){
                    raetsel.leben--;
                    System.out.println("\nFalscher Buchstabe");
                }


                System.out.println("Du hast nurnoch " + raetsel.leben + " leben.");
                hängtIhn(raetsel.leben);

                if(raetsel.leben <= 0) {
                    System.out.println("Du bist Tod....");
                    break;
                }


            }
        if(raetsel.istGeloest()) {
            System.out.println("\nRichtig !!\n Das zu ratende Wort war " + antwort + ".");
        }
    }


//Der Galgenmännchen Körper
public static void hängtIhn(int l) {
        if (l == 6) {
            System.out.println("|-------------------");
            System.out.println("|                  |");
            System.out.println("|                  |");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        }

    else if (l == 5) {
        System.out.println("|-------------------");
        System.out.println("|                  |");
        System.out.println("|                  |");
        System.out.println("|                  O");
        System.out.println("|");
        System.out.println("|");
        System.out.println("|");
        System.out.println("|");
    }

    else if (l == 4) {
        System.out.println("|-------------------");
        System.out.println("|                  |");
        System.out.println("|                  |");
        System.out.println("|                  O");
        System.out.println("|                  |");
        System.out.println("|");
        System.out.println("|");
        System.out.println("|");
    }

    else if (l == 3) {
        System.out.println("|-------------------");
        System.out.println("|                  |");
        System.out.println("|                  |");
        System.out.println("|                  O");
        System.out.println("|                 -|");
        System.out.println("|");
        System.out.println("|");
        System.out.println("|");
    }

    else if (l == 2) {
        System.out.println("|-------------------");
        System.out.println("|                  |");
        System.out.println("|                  |");
        System.out.println("|                  O");
        System.out.println("|                 -|-");
        System.out.println("|");
        System.out.println("|");
        System.out.println("|");
    }

    else if (l == 1) {
        System.out.println("|-------------------");
        System.out.println("|                  |");
        System.out.println("|                  |");
        System.out.println("|                  O");
        System.out.println("|                 -|-");
        System.out.println("|                 / ");
        System.out.println("|");
        System.out.println("|");
    }

    else {
        System.out.println("|-------------------");
        System.out.println("|                  |");
        System.out.println("|                  |");
        System.out.println("|                  O");
        System.out.println("|                 -|-");
        System.out.println("|                 /|");
        System.out.println("|");
        System.out.println("|");
    }
  }
}
