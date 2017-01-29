package me.aul12;

import java.util.Arrays;
import java.util.Scanner;



public class Main {
    static int highBorder(int a[], int high, int lowBorder, int highBorder){
        if(lowBorder >= highBorder-1){
            return a[highBorder];
        }else {
            int m = (lowBorder+highBorder)/2;

            if(a[m] == high){
                return high;
            }else if(a[m] < high){
                return highBorder(a, high, m, highBorder);
            }else{
                return highBorder(a, high, lowBorder, m);
            }
        }
    }

    static int lowBorder(int a[], int low, int lowBorder, int highBorder){
        if(lowBorder >= highBorder-1){
            return a[lowBorder];
        }else {
            int m = (lowBorder+highBorder)/2;

            if(a[m] == low){
                return low;
            }else if(a[m] > low){
                return lowBorder(a, low, lowBorder, m);
            }else{
                return lowBorder(a, low, m, highBorder);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int input[] = new int[n];

        for(int c=0; c<input.length; c++)
            input[c] = scanner.nextInt();

        // Not necessary because sorted
        Arrays.sort(input);

        int q = scanner.nextInt();

        for(int c=0; c<q; c++){
            int low = scanner.nextInt();
            int high = scanner.nextInt();

            System.out.print(lowBorder(input, low, 0, input.length-1) + " ");
            System.out.println(highBorder(input, high, 0, input.length-1));
        }
    }
}
