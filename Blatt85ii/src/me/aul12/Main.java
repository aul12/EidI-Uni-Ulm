static int method(boolean[] in1){
        int res = 0;

        for (boolean anIn1 : in1) {
        res <<= 1;
        res |= anIn1 ? 1 : 0;
        }
        return res;
        }

/*package me.aul12;

public class Main {

    public static void main(String[] args) {
	// write your code here
        boolean arr[] = {true, true, true};
        System.out.print(method(arr));
    }
    static int method(boolean[] in1){
        int res = 0;

        for (boolean anIn1 : in1) {
            res <<= 1;
            res |= anIn1 ? 1 : 0;
        }
        return res;
    }
}*/
