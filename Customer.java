package com.shihab;

import java.util.ArrayList;

public class Customer {

    // variable property with array list
    private ArrayList <CustomerData> customerData;



    // Constructor
    public Customer() {
        this.customerData = new ArrayList<>();

    }

    // Getter
    public ArrayList<CustomerData> getCustomerData() {
        return customerData;
    }

    // Methods
    public void openBankAccount(CustomerData data){
        customerData.add(data);
    }
    public int getTotalAccount(){
        return customerData.size();
    }
    public void removeAccount(int index){
        customerData.remove(index);
    }

    // methods with return type CustomerData
    public CustomerData searchAccount(String account){
        for (CustomerData customer: customerData) {
            if (customer.getAccountNumber().equalsIgnoreCase(account)){
                return customer;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerData=" + customerData +
                '}';
    }
}
