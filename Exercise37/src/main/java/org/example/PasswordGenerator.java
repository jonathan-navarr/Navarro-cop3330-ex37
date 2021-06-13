package org.example;
import java.util.Scanner;
import java.util.Random;
import java.util.*;
/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Jonathan Navarro
 */
public class PasswordGenerator {
    public static void main(String[] args){
        Scanner scnr = new Scanner(System.in);
        int size, special, numbers;

        System.out.print("What's the minimum length? ");
        size = scnr.nextInt();

        System.out.print("How many special characters? ");
        special = scnr.nextInt();

        System.out.print("How many numbers? ");
        numbers = scnr.nextInt();

        System.out.println("Your password is " + generatePassword(size, special, numbers));
    }

    public static String generatePassword(int length, int special, int nums)
    {
        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

        String specialCharacters = "!@#$%^&*";

        String numbers = "1234567890";

        Random rndm = new Random();

        ArrayList<Character> chars = new ArrayList<>();

        for(int i=0; i<special; i++){
            chars.add(specialCharacters.charAt(rndm.nextInt(specialCharacters.length())));
        }

        for(int i=0; i<nums; i++){
            chars.add(numbers.charAt(rndm.nextInt(numbers.length())));
        }

        for(int i=chars.size()-1; i<length; i++){
            chars.add(letters.charAt(rndm.nextInt(letters.length())));
        }

        Collections.shuffle(chars);

        String password = "";

        for(Character s : chars)
        {
            password += Character.toString(s);
        }

        return password;
    }
}
