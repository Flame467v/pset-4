/**
 * Problem Set 4.
 *
 * It's time to put your skills to the test. This problem set focuses on using
 * iterative control structures. The `main` method is done for you. Lines 30-39
 * trigger each of the predefined methods, which you can think of as self-contained
 * executable pieces of logic. Write your code for each exercise in the
 * corresponding method.
 *
 * The specifications for each exercise are outlined below. Your job is to write
 * lines of code to produce answers to my questions. Each exercise requires that
 * you ask the user to enter one or more values. Your code must meet the
 * requirements set forth in this section (as well as the *Deliverables* section).
 *
 * Work through these exercises on your own. Experiment, make mistakes, ask
 * questions, and fix your mistakes. It's the only way to get good at programming.
 */

import java.util.Scanner;

public class ProblemSet4 {

    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        ProblemSet4 ps = new ProblemSet4();

        // comment out or uncomment as needed

       ps.sum();
       ps.reverse();
       ps.digits();
       ps.average();
       ps.prime();
       ps.fibonacci();
       ps.factors();
       ps.mario();
       ps.luigi();
       ps.credit();

       in.close();
    }

    /*
     * Exercise 1.
     *
     * Prompt the user to enter two integers. The first integer is a lower bound, and
     * the second integer is an upper bound.
     *
     * Compute the sum of all even integers between the lower and upper bounds,
     * including the bounds themselves.
     */

    public void sum() {

        long sum = 0;
        long lowerbound = 0;
        long upperbound = -1;

        System.out.println("");

        do  {
            System.out.print("Lower bound: ");
            lowerbound = in.nextLong();
            System.out.print("Upper bound: ");
            upperbound = in.nextLong();
        }
        while (lowerbound > upperbound);

        if ((lowerbound % 2) != 0) {
            lowerbound = lowerbound+1;
        }

        for (long i = lowerbound; i <= upperbound; i = i + 2) {
            sum += i;
        }

        System.out.printf("\n%,d.\n\n", sum);

    }

    /*
     * Exercise 2.
     *
     * Prompt the user to enter a positive integer. Print the digits of this integer
     * in reverse order.
     */

    public void reverse() {

        long integer;

        do  {
            System.out.print("Positive Integer: ");
            integer = in.nextLong();
        }
        while (integer < 1);


        String result = Long.toString(integer);
        System.out.print("\n");


        for (int i = result.length(); i > 0; i--) {

            if (i==1) {
                System.out.printf("%s.\n\n", result.substring(i-1, i));
            }
            else {
                System.out.printf("%s, ", result.substring(i-1, i));
            }
        }

    }

    /*
     * Exercise 3.
     *
     * Prompt the user to enter a positive integer. Compute the sum of all of the odd
     * digits in the integer.
     */

    public void digits() {

        long integer;
        int sum = 0;
        int add;

        do {
            System.out.print("Positive integer: ");
            integer = in.nextLong();
        }
        while (integer < 1);

        String result = Long.toString(integer);

        for (int i = result.length(); i > 0; i--) {

            add = Integer.parseInt(result.substring(i-1, i));
            if (add % 2 != 0) {
                sum += add;
            }
        }

        System.out.printf("\n%d.\n\n", sum);

    }

    /*
     * Exercise 4.
     *
     * Prompt the user to enter a series of non-negative integers. When the user
     * enters a negative integer, you can assume he or she is done entering values.
     * What is the average of the values entered?
     */

    public void average() {

        double integer;
        double total = 0;
        double count = 0;

        do {
            System.out.print("Non-negative integer: ");
            integer = in.nextLong();

            if (integer > 0) {
                total += integer;
                count++;
            }

        }
        while (integer >= 0);

        double average = total/count;
        System.out.printf("\n%,.2f.\n\n", average);

    }

    /*
     * Exercise 5.
     *
     * Prompt the user to enter a non-negative integer. Is this number prime?
     */

    public void prime() {

        boolean prime = true;
        long integer;

        do {
            System.out.print("Non-negative integer: ");
            integer = in.nextLong();

        }
        while (integer < 0);

        if (integer == 1) {
            prime = true;
        }
        else if (integer == 0) {
            prime = false;
        }

        for (int i = 2; i < integer; i++) {
            if (integer % i == 0 && integer != i) {
                prime = false;
            }
        }

        if (prime) {
            System.out.println("\nPrime.\n");
        }
        else {
            System.out.println("\nNot prime.\n");
        }

    }

    /*
     * Exercise 6.
     *
     * Prompt the user to enter a positive integer in the range [1, 92]. If the
     * integer the user enters is called n, what is the nth Fibonacci number?
     */

    public void fibonacci() {

        long integer;
        int prevint = 0;
        int currentint = 1;
        int nextint = 1;

        do {
            System.out.print("Positive integer: ");
            integer = in.nextLong();

        }
        while (integer < 1 || integer > 92);


        for (int i = 1; i < integer; i++) {
            nextint = prevint + currentint;
            prevint = currentint;
            currentint = nextint;
        }

        System.out.printf("\n%d.\n\n", nextint);

    }

    /*
     * Exercise 7.
     *
     * Prompt the user to enter a positive integer. What are its factors?
     */

    public void factors() {

        long integer;

        do
        {
            System.out.print("Positive integer: ");
            integer = in.nextLong();

        }
        while (integer < 1);

        System.out.printf("\n1, %d", integer);

        for (int i = 2; i <= integer/i; i++) {

            if (integer % i == 0) {
                System.out.printf(", %d, %d", i, integer/i);
            }

        }

        System.out.print(".\n\n");

    }

    /*
     * Exercise 8.
     *
     * Prompt the user to enter an integer between 1 and 24 (inclusive). Print a Super
     * Mario-style half-pyramid of the specified height.
     */

    public void mario() {

        long height;
        long numspaces = 0;

        do
        {
            System.out.print("Height: ");
            height = in.nextLong();

        }
        while (height < 1 || height > 24);

        System.out.print("\n");

        for (long i = 1; i <= height; i++) {

            for (long j = height-i; j > 0; j--) {
                System.out.print(" ");
                numspaces++;
            }

            for (long h = height+1-numspaces; h > 0; h--) {
                System.out.print("#");
            }

            System.out.print("\n");
            numspaces = 0;

        }

        System.out.print("\n");

    }

    /*
     * Exercise 9.
     *
     * Prompt the user to enter an odd integer between 1 and 24 (inclusive). Print a
     * Super Mario-style full pyramid of the specified height.
     */

    public void luigi() {

        long height;
        long numspaces = 0;
        long numhashes = 0;

        do
        {
            System.out.print("Height: ");
            height = in.nextLong();

        }
        while (height < 1 || height > 24);

        System.out.print("\n");

        for (long i = 1; i <= height; i++) {

            for (long j = height-i; j > 0; j--) {
                System.out.print(" ");
                numspaces++;
            }

            for (long h = height+1-numspaces; h > 0; h--) {
                System.out.print("#");
                numhashes++;
            }

            System.out.print("  ");

            for (long k = 0; k < numhashes; k++) {
                System.out.print("#");
            }

            System.out.print("\n");
            numspaces = 0;
            numhashes = 0;

        }

        System.out.print("\n");

    }

    /*
     * Exercise 10.
     *
     * Prompt the user to enter a credit card number (not a real one!). According to
     * Luhn's algorithm, is the credit card number valid?
     */

    public void credit() {

        String visa = "^4[0-9]{12}(?:[0-9]{3})?$";
        String master = "^5[1-5][0-9]{14}$";
        String express = "^3[47][0-9]{13}$";
        String ccn = "null";

   System.out.print("Number: ");
   ccn = in.next();

        if(ccn.matches(visa)){
              System.out.print("\nVisa.");
          }
        else if (ccn.matches(master)){
              System.out.print("\nMastercard.");
          }
        else if (ccn.matches(express)) {
              System.out.print("\nAmex.");
          }
          else {
          System.out.print("\nInvalid.");
        }

    }

}
