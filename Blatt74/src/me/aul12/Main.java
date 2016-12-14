package me.aul12;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Program simulating a simple deterministic state machine.
 *
 * @author Paul Nykiel
 * @version 0.1
 */
public class Main {

    /**
     * Value representing if a transition is allowed.
     * @see Transition
     */
    enum ResultType{
        TRANSITION_OK, TRANSITION_WRONG
    }

    /**
     * Result of the Transiton check, contains the information if the transition is allowed
     * and the new state.
     * @see Transition
     */
    static class TransitionCheckResult {
        ResultType result;
        int nextState;

        /**
         * @param result validity of the transition
         * @param nextState next state of the state machine if result is ResultType.TRANSITION_OK
         */
        TransitionCheckResult(ResultType result, int nextState){
            this.result = result;
            this.nextState = nextState;
        }
    }

    /**
     * Object describing one transition.
     */
    static class Transition {
        int stateBegin = 0;
        int stateEnd = 0;
        char input = 'a';

        /**
         * @param stateBegin the state the state-machine has to be for the transition to be allowed
         * @param input the input the state machine has to get to be allowed to do the transition
         * @param stateEnd the state of the state machine after the transition
         */
        Transition(int stateBegin, char input, int stateEnd){
            this.stateBegin = stateBegin;
            this.input = input;
            this.stateEnd = stateEnd;
        }

        /**
         * Checks if a transition is valid
         * @param state current state of the state machine
         * @param input the input-character which should be checked
         * @return an TransitionCheckResult-Object
         * @see TransitionCheckResult
         */
        TransitionCheckResult check(int state, char input){
            if(state == stateBegin && input == this.input){
                return new TransitionCheckResult(ResultType.TRANSITION_OK, this.stateEnd);
            }else{
                return  new TransitionCheckResult(ResultType.TRANSITION_WRONG, 0);
            }
        }
    }

    /**
     * Recursively interprets the inputs of the state machine.
     * @param transitions An Array containing all possible Transitions
     * @param currState The current state of the state-machine
     * @param input A String containing all inputs
     * @return an integer which represents the state after all inputs have been interpreted,
     *          if a wrong input have been entered it returns -1
     */
    private static int doTransition(Transition transitions[], int currState, String input){
        if(input.length() <= 0){
            return currState;
        }else{
            for (Transition transition : transitions) {
                TransitionCheckResult checkResult = transition.check(currState, input.charAt(0));
                if (checkResult.result == ResultType.TRANSITION_OK) {
                    return doTransition(transitions, checkResult.nextState, input.substring(1));
                }
            }
        }

        return -1;
    }

    /**
     * Reads the properties and the input of the state machine from the stdin.
     * @param args not used
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

	    int state = 0;
        int transitionN = 0, stateN = 0;

        try {
            stateN = scanner.nextInt();
            transitionN = scanner.nextInt();
        }catch (InputMismatchException e){
            System.out.println(e.toString());
            scanner.nextLine();
        }

        Transition transitions[] = new Transition[transitionN];

        for(int c=0; c<transitionN; c++){
            try {
                int begState = scanner.nextInt();
                String input = scanner.next();
                int endState = scanner.nextInt();

                transitions[c] =
                        new Transition(begState, input.charAt(0), endState);
            }catch (InputMismatchException e){
                System.out.println(e.toString());
                System.out.println("Please reenter your input!");
                scanner.nextLine();
                c--;
            }

        }

        String input = scanner.next();

        state = doTransition(transitions, state, input);

        System.out.printf("Zustand nach Verarbeitung: %d", state);
        if(state == stateN-1)
            System.out.print("\nEndzustand erreicht");

    }
}