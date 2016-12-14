package me.aul12;

public class Main {

    public static void main(String[] args) {

            // Aufgabe a)
            int k0 = ...;
            int i = 1;
            do {
                if(i==1 && i>=k0)
                    break;
                System.out.println(i * i);
            }while(++i<k0);


            // Aufgabe b)
            int [] k1 = ...;
            int x = 0;

            for(int i: k1){
                if(i == 0)
                    break;
                x += i;
            }
            System.out.println ("x: " + x) ;


            // Aufgabe c)
            int [] k2 = ...;

            int max = Integer.MIN_VALUE;

            for(int c=0; c<k2.length; c++){
                if(k2[c] > max)
                    max = k2[c];
            }
            System . out . println ("max : " + max );
    }
}
