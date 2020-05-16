package com.bankchallenge;


public class Main {

    public static void main(String[] args) {

        Bank bank = new Bank("Capsule Corp Banking");

        if(bank.addBranch("West")){
            System.out.println("West branch created.");
        }

        bank.addCustomer("West", "Goku", 50.50);
        bank.addCustomer("West", "Vegeta", 50.49);
        bank.addCustomer("West", "Buu", 3.12);

        bank.addBranch("North");
        bank.addCustomer("North", "Yamcha", 0.01);

        bank.addCustomerTransaction("West", "Goku", 7.77);
        bank.addCustomerTransaction("West", "Goku", 77.77);
        bank.addCustomerTransaction("West", "Vegeta", 13.02);

        bank.listCustomers("West", true);
        bank.listCustomers("North", true);

        bank.addBranch("East");

        if(!bank.addCustomer("East", "Krillin", 5.33)) {
            System.out.println("Error: East branch does not exist.");
        }

        if(!bank.addBranch("East")) {
            System.out.println("Error: East branch already exists.");
        }

        if(!bank.addCustomerTransaction("West", "Puar", 22.22)){
            System.out.println("Customer does not exist at this branch.");
        }

        if(!bank.addCustomer("West", "Goku", 12.21)){
            System.out.println("Customer Goku already exists.");
        }

    }
}