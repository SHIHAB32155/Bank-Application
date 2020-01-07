package com.shihab;

import java.util.ArrayList;
import java.util.Scanner;

public class Bank {
    private Scanner scanner = new Scanner(System.in);

    // this method to know the available option can process
    public void bankOption(){
        System.out.println("This is your Process list: ");
        System.out.println("1. Please Open Bank Account");
        System.out.println("2. Deposit Amount.");
        System.out.println("3. Withdraw Amount.");
        System.out.println("4. Calculate Interest.");
        System.out.println("5. Search Bank Account.");
        System.out.println("6. Check Balance.");
        System.out.println("7. Get All Account.");
        System.out.println("8. Closed Account.");
        System.out.println("9. Exit.");
        System.out.println("........................................................");
        System.out.print("Please enter your choice: ");
    }

     /*this method to open new Bank Account with return type CustomerData.
     it will take data input from the user.*/
    public CustomerData openNewBankAccount(){
       // scanner.nextLine();
        String name, address, phone, date, email, account;
        double amount;
        long NID;
        CustomerData data;

        System.out.println("Please input your information: ");

        System.out.print("Please write your name: ");
        name = scanner.nextLine();

        System.out.print("Please write your Address: ");
        address = scanner.nextLine();

        System.out.print("Please write your Phone Number: ");
        phone = scanner.nextLine();

        System.out.print("Please write today date: ");
        date = scanner.nextLine();

        System.out.print("Please write your AccountNumber: ");
        account = scanner.nextLine();

        System.out.print("Please deposit your initial amount: ");
        amount = scanner.nextDouble();

        System.out.print("Please write your National ID Number: ");
        NID = scanner.nextLong();
        scanner.nextLine();

        System.out.print("Please enter you email address if you have (if not type N): ");
        email = scanner.nextLine();

        if (email.equalsIgnoreCase("N")){ // use condition to check email address is available or not
            data = new CustomerData(name, address, phone, date, NID, amount, account);
        }
        else {
            data = new CustomerData(name, address, phone, date , NID, amount, email, account);
        }

        return data;
    }

    // It will process deposit money if you have bank account
    public void depositAmount(Customer customer, Scanner scanner){
       scanner.nextLine();
        System.out.print("Please enter your account Number: ");
        String accountNumber = scanner.nextLine();

        CustomerData data = customer.searchAccount(accountNumber);

        if (data == null){ // check if you have account or not
            System.out.println("Sorry! account not found.");
        } else {
            // if you have account then you can proceed below data otherwise not.
            System.out.println("Yor are in your destination: You can proceed your deposit Activities: ");
            System.out.print("Please input your amount: ");
            double amount = scanner.nextDouble();
            scanner.nextLine();
            System.out.print("Please input today date: ");
            String date = scanner.nextLine();
            data.deposit(date, amount);
        }
    }

    // It will process withdraw money if you have bank account
    public void withdrawAmount(Customer customer, Scanner scanner){
        scanner.nextLine();
        System.out.print("Please enter your account Number: ");
        String accountNumber = scanner.nextLine();

        CustomerData data = customer.searchAccount(accountNumber);

        if (data == null){ // check account is available or not
            System.out.println("Sorry! account not found.");
        } else {
            // if you have account then you can proceed below data otherwise not.
            System.out.println("You are in your place: You can proceed your withdraw Activities: ");
            System.out.print("Please input your amount: ");
            double amount = scanner.nextDouble();
            scanner.nextLine();
            System.out.print("Please input today date: ");
            String date = scanner.nextLine();
            data.withdraw(date, amount);
        }
    }

    // It will calculate interest depends of account number and requirements
    public void interestCalculation(Customer customer, Scanner scanner){
        scanner.nextLine();
        System.out.print("Please enter your account Number: ");
        String accountNumber = scanner.nextLine();
        CustomerData data = customer.searchAccount(accountNumber);

        if (data == null){
            System.out.println("Sorry! account not found.");
        } else {
            System.out.println("Please check your interest amount Update: ");
            System.out.print("Please input interest Rate: ");
            double rate = scanner.nextDouble();
            data.calculateInterest(rate);
        }
    }

    // this method to Search specific bank Account to know the details
    public void searchAccount(Customer customer, Scanner scanner){
        scanner.nextLine();
        System.out.print("Please enter your account Number: ");
        String accountNumber = scanner.nextLine();

        CustomerData data = customer.searchAccount(accountNumber);

        if (data == null){
            System.out.println("Sorry! account not found.");
        } else {
            String email = data.getEmailAddress();
            System.out.println(String.format("%20s-%15s-%20s-%15s-%20s-%15s-%20s-%15s", data.getName(),
                    data.getAddress(), data.getPhoneNumber(), data.getDate(), data.getNationalIDNumber(),
                    data.getBalance(), email == null ? "N/A" : email, data.getAccountNumber()));
        }
    }

    // it will check your balance and give you information about your account balance
    public void checkBalance(Customer customer, Scanner scanner){
        scanner.nextLine();
        System.out.print("Please enter your account Number: ");
        String accountNumber = scanner.nextLine();

        CustomerData data = customer.searchAccount(accountNumber);

        if (data == null){
            System.out.println("Sorry! account not found.");
        } else {
            System.out.println("This is your account Balance Update: ");
            System.out.println("Your account Balance is: " + data.getBalance());
        }
    }

    // this method to show all available Bank accounts
    public void showAllAccount(ArrayList<CustomerData> customerData){
        System.out.println("All Accounts: ");

        System.out.println(".......................");
        int i = 0;
        for (CustomerData cd: customerData) {
            String email = cd.getEmailAddress();
            System.out.println(String.format("%15d-%20s-%15s-%20s-%15s-%20s-%15s-%20s-%15s", i++, cd.getName(),
                    cd.getAddress(), cd.getPhoneNumber(), cd.getDate(),
                    cd.getNationalIDNumber(), cd.getBalance(), email == null ? "N/A" : email, cd.getAccountNumber()));
        }
        System.out.println("..........................................................");
    }

    // Delete without any bank activity from long time
    public void closedAccount(Customer customer, Scanner scanner){
        showAllAccount(customer.getCustomerData());
        System.out.print("Please enter index number: ");
        int index = scanner.nextInt();

        customer.removeAccount(index);
        System.out.println("Successfully Remove with all existing data.");
    }
}
