package tests.practice;

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
