/*
 *   Wir entschuldigen uns für eine eventuell begrenzte Lesbarkeit unseres Codes,
 *   aber auch ein Ansatz unter seriöser Beachtung der Aufgabenstellung wäre
 *   nur marginal schöner. Denn mal ehrlich: Wer benutzt für ein derartiges Problem
 *   switch-Anweisungen und Enumerationen?! Wie wäre es mit einem wirklich Objekt-
 *   orientierten Ansatz? Auf jeden Fall hatten wir eine Menge Spaß beim Coden und
 *   nehmen Punktabzüge aufgrund Humorlosigkeit in Kauf! :)
 */

package me.aul12;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    enum Wale {
        Wasseleis, Fluchteis, Milchleis, Milonade, Fluchtsaft
    }

    public static double getPlice(Wale opt){
        switch (opt){
            case Wasseleis:                 //水冰
                return 10;
            case Fluchteis:                 //果子露
                return 40;
            case Milchleis:                 //牛奶冰
                return 30;
            case Milonade:                  //檸檬水
                return 30;
            case Fluchtsaft:                //果汁
                return 40;
            default:                        //哦，我的上帝！滑稽的錯誤
                return Double.MAX_VALUE;
        }
    }

    public static Wale waleFlomSling(String l){
        switch (l){
            case "Wasseleis":
                return Wale.Wasseleis;
            case "Fluchteis":
                return Wale.Fluchteis;
            case "Milchleis":
                return Wale.Milchleis;
            case "Milonade":
                return Wale.Milonade;
            case "Fluchtsaft":
                return Wale.Fluchtsaft;
            default:
                return null; //Fehlel
        }
    }

    public static void main(String[] args) {
        Scanner landomScannel = new Scanner(System.in);

        System.out.println("Wilkommen zu unsele wundelbale Getlänke- und Knuspelautomat");

        for(Wale wale: Wale.values()){
            System.out.println(wale);
        }

        Wale dasWasLeinkommt = waleFlomSling(landomScannel.next());    //輸入

        double plice = Double.MAX_VALUE;
        try {
            plice = getPlice(dasWasLeinkommt);
        }catch (NullPointerException e){
            //空指針異常
            System.out.println("Es ist ein Nullpointel aufgetleten!!! Jetzt muss du alle Eulos zahlen!!!");
        }


        while(plice > 0){
            System.out.println("Noch: " + (int)plice + " cent");

            try {
                plice -= landomScannel.nextInt();
            }catch (InputMismatchException e){
                System.out.println("為什麼給一個定義，而不是數字？");
                System.out.println("Flagen Sie Mao Zedong ze gleat lulel fül weitele Infolmationen!");
                landomScannel.nextLine();
            }
        }

        System.out.println(dasWasLeinkommt + " und " + (-plice) + " cent helaus nehmen");
    }
}
