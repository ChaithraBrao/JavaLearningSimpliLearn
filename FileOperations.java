package com.fileOp;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileOperations {

    /*Created on 1-10-2022*/

    /*The Program to perform File operations
    File creation
    File Deletion
    File Search
    Display the files present
    */
    /*
    * Created by: Chaithra. B
    * Creator Email: Chaithra.B.Vinay@gmail.com
    * Application: File Operations
     */
    static String path = "E:\\SimpliLearnPhase1Project\\FileOperations\\Files\\";
    public static void main(String[] args) throws IOException {
        System.out.println("********** WELCOME *********");
        System.out.println("********** File Operations *********");

        Scanner sc = new Scanner(System.in);
        String option;
        boolean run = true;

        while (run) {
            DisplayMenu();
            System.out.println("Enter your option : ");
            option = sc.next();
            switch (option) {
                case "1":
                    DisplayFiles(path);
                    run = true;
                    break;
                case "2":
                    fileOperationOptions();
                    run = true;
                    break;
                case "3":
                    System.exit(0);
                default:
                    System.out.println("Invalid option");
                    run = true;
                    break;
            }
        }
    }

    public static void DisplayMenu() {
        System.out.println("Choose Options");
        System.out.println("1. Display files");
        System.out.println("2. File Operations");
        System.out.println("3. Exit");
    }

    public static void FileOperationMenu() {
        System.out.println("Choose the Operation");
        System.out.println("1. Create File");
        System.out.println("2. Delete File");
        System.out.println("3. Search File");
        System.out.println("4. Exit");
    }

    public static void fileOperationOptions() throws IOException {
        boolean run = true;
        String option;
        Scanner scanner = new Scanner(System.in);
        while (run){
            FileOperationMenu();
            System.out.println("Enter your option : ");
            option = scanner.next();
            switch (option) {
                case "1":
                    CreateFile(path);
                    run = true;
                    break;
                case "2":
                    DeleteFile(path);
                    run = true;
                    break;
                case "3":
                    SearchFile(path);
                    run = true;
                    break;
                case "4":
                    run = false;
                    break;
                default:
                    System.out.println("Invalid option");
                    run = true;
                    break;
            }
        }
    }
    public static void DisplayFiles(String path) {
        System.out.println("Displaying files from path --> "+path);
        File file = new File(path);
        File fileNames[]=file.listFiles();
        if(fileNames.length==0){
            System.out.println("No files exists in "+path);
        }
        else {
            for (File ff : fileNames) {
                System.out.println(ff.getName());
            }
        }
    }

    public static void CreateFile(String path) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the file name -- > ");
        String fileName = scanner.next();
        System.out.println("Creating file --> "+(path+fileName));

        File file = new File(path+fileName);
        boolean b = file.createNewFile();
        if(b!=true)
            System.out.println("File NOT created");
        else
            System.out.println("File created in "+path);
    }

    public static void DeleteFile(String path) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the file name to be deleted --> ");
        String fileName = scanner.next();
        System.out.println("Deleting file --> "+(path+fileName));
        File file = new File(path+fileName);
        boolean b = file.delete();
        if(b==true)
            System.out.println("File got deleted");
        else
            System.out.println("Problem in Deleting!! File Not Found");
    }

    public static void SearchFile(String path) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the file name to be searched --> ");
        String fileName = scanner.next();
        System.out.println("Searching file --> "+(path+fileName));
        File file = new File(path);
        boolean found=false;
        File fileNames[]=file.listFiles();
        for (File fn: fileNames){
            if(fileName.equals(fn.getName())){
                found = true;
                break;
            }
            else
                found = false;
        }

        if (found)
            System.out.println(fileName+ " Found !!");
        else
            System.out.println(fileName+ " File NOT Found !!");

    }
}
