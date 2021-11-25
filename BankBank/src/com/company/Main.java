package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Account> costumerAccounts = new ArrayList<>();

        Bank b1 = new Bank();
        //ADD CUSTOMERS
        b1.addCustomer(new Customer("Zlatan Ibrahimovic", 8110031111L));
        b1.addAccount(8110031111L);
        b1.addAccount(8110031111L);

        b1.addCustomer(new Customer("Ismail Güven", 9102212222L));
        b1.addAccount(9102212222L);
        b1.addAccount(9102212222L);
        b1.addAccount(9102212222L);

        b1.addCustomer(new Customer("Maria Güven", 8701213333L));
        b1.addAccount(8701213333L);

        b1.addCustomer(new Customer("Elon Musk", 7106284444L));
        b1.addAccount(7106284444L);



        //STORE EACH CUSTOMER AND PRINT
        System.out.println("LIST OF CUSTOMERS TO THE BANK");
        var customerInfo1 = b1.GetCustomer(8110031111L);
        System.out.println(customerInfo1.get(0));
        System.out.println(customerInfo1.get(1));
        System.out.println(customerInfo1.get(2));
        System.out.println(customerInfo1.get(3));
        System.out.println("*******************************************************");

        var customerInfo3 = b1.GetCustomer(8701213333L);
        System.out.println(customerInfo3.get(0));
        System.out.println(customerInfo3.get(1));
        System.out.println(customerInfo3.get(2));
        System.out.println("*******************************************************");

        var customerInfo4 = b1.GetCustomer(7106284444L);
        System.out.println(customerInfo4.get(0));
        System.out.println(customerInfo4.get(1));
        System.out.println(customerInfo4.get(2));
        System.out.println("*******************************************************");

        var customerInfo2 = b1.GetCustomer(9102212222L);
        System.out.println(customerInfo2.get(0));
        System.out.println(customerInfo2.get(1));
        System.out.println(customerInfo2.get(2));
        System.out.println("*******************************************************");

        //CHANGE NAME OF A COSTUMER
        //b1.changeCustomerName("Zello Güven", 9102212222L);

        System.out.println("Overall information about this customer: " + b1.GetCustomer(9102212222L));
        System.out.println("Account numbers for this customer: " + b1.getCostumerAccounts(9102212222L));

        System.out.println("*******************************************************");
        b1.bankDeposit(9102212222L,1,500);
        b1.bankDeposit(7106284444L,1,700);
        b1.bankDeposit(8110031111L,1,1224);
        b1.bankDeposit(8701213333L,1,4222);
        System.out.println("*******************************************************");
        b1.bankWithdraw(9102212222L,1,7500);
        b1.bankWithdraw(8110031111L,1,5432);
        b1.bankWithdraw(8701213333L,1,1254);
        b1.bankWithdraw(7106284444L,1,2254);





        //b1.removeAccount(1, 9102212222L);
        //System.out.println("Account removed :" + b1.getCostumerAccounts(9102212222L));

        //b1.removeCustomer(9102212222l);
        //System.out.println(b1.getCostumerAccounts(9102212222L));
    }
}