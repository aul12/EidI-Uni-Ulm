package me.aul12;

import java.util.Scanner;


public class Main {

    private enum orientation {
        VERTICAL, HORIZONTAL
    }

    private static class Point {
        int x = 0;
        int y = 0;
    }

    private static class Line {
        Point p1;
        Point p2;

        //Konstruktor
        Line() {
            p1 = new Point();
            p2 = new Point();
        }

        //Ausrichtung der Linien testen (Horizontal/Vertikal)
        orientation getOrientation() {
            return (p1.x == p2.x) ? orientation.VERTICAL : orientation.HORIZONTAL;
        }

        //Schnittpunkte von Linien testen
        boolean intersects(Line l) {
            //Parallel
            if (this.getOrientation() == l.getOrientation()) {
                if (this.getOrientation() == orientation.HORIZONTAL) {
                    //Horizontal und Parallel
                    if (this.p1.y != l.p1.y) {
                        return false;
                    }else{
                        return
                                inBetween(this.p1.x, this.p2.x, l.p1.x) ||
                                inBetween(this.p1.x, this.p2.x, l.p2.x) ||
                                inBetween(l.p1.x, l.p2.x, this.p1.x) ||
                                inBetween(l.p1.x, l.p2.x, this.p2.x);
                    }
                } else {
                    //Vertical und Parallel
                    if (this.p1.x != l.p1.x) {
                        return false;
                    }else{
                        return
                                inBetween(this.p1.y, this.p2.y, l.p1.y) ||
                                inBetween(this.p1.y, this.p2.y, l.p2.y) ||
                                inBetween(l.p1.y, l.p2.y, this.p1.y) ||
                                inBetween(l.p1.y, l.p2.y, this.p2.y);
                    }
                }
            } else {
                //Orthogonal
                if (this.getOrientation() == orientation.HORIZONTAL) {
                    if(!inBetween(this.p1.x, this.p2.x, l.p1.x)) {
                        return false;
                    }else{
                        return inBetween(l.p1.y, l.p2.y, this.p1.y);
                    }
                }else{
                    if (!inBetween(this.p1.y, this.p2.y, l.p1.y)) {
                        return false;
                    }else{
                        return inBetween(l.p1.x, l.p2.x, this.p1.x);
                    }
                }
            }
        }
    }

    private static boolean inBetween(int xmin, int xmax, int test) {
        if (xmax < xmin) {
            int temp = xmax;
            xmax = xmin;
            xmin = temp;
        }

        return (test >= xmin && test <= xmax);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final byte X1 = 0;
        final byte Y1 = 1;
        final byte X2 = 2;
        final byte Y2 = 3;

        int r1C[] = new int[4];
        int r2C[] = new int[4];

        //Zeichen einlesen
        for(byte c = 0; c < 4; c++) {
            r1C[c] = scanner.nextInt();
        }

        for(byte c = 0; c < 4; c++) {
            r2C[c] = scanner.nextInt();
        }


        Line r1L[] = new Line[4];
        Line r2L[] = new Line[4];

        for(int c = 0; c < 4; c++){
            //Erstes Rechteck berechnen
            r1L[c] = new Line();

            //Eckpunkte
            r1L[c].p1.y = r1C[(c / 2) * 2 + 1];                     //1133
            r1L[c].p2.y = r1C[(((c + 1) / 2) % 2) * 2 + 1];         //1331
            r1L[c].p1.x = r1C[(((c + 1) / 2) % 2) * 2];             //0220
            r1L[c].p2.x = r1C[((3 - c) / 2) * 2];                   //2200

            //Zweites Rechteck berechnen
            r2L[c] = new Line();

            //Eckpunkte
            r2L[c].p1.y = r2C[(c / 2) * 2 + 1];                     //1133
            r2L[c].p2.y = r2C[(((c + 1) / 2) % 2) * 2 + 1];         //1331
            r2L[c].p1.x = r2C[(((c + 1) / 2) % 2) * 2];             //0220
            r2L[c].p2.x = r2C[((3 - c) / 2) * 2];                   //2200
        }

        boolean intersection = false;

        //Schnittstellen suchen
        for (int c = 0; c < 4; c++) {
            for (int d = 0; d < 4; d++) {
                if (r1L[c].intersects(r2L[d])) {
                    intersection = true;
                    break;
                }
            }
            if (intersection)
                break;
        }

        if (
                (inBetween(r1C[X1], r1C[X2], r2C[X1]) && inBetween(r1C[X1], r1C[X2], r2C[X2])
                        && inBetween(r1C[Y1], r1C[Y2], r2C[Y1]) && inBetween(r1C[Y1], r1C[Y2], r2C[Y2])

                        || (inBetween(r2C[X1], r2C[X2], r1C[X1]) && inBetween(r2C[X1], r2C[X2], r1C[X2])
                        && inBetween(r2C[Y1], r2C[Y2], r1C[Y1]) && inBetween(r2C[Y1], r2C[Y2], r1C[Y2])))) {
            intersection = true;
        }

        System.out.print(intersection);
    }
}
