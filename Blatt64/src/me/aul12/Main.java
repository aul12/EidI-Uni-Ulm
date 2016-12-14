package me.aul12;

import java.util.Arrays;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    static class Point{
        int x = 0, y = 0;

        Point(int x, int y){
            this.x = x;
            this.y = y;
        }

        int sqDistance(Point p){
            return (p.x - this.x)*(p.x - this.x) + (p.y - this.y)*(p.y - this.y);
        }

        double distance(Point p){
            return Math.sqrt(sqDistance(p));
        }
    }

    public static void main(String[] args) {
        final int [][] setPoints = {{2,3}, {1,1}, {3,-2}, {-1,-1}, {-3,3}, {0,2}};

        Scanner scanner = new Scanner(System.in);

        Point points[] = new Point[setPoints.length];
        Point inputPoint = new Point(0,0);


        for(int c=0; c<setPoints.length; c++) {
            points[c] = new Point(setPoints[c][0], setPoints[c][1]);
        }

        try {
            inputPoint.x = scanner.nextInt();
            inputPoint.y = scanner.nextInt();
        }catch (InputMismatchException e){
            System.out.println(e.toString());
            scanner.nextLine();
        }

        Arrays.sort(points, Comparator.comparingInt(p -> p.sqDistance(inputPoint)));

        for(Point p: points){
            System.out.printf("Point:(%d|%d):\tDistance %.1f\n", p.x, p.y, p.distance(inputPoint));
        }
    }
}