package tests.Nurullah;

public class Main {
    public static void main(String[] args) {


        Account newAccount = new Account();
//        newAccount.depositMoney(1000);
//        newAccount.WithDraw(100);
//        newAccount.WithDraw(50);
        newAccount.setBalance(100);
        newAccount.setCustomerName("zlf");
        newAccount.setEmailAdress("asb@nkj");
        newAccount.setNumber(12234);
        newAccount.setPhoneNumber("111 222 2222");
        // I can provide all the information with creating object with exist argument constructor

        Account secondAccount = new Account(122,222,"zlf","ajhsg@hh","333333333");
        System.out.println(secondAccount.getNumber());


        System.out.println(newAccount.getCustomerName());
        System.out.println(newAccount.getBalance());
        System.out.println(newAccount.getEmailAdress());
        System.out.println(newAccount.getPhoneNumber());
        System.out.println(newAccount.getNumber());
        // better and easier way

    }
}
