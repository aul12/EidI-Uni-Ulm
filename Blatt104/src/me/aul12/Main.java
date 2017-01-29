package me.aul12;



import java.util.Scanner;

public class Main {
    private static Rule[] rules = new Rule[6];

    static class Rule{
        Rule(String in, String out){
            this.in = in;
            this.out = out;
        }

        String in = "";
        String out = "";
    }


    static String replaceLast(String text, String key, String newKey){
        int i = text.lastIndexOf(key);
        String subE = text.substring(i);
        String subB = text.substring(0, i-1);
        subE = subE.replace(key, newKey);
        return subB + subE;
    }

    static int countMatches(String text, String key){
        int c=0;
        while(text.contains(key)){
            c++;
            text = text.replaceFirst(key, "");
        }
        return c;
    }

    static int getNthIndex(String text, String key, int n){
        int c=0;
        int index = text.indexOf(key);
        while(index >= 0){
            if(n == index)
                return c;
            index = text.indexOf(key, index+1);
            c++;
        }
        return c;
    }

    static String replaceNth(String text, String key, String newKey, int n){
        if(n>countMatches(text, key)){
            return null;
        }else{
            if(n!=0){
                int i = text.indexOf(text, getNthIndex(text, key, n));
                String subE = text.substring(i);
                String subB = text.substring(0, i-1);
                subE = subE.replace(key, newKey);
                return subB + subE;
            }else{
                return text.replaceFirst(key, newKey);
            }
        }
    }

    static int getMinimumLargerZero(String text){
        int min = 0;
        boolean minSet = false;
        int a = text.indexOf("A"), b = text.indexOf("B");

        if(a >= 0){
            minSet = true;
            min = a;
        }
        if(b >= 0){
            if(!minSet){
                minSet = true;
                min = b;
            }else{
                min = Math.min(min, b);
            }
        }

        if(!minSet)
            return text.length();

        return min;
    }

    static boolean isValid(String text, String grammar){
        if(text.equals(grammar))
            return true;
        else if(grammar.length() > text.length()+1)
            return false;

        int l = getMinimumLargerZero(grammar);
        if(l >= 0){
            String terminals = grammar.substring(0, l);
            if(!text.contains(terminals))
                return false;
        }


        for(Rule rule : rules) {
            if(grammar.contains(rule.in)){
                for(int c=0; c<countMatches(grammar, rule.in); c++){
                    String newText = replaceNth(grammar, rule.in, rule.out, c);
                    if (isValid(text, newText))
                        return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String input;

        Scanner scanner = new Scanner(System.in);

        input = scanner.next();

        rules[0] = new Rule("A", "(A)");
        rules[1] = new Rule("A", "[B}");
        rules[2] = new Rule("A", "{A)");
        rules[3] = new Rule("A", "");
        rules[4] = new Rule("B", "[[A]");
        rules[5] = new Rule("B", "[(B)]");


        System.out.print(isValid(input, "A"));
    }
}
