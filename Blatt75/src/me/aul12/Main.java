package me.aul12;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int inbounds[][] = new int[n][n];
        int head[] = new int[n];

        for(int c=0; c<n; c++){
            head[c] = 0;
            for(int d=0; d<n; d++){
                inbounds[c][d] = Integer.MAX_VALUE;
            }
        }

        for(int c=0; c<n; c++){
            int outboundN = scanner.nextInt();

            for(int d=0; d<outboundN; d++){
                int target = scanner.nextInt();

                inbounds[target][head[target]++] = c;
            }
        }

        for(int c=0; c<n; c++){
            Arrays.sort(inbounds[c]);

            System.out.printf("\n%d", head[c]);
            for(int d=0; d<head[c] && inbounds[c][d]!=Integer.MAX_VALUE; d++){
                System.out.print(" "+inbounds[c][d]);
            }
        }
    }
}