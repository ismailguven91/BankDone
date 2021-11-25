package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Customer {

    //CONSTRUCTOR
    public Customer(String Name, Long personalNo){
        customerName = Name;
        customerPersonalNo = personalNo;
        customerAccounts=new ArrayList<>();
    }

    //STATE
    private String customerName;
    private long customerPersonalNo;
    private List<Account> customerAccounts;

    //BEHAVIOUR
/*    public void removeAccout (Account account){
        customerAccounts.remove(account);
    }*/
    public void addAccount(Account account){
        customerAccounts.add(account);
    }
    public String getCustomerName() {
        return customerName;
    }
    public long getCostumerPersonalNo() {
        return customerPersonalNo;
    }
    public List<Account> getCostumerAccounts() {
        return customerAccounts;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public void removeCustomerAccount (int accIndex){
        customerAccounts.remove(accIndex);
    }
    public void deposit(int indexNum, int num){
        customerAccounts.get(indexNum-1).depositCash(num);
    }
    public void withdraw(int indexNum, int num){
        for (var item : customerAccounts){
            if (num <= item.getCustomerBalance()){
                customerAccounts.get(indexNum-1).withdrawCash(num);
                System.out.println(getCustomerName()+" Withdraw: "+num + " from account number: "+indexNum);
                break;
            }
            else System.out.println("Invalid amount");
        }
    }


    @Override
    public String toString() {
        return "Costumer{" +
                "costumerName='" + customerName + '\'' +
                ", costumerPersonalNo=" + customerPersonalNo +
                '}';
    }


}





//METHODS AND FUNCTIONS
//TODO: GET INFO OF COSTUMER (NAME,PERSONAL NO & INFO ABOUT COSTUMER ACCOUNTS)
//TODO: CHANGE INFO OF COSTUMER (NAME AND PERSONAL NO)
//TODO: SHOW LIST OF COSTUMER ACCOUNTS
//TODO: