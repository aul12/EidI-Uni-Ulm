package me.aul12;

import java.util.Scanner;

public class Main {

    private static class Point{
        double x, y;

        Point(double x, double y){
            this.x = x;
            this.y = y;
        }

        boolean equals(Point p){
            return (this.x == p.x && this.y == p.y);
        }
    }

    private static class Line{
        Point a = new Point(0,0);
        Point b = new Point(0,0);

        Line(Point a, Point b){
            if(a.x > b.x){
                this.a = a;
                this.b = b;
            }else{
                this.a = b;
                this.b = a;
            }
        }

        Line(double gradient, Point p){
            a.x = p.x;
            a.y = p.y;
            b.x = p.x + 1;
            b.y = p.y + gradient;
        }

        boolean isVertical(){
            return this.a.x == this.b.x;
        }

        boolean isHorizontal(){
            return this.a.y == this.b.y;
        }

        double getGradient(){
            if(isVertical())
                return Double.MAX_VALUE;
            else
                return (b.y - a.y)/(b.x - a.x);
        }


        Line getOrthogonal(Point p){
            if(isVertical()){
                return new Line(p, new Point(p.x + 1, p.y));
            }else if(isHorizontal()) {
                return new Line(p, new Point(p.x, p.y+1));
            }else{
                return new Line(-1/this.getGradient(), p);
            }
        }

        double getValue(double x){
            if(!isVertical())
                return a.y + (x-a.x) * getGradient();
            else
                return 0;
        }

        Point getIntersection(Line line){
            if(this.isVertical() || line.isVertical()){
                if(line.isVertical())
                    return new Point(line.a.x, this.getValue(line.a.x));
                else
                    return new Point(this.a.x, line.getValue(this.a.x));
            }else{
                /*
                a1*t + s1 = a2*t + s2
                (a1-a2)*t = s2-s1
                t = (s2-s1)/(a1-a2)
                */
                double xt = (line.a.x - this.a.x)/(line.getGradient() - this.getGradient());
                return new Point(xt, getValue(xt));
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testcases = scanner.nextInt();

        StringBuilder res = new StringBuilder();

        for(int c=0; c<testcases; c++){
            Point corners[] = new Point[3];

            for(int d=0; d<3; d++){
                corners[d] = new Point(scanner.nextInt(), scanner.nextInt());
            }

            Line ac = new Line(corners[0], corners[2]);
            Line ab = new Line(corners[0], corners[1]);
            Line bc = new Line(corners[1], corners[2]); //@check

            Line hoheLinieA = bc.getOrthogonal(corners[0]); //@check
            Line hoheLinieB = ac.getOrthogonal(corners[1]);
            Line hohenLinieC = ab.getOrthogonal(corners[2]);

            Point intersect1 = hoheLinieA.getIntersection(hoheLinieB);
            Point intersect2 = hoheLinieB.getIntersection(hohenLinieC);
            Point intersect3 = hoheLinieA.getIntersection(hohenLinieC);

            Point intersect;

            if(intersect1.equals(intersect2))
                intersect = intersect1;
            else if(intersect1.equals(intersect3))
                intersect = intersect1;
            else
                intersect = intersect2;

            res.append(intersect.x).append(" ").append(intersect.y).append("\n");
        }

        System.out.print(res.toString());
    }
}
