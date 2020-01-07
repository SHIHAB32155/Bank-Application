package com.shihab;

import java.util.Scanner;

public class BankApplication {

    public static void main(String[] args) {

        Bank bank = new Bank();
        CustomerData data = new CustomerData();
        Customer customer = new Customer();
        Scanner scanner  = new Scanner(System.in);
        int number = 0;

        do {
            bank.bankOption();
            number = scanner.nextInt();

            switch (number) {
                case 1 :
                    data = bank.openNewBankAccount();
                    customer.openBankAccount(data);
                    System.out.println("Account opened successfully...");
                    System.out.println();
                    break;

                case 2:
                    bank.depositAmount(customer, scanner);
                    break;

                case 3:
                    bank.withdrawAmount(customer, scanner);
                    break;

                case 4:
                    bank.interestCalculation(customer, scanner);
                    break;

                case 5:
                    bank.searchAccount(customer, scanner);
                    break;

                case 6:
                   bank.checkBalance(customer, scanner);
                    break;

                case 7:
                    bank.showAllAccount(customer.getCustomerData());
                    int total = customer.getTotalAccount();
                    System.out.println("Total Accounts: " + total);
                    break;

                case 8:
                    bank.closedAccount(customer, scanner);
                    break;

                case 9:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Please try again...");

            }
        } while (true);

    }
}
