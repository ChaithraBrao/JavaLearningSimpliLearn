package com.simpliLearn.first;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidation {

    public static void main(String[] args) {

        //Initialize 10 Sample email Ids
        String EmailIds[] = {
                "a1@mail.com",
                "b2@mail.com",
                "c3@mail.com",
                "d4@mail.com",
                "e5@mail.com",
                "f6@mail.com",
                "g7@mail.com",
                "h8@mail.com",
                "i9@mail.com",
                "j10@mail.com"
        };
        boolean found = false;
        int pos = 0;

        //Scanner to get user input
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the valid Email ID: ");
        String searchEmail = sc.nextLine();


        //Validation
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$");
        Matcher matcher = pattern.matcher(searchEmail);

        //If Email ID pattern is valid, search for the ID in an array.
        if (matcher.matches()) {
            System.out.println("Searching for " + searchEmail + " .....");

            //For loop to Search for email ID in an array
            for (String EmailId : EmailIds) {
                if (EmailId.equalsIgnoreCase(searchEmail)) {
                    found = true;
                    pos = Arrays.asList(EmailIds).indexOf(EmailId);
                    break;
                } else {
                    found = false;
                }
            }
            if(found)
                System.out.println(searchEmail + " found" + " at position : "+(pos+1));
            else
                System.out.println(searchEmail + " Not Found !!");
        }

        //Else --> Invalid Email ID Pattern
        else
            System.out.println("Invalid Email ID, Please Enter the valid Email ID.");
    }
}
