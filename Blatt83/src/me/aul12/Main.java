package me.aul12;

public class Main {

    public static void main ( String [] args ) {
        int [][] m = {{1 , 2} , {3}};
        println ( m ) ;
        exchange ( m [0][0] , m [0][1]) ; // (1)
        println ( m ) ;
        exchange ( m ) ; // (2)
        println ( m ) ;
        exchange ( m [0] , m [1]) ; // (3)
        println ( m ) ;
    }
    static void exchange ( int x , int y) { // (A)
        int tmp = x ; x = y ; y = tmp ;
    }
    static void exchange ( int [] x , int [] y ) { // (B)
        int [] tmp = x ; x = y ; y = tmp ;
    }
    static void exchange ( int [][] x ) { // (C)
        int [] tmp = x [0]; x [0] = x [1]; x [1] = tmp ;
    }
    static void println ( int [][] x ) {
        System . out . println ( java . util . Arrays . deepToString ( x ) ) ;
    }
}
