package com.simpliLearn.first;

import java.util.Scanner;

public class Calculater {

    public static void main (String a[]){
        int num1;
        int num2;
        int result;
        char op;
        char cont;
        System.out.println("****Welcome to simple calculator******");
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Please Enter the first number :");
            num1 = sc.nextInt();
            System.out.println("Please Enter the second number :");
            num2 = sc.nextInt();
            System.out.println("Please Enter the Operator :");
            op = sc.next().charAt(0);

            switch (op) {
                case '+':
                    result = num1 + num2;
                    System.out.println(num1 + " + " + num2 + " = " + result);
                    break;

                case '-':
                    result = num1 - num2;
                    System.out.println(num1 + " - " + num2 + " = " + result);
                    break;

                case '/':
                    if (num2 == 0)
                        System.out.println("Invalid input");
                    else {
                        result = num1 / num2;
                        System.out.println(num1 + " / " + num2 + " = " + result);
                    }
                    break;

                case '*':
                    result = num1 * num2;
                    System.out.println(num1 + " * " + num2 + " = " + result);
                    break;

                default:
                    System.out.println("Please enter valid operator");
                    System.out.println(" + for Addition, - for Subtraction, * for multiplication and / for division");
            }
            System.out.println("Please Enter the Y to continue :");
            cont = sc.next().charAt(0);
            if ((cont=='Y')||(cont=='y'))
            {
                //System.out.println("Continue "+cont);
                continue;
            }
            else {
                System.out.println("*********Thank you*******");
                break;
            }
        }


    }
}
