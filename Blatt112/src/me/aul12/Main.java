package me.aul12;

import java.util.Arrays;

public class Main {

    private static boolean isLarger(String a, String b){
        if(a.length() == b.length()){
            return a.compareTo(b) > 0;
        }else{
            return a.length() > b.length();
        }
    }

    private static String []specialSort(String a[], int l){
        if(l <= 1){
            if(l <= 0)
               return new String[0];
            else
                return a;
        }else{
            String low[] = new String[a.length-1];
            String upper[] = new String[a.length-1];

            // aka String low[a.length.1] = {""};
            Arrays.fill(low, "");
            Arrays.fill(upper, "");

            String pivot = a[0];
            int lowHead=0, upperHead=0;

            for(int c=1; c<l; c++){
                if(isLarger(a[c], pivot)){
                    upper[upperHead++] = a[c];
                }else{
                    low[lowHead++] = a[c];
                }
            }

            low = specialSort(low, lowHead);
            upper = specialSort(upper, upperHead);

            for(int c=0; c<l; c++){
                if(c < lowHead)
                    a[c] = low[c];
                else if(c > lowHead)
                    a[c] = upper[c-lowHead-1];
                else
                    a[c] = pivot;
            }
            return a;
        }
    }

    public static void main(String[] args) {
        System.out.println("Ausgabe "+/*3*/+/*7*/+0);

        if(args.length <= 0){
            System.out.println("See: http://bfy.tw/9fiB");
        }else{
            String ordered[] = specialSort(args, args.length);
            for(String s: ordered){
                System.out.println(s);
            }
        }
    }
}