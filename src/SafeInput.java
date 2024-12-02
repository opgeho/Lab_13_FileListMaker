import java.util.Scanner;

public class SafeInput {

    /**
     * Gets a non-0 length string from user
     *
     * @param pipe   scanner to use to read the input
     * @param prompt prompt to tell the user what to input
     * @return String that is at least one character
     */
    public static String getNonZeroLenString(Scanner pipe, String prompt) {
        String retVal = "";

        do {
            System.out.println(prompt + ": ");
            retVal = pipe.nextLine();
            if (retVal.isEmpty()) {
                System.out.println("You must enter at least one character!");
            }
        } while (retVal.isEmpty());

        return retVal;
    }

    /**
     * Gets an unconstrained int value from the user
     *
     * @param pipe   Scanner to use for input
     * @param prompt prompt to tell the user what to input
     * @return an unconstrained int value
     */
    public static int getInt(Scanner pipe, String prompt) {
        int retVal = 0;
        String trash = "";
        boolean done = false;

        do {
            System.out.println(prompt + ": ");
            if (pipe.hasNextInt()) {
                retVal = pipe.nextInt();
                pipe.nextLine();
                done = true;
            } else {
                trash = pipe.nextLine();
                System.out.println("You must enter a valid input not " + trash);
            }
        } while (!done);

        return retVal;
    }

    /**
     * Gets an unconstrained double value from the user
     *
     * @param pipe   Scanner to use for input
     * @param prompt prompt to tell the user what to input
     * @return an unconstrained double value
     */
    public static double getDouble(Scanner pipe, String prompt) {
        double retVal = 0;
        String trash = "";
        boolean done = false;

        do {
            System.out.println(prompt + ": ");
            if (pipe.hasNextDouble()) {
                retVal = pipe.nextDouble();
                pipe.nextLine();
                done = true;
            } else {
                trash = pipe.nextLine();
                System.out.println("You must enter a valid Double not " + trash);
            }
        } while (!done);

        return retVal;
    }

    /**
     * Gets a constrained int value within a range
     * @param pipe Scanner to use for input
     * @param prompt Prompt to tell the user what to input
     * @param low int to set the low value for the range
     * @param high int to set the high value for the range
     * @return an int value within a set range
     */
    public static int getRangedInt(Scanner pipe, String prompt, int low, int high){
        int retVal = 0;
        String trash = "";
        boolean done = false;

        do {
            System.out.println(prompt + " (" + low + " to " + high + "): ");
            if (pipe.hasNextInt()){
                retVal = pipe.nextInt();
                pipe.nextLine();
                if (retVal >= low && retVal <= high){
                    done = true;
                }
                else {
                    System.out.println(retVal + " Is not a valid input.");
                }
            }
            else {
                trash = pipe.nextLine();
                System.out.println(trash + " Is not a valid input.");
            }

        } while (!done);

        return retVal;
    }
    /**
     * Gets a constrained double value within a range
     * @param pipe Scanner to use for input
     * @param prompt Prompt to tell the user what to input
     * @param low double to set the low value for the range
     * @param high double to set the high value for the range
     * @return a double value within a set range
     */
    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high){
        double retVal = 0;
        String trash = "";
        boolean done = false;

        do {
            System.out.println(prompt + " (" + low + " to " + high + "): ");
            if (pipe.hasNextDouble()){
                retVal = pipe.nextDouble();
                pipe.nextLine();
                if (retVal >= low && retVal <= high){
                    done = true;
                }
                else {
                    System.out.println(retVal + " Is not a valid input.");
                }
            }
            else {
                trash = pipe.nextLine();
                System.out.println(trash + " Is not a valid input.");
            }

        } while (!done);

        return retVal;
    }
    /**
     * Gets a boolean value from the user
     * @param pipe Scanner sued to detect user input
     * @param prompt Prompt to tell the user what to input
     * @return a boolean true false value
     */
    public static boolean getYNConfirm(Scanner pipe, String prompt){
        boolean retVal = false;
        String confirm = "";
        boolean done = false;
        do {
            System.out.println(prompt + "? [Y/N]");
            confirm = pipe.nextLine();
            if (confirm.equalsIgnoreCase("Y")){
                retVal = true;
                done = true;
            }
            else if (confirm.equalsIgnoreCase("N")){
                retVal = false;
                done = true;
            }
            else {
                System.out.println(confirm + " is not a valid input.");
            }
        } while (!done);
        return retVal;
    }

    /**
     * Gets a string following a regEx pattern from the user
     * @param pipe Scanner to detect user input
     * @param prompt prompt to tell the user what to input
     * @param regEx regEx pattern for the user to follow
     * @return a string following the regEx pattern
     */
    public static String getRegExString(Scanner pipe, String prompt, String regEx){
        String retVal = "";
        boolean done = false;
        do {
            System.out.println(prompt + " " + regEx + ": ");
            retVal = pipe.nextLine();
            if (retVal.matches(regEx)){
                done = true;
            }
            else{
                System.out.println("You must input a value that matches the pattern " + regEx + " not " + retVal);
            }
        } while (!done);
        return retVal;
    }

    /**
     * Prints a centered header for a given message
     * @param msg string to be made into header
     */
    public static void prettyHeader(String msg){
        int length = 54 - msg.length();
        int oddNum = length % 2;

        for (int s = 1; s <= 60; s++){
            System.out.print("*");
        }
        System.out.print("\n***");
        for (int m = 1; m <= length / 2; m++ ){
            System.out.print(" ");
        }
        System.out.print(msg);
        for (int m = 1; m <= length / 2; m++ ){
            System.out.print(" ");
        }
        if (oddNum == 1){
            System.out.print(" ");
        }
        System.out.println("***");
        for (int s = 1; s <= 60; s++){
            System.out.print("*");
        }
    }
}
