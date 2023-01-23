package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    private static List<String[]> customerData = Arrays.asList(
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"},
            new String[] {"2","Daily Planet","-7500","01-10-2022"},
            new String[] {"1","Wayne Enterprises","18000","12-22-2021"},
            new String[] {"3","Ace Chemical","-48000","01-10-2022"},
            new String[] {"3","Ace Chemical","-95000","12-15-2021"},
            new String[] {"1","Wayne Enterprises","175000","01-01-2022"},
            new String[] {"1","Wayne Enterprises","-35000","12-09-2021"},
            new String[] {"1","Wayne Enterprises","-64000","01-17-2022"},
            new String[] {"3","Ace Chemical","70000","12-29-2022"},
            new String[] {"2","Daily Planet","56000","12-13-2022"},
            new String[] {"2","Daily Planet","-33000","01-07-2022"},
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"},
            new String[] {"2","Daily Planet","33000","01-17-2022"},
            new String[] {"3","Ace Chemical","140000","01-25-2022"},
            new String[] {"2","Daily Planet","5000","12-12-2022"},
            new String[] {"3","Ace Chemical","-82000","01-03-2022"},
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"}

    );

    public static void main(String[] args) {
        //Making a List of customer objects
        List<Customer> customerDataList = new ArrayList<Customer>();

        //A list of the names that get added to the customerDataList.
        List<String> names = new ArrayList<String>();

        //Traverse the customerData
        for(String[] currCustomer : customerData){
            //Making an accountRecord and seeing the charge and charge date. Date is index 3 and charge is index 1
            AccountRecord currAccountRecord = new AccountRecord();
            currAccountRecord.setCharge(Integer.parseInt(currCustomer[2]));
            currAccountRecord.setChargeDate(currCustomer[3]);

            //Now need to make a Customer and make it have this account reccord
            if(!names.contains(currCustomer[1])){
                Customer theCustomer = new Customer();
                theCustomer.setId(Integer.parseInt(currCustomer[0]));
                theCustomer.setName(currCustomer[1]);
                theCustomer.getCharges().add(currAccountRecord);
                customerDataList.add(theCustomer);
                //adding the customer name
                names.add(currCustomer[1]);
            }else{
                //The name has already been seen, just add a charge to it

                //Look for customer since it exits in database I made
                for(Customer curr: customerDataList){
                    //find the customer
                    if(curr.getName().equals(currCustomer[1])){
                        //add that charge to the customer
                        curr.getCharges().add(currAccountRecord);
                    }
                }
            }

        }

        //Update this
        System.out.println("Positive accounts:");
         //Traverse through the customerDataList and if getBalance is pos print in
        for(Customer currCustomer: customerDataList){
            if(currCustomer.getBalance() >=0){
                System.out.println(currCustomer.toString());
            }
        }
        System.out.println("Negative accounts:");
        //Traverse through the customerDataList and if getBalance is pos print in
        for(Customer currCustomer: customerDataList){
            if(currCustomer.getBalance() <0){
                System.out.println(currCustomer.toString());
            }
        }
    }
}
