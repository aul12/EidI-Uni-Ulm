package me.aul12;

import java.util.Scanner;

public class Main {
    private static boolean isBomb(byte field[][], int x, int y, int w, int h) {
        return !(x < 0 || y < 0 || x >= w || y >= h) && field[x][y] == -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        short testcases = scanner.nextShort();


        StringBuilder res = new StringBuilder();

        for(short t=0; t<testcases; t++){
            short w = scanner.nextShort();
            short h = scanner.nextShort();

            byte field[][] = new byte[w][h];

            //Read
            for(int x=0; x<w; x++){
                String line = scanner.next();
                for(int y=0; y<h; y++){
                    field[x][y] = (byte)(line.charAt(y)=='*'?-1:0);
                }
            }

            for(int x=0; x<w; x++){
                for(int y=0; y<h; y++){
                    if(!isBomb(field, x, y, w, h)){
                        for(int xB=-1; xB<=1; xB++){
                            for(int yB=-1;yB<=1; yB++){
                                field[x][y] += isBomb(field, x+xB, y+yB, w, h)?1:0;
                            }
                        }
                        res.append(field[x][y]);
                    }else{
                        res.append("*");
                    }
                }
                res.append("\n");
            }
            res.append("\n");
        }

        System.out.print(res.toString());
    }
}
