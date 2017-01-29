package me.aul12;

import java.util.Scanner;

public class Main {
    private static int []removeElement(int array[], int index){
        int res[] = new int[array.length -1];
        System.arraycopy(array, 0, res, 0, index);
        System.arraycopy(array, index + 1, res, index, res.length - index);

        return res;
    }

    private static boolean checkInput(int len, int pieces[]){
        if(len == 0 ) {
            return true;
        }else if(len < 0){
            return false;
        }else{
            for(int c=0; c<pieces.length; c++){
                if(checkInput(len - pieces[c], removeElement(pieces, c)))
                    return true;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testcases = scanner.nextInt();

        for(int c=0; c<testcases; c++){
            int len = scanner.nextInt();
            int n = scanner.nextInt();
            int pieces[] = new int[n];

            for(int d=0; d<pieces.length; d++){
                pieces[d] = scanner.nextInt();
            }

            System.out.println(checkInput(len, pieces)?"Ja":"Nein");
        }
    }
}
