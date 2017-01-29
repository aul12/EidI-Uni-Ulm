package me.aul12;

import java.util.Arrays;

public class Main {

    private static int [] remove(int a[], int i){
        int []out = new int[a.length-1];
        System.arraycopy(a, 0, out, 0, i);
        System.arraycopy(a, i + 1, out, i + 1 - 1, a.length - (i + 1));

        return out;
    }

    private static int[] append(int[] a, int n){
        int out[] = new int[a.length+1];
        System.arraycopy(a, 0, out, 0, a.length);
        out[a.length] = n;

        return out;
    }

    private static int fac(int n){
        if(n<=1)
            return 1;
        else
            return fac(n-1)*n;
    }

    private static int [][] _permutations(int a[], int len){
        if(a.length == 1){
            return new int[][]{a};
        }else{
            int ret[][] = new int[fac(a.length)][len];
            int head = 0;
            for(int c=0; c<a.length; c++){
                int [][] up = _permutations(remove(a, c), len);
                for(int d=0; d<up.length; d++)
                    ret[d+head] = append(up[d], a[c]);
                head += up.length;
            }
            return ret;
        }
    }

    private static int [][]permutations(int a[]){
        return _permutations(a, a.length);
    }

    public static void main(String[] args) {
        int[] a = {1,2,3};
        System.out.print(Arrays.deepToString(permutations(a)));
    }
}
