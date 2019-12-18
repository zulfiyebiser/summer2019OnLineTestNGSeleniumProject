package tests.Nurullah;

public class Account {
    // instance variables(fields)
    private  int number;
    private double balance;
    private String CustomerName;
    private String emailAdress;
    private String phoneNumber;

// Constructor are automatic initialize
    public Account(){
        System.out.println("empty constructer is called");
    }

    public Account(int number,double balance,String CustomerName,String emailAdress,String phoneNumber){
        System.out.println("second constructor called");
        this.number = number;
        this.balance = balance;
        this.CustomerName = CustomerName;
        this.emailAdress = emailAdress;
        this.phoneNumber = phoneNumber;

    }


    public void depositMoney(double amount){
        //this.balance = this.balance+amount;
        this.balance+=amount;
        System.out.println("Amount of "+ amount+ "$ is deposited.");
        System.out.println("New Balance is "+ this.balance);
    }
    public  void WithDraw(double amount){
        double temproraryBalance = this.balance -amount;
        if(temproraryBalance <0){
            System.out.println("Insufficient funds");
        }else{
            this.balance = this.balance-amount;
        }
        System.out.println("Amount of "+amount+" $ is withdrawn");
        System.out.println("New Bance is "+this.balance);
    }


    // I should be able to reach my private data to create getter and setter methods
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public String getEmailAdress() {
        return emailAdress;
    }

    public void setEmailAdress(String emailAdress) {
        this.emailAdress = emailAdress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
//        if(phoneNumber.length()<12||phoneNumber.length()>12){
//            System.out.println("Wrong format");
//        }else{  ==>we can put any limitation
            this.phoneNumber = phoneNumber;
        //}

    }
}
