package com.tests.practice;

import com.google.gson.internal.bind.util.ISO8601Utils;

import java.util.Scanner;

public class mainCustomer {

    public static void main(String[] args) {
        bankAccount mybank = new bankAccount();
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter Your Use Name");
        String enteredName = scan.next();
        System.out.println(enteredName.equals(mybank.getPassword())?mybank.getAccnum():"Wrong Password");



    }

}
