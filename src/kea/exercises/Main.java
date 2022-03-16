package kea.exercises;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main
{

    private static final File SourceTextFile = new File("src/Source.txt");
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args)
    {
        int choice;
        System.out.println("\nProgram to read N characters from file.");
        boolean running = true;
        while (running)
        {
            System.out.println("""
                    Main menu:
                    1. Get 7 characters
                    2. Get N characters
                                        
                    0. Exit
                    """);
            choice = getValidInt(2);
            switch (choice)
            {
                case 0 -> running = false;
                case 1 -> read7();
                case 2 -> getN();
            }
        }
    }

    public static void getN() {
        System.out.print("How many characters to read? ");
        int choice = getValidInt(1000);
        System.out.println("The " + choice + " characters are: '" + readN(choice) + "'");
    }

    public static int getValidInt(int max)
    {
        int choice;
        while (true)
        {
            try
            {
                choice = sc.nextInt();
                if (choice <= max && choice >= 0)
                {
                    break;
                } else
                {
                    System.out.println("Only accepts integers between 0 and " + max);
                }
            } catch (InputMismatchException e)
            {
                System.out.println("Only accepts integers.");
                sc.nextLine();
            }
        }
        sc.nextLine();
        return choice;
    }

    public static void read7()
    {
        System.out.println("The 7 characters are: '" + readN(7) + "'");
    }

    public static String readN(int n)
    {
        int count = 0;
        StringBuilder chars = new StringBuilder();
        try
        {
            FileInputStream fis = new FileInputStream(SourceTextFile);
            while (fis.available() > 0)
            {
                if (count >= n)
                {
                    break;
                } else
                {
                    chars.append((char) fis.read());
                    count++;
                }
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        return chars.toString();
    }
}
