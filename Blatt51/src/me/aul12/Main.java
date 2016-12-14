package me.aul12;

public class Main {

    public static void main(String[] args) {
        final short max = 1000;

        final byte root = (byte)Math.sqrt(max);

        byte primes[] = new byte[root/2];
        byte primeLen = 1;

        primes[0] = 2;

        for(short i=2; i<=max; i++){
            boolean isPrime = true;
            for(byte j=0; primes[j] <= Math.sqrt(i) && j<primeLen; j++){
                if(i%primes[j] == 0){
                    System.out.println("Der kleinste Teiler von " + i + " ist " +primes[j]);
                    isPrime = false;
                    break;
                }
            }
            if(isPrime){
                System.out.println("Der kleinste Teiler von " + i + " ist " + i);

                if(i <= root){
                    primes[primeLen++] = (byte)i;
                }
            }
        }
    }
}
