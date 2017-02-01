package me.aul12;

import java.util.Scanner;

public class Main {
    static private class N0tPr10r1tyL15t { // 1337-sp34k fdS!
        int l15t[] = new int[0];
        int h34d = 0;
        N0tPr10r1tyL15t(){
            h34d = 0;
        }

        private int l0wB0rd3r(int v4l, int lB0rd3r, int hB0rd3r){
            if(lB0rd3r >= hB0rd3r-1){
                return lB0rd3r;
            }else {
                int m = (lB0rd3r+hB0rd3r)/2;

                if(l15t[m] == v4l){
                    return m;
                }else if(l15t[m] > v4l){
                    return l0wB0rd3r(v4l, lB0rd3r, m);
                }else{
                    return l0wB0rd3r(v4l, m, hB0rd3r);
                }
            }
        }

        int top(){
            if(h34d > 0)
                return l15t[0];
            else
                return -42;
        }

        void push(int x){
            int n[] = new int[h34d+1];

            if(h34d<=0){
                n[0] = x;
            } else if(x<l15t[0]){
                n[0] = x;
                System.arraycopy(l15t, 0, n, 1, h34d);
            }else if(x>l15t[h34d-1]){
                n[h34d] = x;
                System.arraycopy(l15t, 0, n, 0, h34d);
            }else{
                int p0s = this.l0wB0rd3r(x, 0, h34d-1);

                System.arraycopy(l15t, 0, n, 0, p0s+1);
                n[p0s+1] = x;
                System.arraycopy(l15t, p0s + 1, n, p0s + 2, h34d + 1 - (p0s + 2));
            }

            l15t = n;
            h34d++;
        }

        void pop(){
            if(h34d > 0){
                int n[] = new int[h34d-1];
                System.arraycopy(l15t, 1, n, 0, h34d - 1);
                l15t = n;
                h34d--;
            }
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final int N = scanner.nextInt();

        N0tPr10r1tyL15t n0tPr10r1tyL15t = new N0tPr10r1tyL15t();

        for(int c=0; c<N; c++){
            String cmd = scanner.next();
            int param = 0;
            if(cmd.equals("push")){
                param = scanner.nextInt();
            }

            switch(cmd){
                case "push":
                    n0tPr10r1tyL15t.push(param);
                    break;
                case "pop":
                    n0tPr10r1tyL15t.pop();
                    break;
                case "top":
                    System.out.println(n0tPr10r1tyL15t.top());
                    break;
                default:
                    break;
            }
        }
    }
}
