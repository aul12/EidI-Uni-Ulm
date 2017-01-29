package me.aul12;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);

	    double a = scanner.nextDouble();
	    double h = scanner.nextDouble();

	    System.out.println(Math.sqrt(a) * h * 4);
    }
}
