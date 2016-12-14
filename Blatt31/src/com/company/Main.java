package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rHours = scanner.nextInt();
        int rMinutes = scanner.nextInt();
        int rSeconds = scanner.nextInt();

        int seconds = rSeconds % 60;
        int minWithSec = rMinutes + ((rSeconds-seconds)/60);
        int minutes = minWithSec%60;
        int hours = rHours + minWithSec/60;

	    System.out.print(hours+"\n"+minutes+"\n"+seconds);
    }
}
