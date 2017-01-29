package me.aul12;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[][]a = {{1,2},{3,4}};
        int[][]b = {{1,2,3},{2,3,4}};

        System.out.print(Arrays.deepToString(method(a, b)));
    }

    static long[][] method(int[][] A, int[][] B){
        long res[][] = new long[A.length][B[0].length];

        for(int x=0; x<A.length; x++){
            for(int y=0; y<B[0].length; y++){
                for (int k = 0; k < A[0].length; k++) {
                    res[x][y] += A[x][k] * B[k][y];
                }
            }
        }

        return res;
    }
}
