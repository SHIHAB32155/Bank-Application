package com.shihab;

public interface SavingsAccount {
    final double accountSecurity = 500;

    void deposit(String date, double amount);
    void withdraw(String date, double amount);
    void calculateInterest(double interestRate);
}
