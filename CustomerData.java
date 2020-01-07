package com.shihab;

public class CustomerData implements SavingsAccount {
// variable Properties
    private String name;
    private String address;
    private String phoneNumber;
    private String date;
    private long nationalIDNumber;
    private double balance;
    private String emailAddress;
    private String accountNumber;

    public CustomerData() {
        // Empty Constructor to do work from another without taking any variable.
    }

    public CustomerData(String name, String address, String phoneNumber, String date, long nationalIDNumber,
                        double balance, String accountNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.date = date;
        this.nationalIDNumber = nationalIDNumber;
        this.balance = balance;
        this.emailAddress = null; // Constructor without asking email address
        this.accountNumber = accountNumber;
    }

    public CustomerData(String name, String address, String phoneNumber, String date, long nationalIDNumber, double balance,
                        String emailAddress, String accountNumber) { // to take all variables or properties
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.date = date;
        this.nationalIDNumber = nationalIDNumber;
        this.balance = balance;
        this.emailAddress = emailAddress;
        this.accountNumber = accountNumber;
    }

    // Getter for all properties to get access from another class
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getDate() {
        return date;
    }

    public long getNationalIDNumber() {
        return nationalIDNumber;
    }

    public double getBalance() {
        return balance;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getAccountNumber(){
        return accountNumber;
    }

    /* implement deposit method from Saving Account it will add new
    amount with the existing balance and give us total amount.*/
    @Override
    public void deposit(String date, double amount) {
        if (amount > 0){
            balance = balance + amount;
            System.out.println("In this date: " + date + " your deposit is : " + amount + " now your total amount is : " + balance);
        } else {
            System.out.println("Please enter positive amount of money.");
        }
    }

    /* withdraw method will record about how much money
    withdraw from the account and now how much we have in account */
    @Override
    public void withdraw(String date, double amount) {

        if (balance - accountSecurity < amount) {
            System.out.println("Sorry, Your balance is insufficient");
            double total = balance - accountSecurity;
            System.out.println("You have: " + accountSecurity + " account Security after that now you have : " + total);
        } else {
            balance = balance - amount;
            System.out.println("In this date: " + date + " after withdraw: " + amount +
                    " amount, now you have: " + balance);
        }

    }

    // implement calculateInterest method from Saving Account it will give you information about getting interest or not.
    @Override
    public void calculateInterest(double interestRate) {
        if (balance > 5000){
            double interestAmount = balance * interestRate;
            double totalBalance = balance + interestAmount;
            System.out.println("Congratulation! You will get " +interestRate+ " % of interest on Amount of " + balance +
                    ". Now your Total Balance with interest is : " + totalBalance);
        }
        else {
            System.out.println("Sorry! You will not get any interest.");
        }
    }

    // toString method to know what i did in this class
    @Override
    public String toString() {
        return "CustomerData{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", date='" + date + '\'' +
                ", nationalIDNumber=" + nationalIDNumber +
                ", Balance=" + balance +
                ", emailAddress='" + emailAddress + '\'' +
                '}';
    }
}
