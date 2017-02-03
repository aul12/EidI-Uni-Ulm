package me.aul12;

import java.util.*;

class Main {
    static String operands = new String(new char[] {'(', ')', '+', '-', '*', '/'});
    static int[] prec      =                       { 0 , -1 ,  1 ,  1 ,  2 ,  2 };

    static int pos = 0;
    static String s;

    //evaluate a given operand using two values
    static double eval( int op, double lhs, double rhs ) {
        switch (op) {
            case 2:	return lhs + rhs;
            case 3: return lhs - rhs;
            case 4: return lhs * rhs;
            case 5: return lhs / rhs;
            default: return Double.NaN;
        }
    }

    //extract next value from remaining string
    static double value() throws IllegalArgumentException{
        double v = Double.NaN;
        if (s.charAt(pos) == '(') { //parentheses
            ++pos; //skip (
            v = value();
            if (pos >= s.length()) { //too less opening parentheses
                throw new IllegalArgumentException("Entsprechende Nachricht (mach Klammern du Vogel ->) sowas!");
            } else {
                v = expr( 0, v );
                ++pos; //skip )
            }
        } else if (s.charAt(pos) == '+') { //unary plus
            ++pos; //skip unary +
            v = value();
        } else if (s.charAt(pos) == '-') { //unary minus
            ++pos; //skip unary -
            v = -value();
        } else { //value
            //find next operand after value
            int posnextop = s.length();
            for (char c : operands.toCharArray()) {
                int i = s.indexOf(c, pos);
                if (i == -1)	i = s.length();
                posnextop = Math.min(posnextop, i);
            }
            //get value
            String number = s.substring(pos, posnextop);
            try{
                v = Double.parseDouble( number );
            }catch(NumberFormatException e){
                throw new IllegalArgumentException("Fehler: "+number + pos);
            }

            pos = posnextop;
        }
        return v;
    }

    //parse an expression
    static double expr( int leftOp, double lhs ) throws IllegalArgumentException{
        //evaluate operand s[pos] while it has higher precedence
        // than left operand
        for (int op = operands.indexOf(s.charAt(pos));
             prec[leftOp] < prec[op];
             op = operands.indexOf(s.charAt(pos))) {
            ++pos; //skip operand
            double rhs = value(); //get value right of op
            rhs = expr( op, rhs ); //get value of right expression
            lhs = eval( op, lhs, rhs ); //compute operand with
            //left and right side
        }
        return lhs;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner( System.in );
        try{
            s = "(" + scanner.nextLine() + ")";

            s = s.replace(" ", ""); ///<Fixed gefälligst euren sch*** Code selber!

            System.out.print(s);

            double v = value();
            if (pos != s.length()) {
                System.out.println("Zu wenige schließende Klammern");
            } else {
                System.out.println("Ergebnis: " + v);
            }
        }catch(IllegalStateException e){
            System.out.println("Das ist eine Fehlermeldung!");
        }catch (IllegalArgumentException e){
            System.out.print("Fehler: " + e.toString());
        }
    }
}


