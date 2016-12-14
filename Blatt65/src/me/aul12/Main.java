package me.aul12;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final int expon = 3;

        Scanner scanner = new Scanner(System.in);

        int length = scanner.nextInt();

        int field[][] = new int[length][length];


        int sum = 0;
        for(int c=1; c<= length; c++)
            sum += Math.pow(c, expon);

        for(int x=0; x<length; x++){
            for(int y=0; y<length; y++){
                field[x][y] = (int)Math.pow(scanner.nextInt(), expon);
            }
        }

        boolean sumOk = true;
        for(int c=0; c<length; c++){
            int sumX=0, sumY=0;
            for(int d=0; d<length; d++){
                sumX += field[c][d];
                sumY += field[d][c];
            }

            if(sumX != sum || sumY != sum){
                sumOk = false;
                break;
            }
        }

        int blockSize = (int)Math.sqrt(length);

        for(int x=0; x<length; x+=blockSize){
            for(int y=0; y<length; y+=blockSize){
                int sumBlock = 0;

                for(int c=0; c<blockSize; c++){
                    for(int d=0; d<blockSize; d++){
                        sumBlock += field[x+c][y+d];
                    }
                }

                if(sumBlock != sum){
                    sumOk = false;
                    break;
                }
            }

            if(!sumOk)
                break;
        }

        System.out.printf(sumOk?"yes":"no");
    }
}
