package me.aul12;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

public class mai {

    static class Road{
        int source;
        int destination;
        Road(int source, int destination){
            this.source = source;
            this.destination = destination;
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        final int n = s.nextInt();
        Hashtable<Integer, ArrayList<Integer>> inBound = new Hashtable<>();
        ArrayList<Road> roads = new ArrayList<>();

        for(int i = 0; i < n; i++){
            inBound.put(i, new ArrayList<>());
            int nRoads = s.nextInt();
            for(int c = 0; c < nRoads; c++){
                roads.add(new Road(i, s.nextInt()));
            }
        }
        s.close();

        for(Road r: roads){
            inBound.get(r.destination).add(r.source);
        }

        for(int i = 0; i < n; i++){
            System.out.printf("%d ", inBound.get(i).size());
            for(int inbound: inBound.get(i)){
                System.out.printf("%d ", inbound);
            }
            System.out.println();
        }
    }
}