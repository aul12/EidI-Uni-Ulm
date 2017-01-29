package me.aul12;

import java.util.Scanner;

public class Main {

    static final String spiceClasses[] = {"LSPICE", "PSPICE", "NPSPICE", "EXPSPICE"};

    static class Meal{
        int spice = 0;
        String name = "";

        void setSpice(String spice){
            for(int c=0; c<spiceClasses.length; c++){
                if(spiceClasses[c].equals(spice)){
                    this.spice = c;
                    return;
                }
            }
            this.spice = 0;
        }

        void setName(String name) {
            this.name = name;
        }

        String getName(){
            return this.name;
        }

        int getSpiceNumeric(){
            return spice;
        }
        String getSpiceName(){
            return spiceClasses[spice];
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int rounds = (int)Math.ceil(n/4.0);

        Meal meals[][] = new Meal[rounds][4];

        for(int c=0; c<n; c++){
            Meal input = new Meal();
            input.setName(scanner.next());
            input.setSpice(scanner.next());

            for(int s=0; s<rounds; s++){
                if(meals[s][input.getSpiceNumeric()] == null){
                    meals[s][input.getSpiceNumeric()] = input;
                    break;
                }
            }
        }



        for(int c=0; c<rounds; c++){
            for(int d=0; d<4; d++){
                if(meals[c][d] == null){
                    return;
                }else{
                    System.out.println(meals[c][d].getName());
                }
            }
        }
    }
}
