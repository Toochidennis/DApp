package database;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {



        solve(12, 20, 8);

         /*java.util.Random rand = new java.util.Random();
        int N = rand.nextInt(20) + 1;
        System.out.println( findNth(N));*/

        /*long [] arr = {34 ,1, 92, 10 ,3, 25 ,90 ,97 ,49 ,3, 67 ,66, 50 ,30, 7 ,4 ,96, 12 ,81, 10 ,1, 16 ,86, 80,89 ,77 ,50,
                23, 49, 80 ,56 ,70 ,75, 81, 88 ,1, 73 ,45, 76 ,57 ,81, 79 ,59 ,63, 40, 7, 33 ,19, 24,};
        int n = arr.length;
        System.out.println(smallestPositive(arr,n));
        */

        int num; double num2; String name;
        int i = 4; double d = 4.0; String s = "is a bad programmer";
        Scanner scan = new Scanner(System.in);
        /* Read and save an integer, double, and String to your variables.*/
        // Note: If you have trouble reading the entire String, please go back and review the Tutorial closely.
        num = scan.nextInt();
        num2 = scan.nextDouble();
        System.out.println("name");
        name = scan.nextLine();

        /* Print the sum of both integer variables on a new line. */
        System.out.println(num + i);

        /* Print the sum of the double variables on a new line. */
        System.out.println(num2 + d);
        /* Concatenate and print the String variables on a new line;
        	the 's' variable above should be printed first. */

        System.out.println(name +  s);

        scan.close();



    }

   static long findNth(long N){
       long result = 0;
        long position = 1;

        while(N>0){
            result += (position * (N%9));
            N /=9;
            position *=10;

        }
        return result;
    }

    static long smallestPositive(long[] array, int n) {
        // Your code goes here
        long res = 1;
        for (int i = 0; i < n && array[i] <= res; i++){
            res = res + array[i];

        }
        return res;
    }

    public static void solve(double meal_cost, int tip_percent, int tax_percent) {
        // Write your code here


    double tip =  (tip_percent * (meal_cost/100));

    double  tax = (tip_percent * ((double)tax_percent/100));

      double total_cost =  (meal_cost + tip + tax );

        System.out.println(Math.round(total_cost));


    }

}
