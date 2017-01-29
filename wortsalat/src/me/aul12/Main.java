package me.aul12;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.next();

        int poss = 0;
        for(char c='a'; c<='z'; c++){
            if(input.indexOf(c) == -1)
                poss++;
        }

        if(poss == 0)
            System.out.print("impossible");
        else
            System.out.print(poss);
    }
}
