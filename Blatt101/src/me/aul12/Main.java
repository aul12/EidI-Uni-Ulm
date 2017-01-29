package me.aul12;

public class Main {
    // a)
    static long f(long n){
        if(n == 1)
            return 0;
        else if(n%2 == 0)
            return f(n/2) + 1;
        else
            return f(3*n + 1) + 1;
    }

    // b)
    static long f_tailRecursive(long n, long pseudoStack){
        if(n==1)
            return pseudoStack;
        else if(n%2==0)
            return f_tailRecursive(n/2, pseudoStack+1);
        else
            return f_tailRecursive(3*n +1, pseudoStack+1);
    }

    // c)
    static long f_iterative(long n){
        int pseudoStack = 0;
        while(n!=1){
            if(n%2==0){
                n /= 2;
            }else{
                n = (n*3)+1;
            }
            pseudoStack++;
        }
        return pseudoStack;
    }



    public static void main(String[] args) {
        for(int c=1; c<30; c++)
            System.out.println(c+": "+f(c) + " " + f_tailRecursive(c, 0) + " "+ f_iterative(c));
    }
}
