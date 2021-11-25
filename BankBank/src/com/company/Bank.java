package com.company;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    //CONSTRUCTOR
    public Bank(){
        customers = new ArrayList<>();
    } //HÄR UTFÖR JAG LAGRINGEN

    //STATE
    private List<Customer> customers; //DETTA SKAPAR MÖJLIGHET ATT LAGRA COSTUMERS I EN LIST

    //BEHAVIOUR
    public List<String> GetCustomer(long personalNo){
        //This is a temp list that will be disposed after method execution is over
        List<String>temp = new ArrayList<>();

        var customerExists = getCustomerIndex(personalNo);
        if (customerExists != -1) {
            var customer = customers.get(customerExists);
            temp.add("Customer name: "+customer.getCustomerName()); //temp [0]
            //Konverterar min long till String
            temp.add("Customer personal number: "+String.valueOf(customer.getCostumerPersonalNo())); //temp [1]
            //Konverterar min int till String
            temp.add("Total Accounts: "+String.valueOf(customer.getCostumerAccounts().size())); //temp [2]

            temp.add("Account numbers: ");//temp [3]
        }else{
            temp.add("Customer not found");
        }
        return temp;
    }
    private int getCustomerIndex(long personalNo){
        int custIndex = -1;
        for (var customer : customers) {
            if (customer.getCostumerPersonalNo() == personalNo)
            {
                // If customer is found by a personalNo
                //Get its INDEX property
                custIndex = customers.indexOf(customer);
            }
        }
        return custIndex;
    }
    public void addCustomer(Customer c){
        customers.add(c);
    }
    public  void addAccount(long personalNo){
        //doesCustomerExist(personalNo);
        var customerExists = getCustomerIndex(personalNo);
        if (customerExists != -1) {
            var customer = customers.get(customerExists);
            customer.addAccount(new Account());
            System.out.println("New account created for customer: "+customer.getCustomerName());
            System.out.println("*******************************************************");

        }else{
            System.out.println("The customer was not found");
        }

    }
    public List<String> getCostumerAccounts(long personalNo){
        List<String> accountsInformation = new ArrayList<>();
        for (var customer : customers) {
            if (customer.getCostumerPersonalNo() == personalNo)
            {
                //Sparar min List of Account hos en person i var "accounts".
                var accounts = customer.getCostumerAccounts();
                for (var account : accounts) {
                    var accountNo = account.getCustomerAccountNo().toString();
                    accountsInformation.add(accountNo);
                }
             //Sparar min get-metod i "acc"
                var acc = accounts.get(0);
                //Konverterar min acc till String i denna metod.
                var accountNo=acc.getCustomerAccountNo().toString();
                accountsInformation.add(accountNo);
            }
        }
        return accountsInformation;
    }
    public void changeCustomerName(String name, Long personalNo){
        for (var item : customers){
            if (personalNo == item.getCostumerPersonalNo());
            item.setCustomerName(name);
        }
    }
    public void removeAccount (int accIndex, long personalNo){
        for (var item : customers){
            if(personalNo == item.getCostumerPersonalNo()) {
                System.out.println(item.getCustomerName() + " - Removed account number: " + (accIndex));
                item.removeCustomerAccount(accIndex);

            }
        }
    }
    public void removeCustomer(long personalNo){
        for (var item : customers){
            if (personalNo == item.getCostumerPersonalNo()){
                customers.remove(getCustomerIndex(personalNo));
                break;
            }
        }
    }
    public void bankDeposit(long pNr, int indexNum, int num){
        for (var item: customers){
            if (pNr == item.getCostumerPersonalNo()){
                item.deposit(indexNum, num);
                System.out.println(item.getCustomerName() + " Deposited: " + num + " to account number: " + indexNum);
            }
        }
    }
    public void bankWithdraw(long pNr, int indexNum, int num){
        for (var item: customers){
            if (pNr == item.getCostumerPersonalNo()){
                item.withdraw(indexNum, num);
            }
        }
    }




/*  public List<String> GetCustomers()
    public boolean AddCustomer(String name, long pNr)
    public List<String> GetCustomer(long pNr)
    public boolean ChangeCustomerName(String name, long pNr)
    public List<String> RemoveCustomer(long pNr)
    public int AddAccount(long pNr)
    public String GetAccount(long pNr, int accountId)
    public boolean Deposit(long pNr, int accountId, int amount)
    public boolean Withdraw(long pNr, int accountId, int amount)
    public String CloseAccount(long pNr, int accountId)*/

    @Override
    public String toString() {
        return "Bank Costumers: " + customers +
                '}';
    }
}