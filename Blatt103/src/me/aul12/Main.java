package me.aul12;

import java.util.Arrays;

public class Main {


    static void radixSort(int a[]){
        //System.out.println(Arrays.toString(a));
        int parts[][] = new int[2][a.length];
        int head[] = new int[2];

        for(int bit=0; bit<32; bit++){
            head[0] = head[1] = 0;

            for (int anA : a) {
                int part = (anA & (1 << bit)) != 0 ? 1 : 0;
                parts[part][head[part]++] = anA;
            }

            System.arraycopy(parts[0], 0, a, 0, head[0]);
            System.arraycopy(parts[1], 0, a, head[0], head[1]);
        }
    }

    static int partition(int[] a, int i, int j, int p){
        radixSort(a);

        for(int c=0; c<a.length; c++){
            if(a[c] > p)
                return c;
        }
        return a.length;
    }

    public static void main(String[] args) {
        int a[] = {2, 3, 4, 7, 1, 9};

        radixSort(a);

        System.out.print(partition(a, 0,0, 100));
    }
}
