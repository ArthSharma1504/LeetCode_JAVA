/*
860. Lemonade Change
Solved
Easy
Topics
Companies
At a lemonade stand, each lemonade costs $5. Customers are standing in a queue to buy from you and order one at a time (in the order specified by bills). Each customer will only buy one lemonade and pay with either a $5, $10, or $20 bill. You must provide the correct change to each customer so that the net transaction is that the customer pays $5.

Note that you do not have any change in hand at first.

Given an integer array bills where bills[i] is the bill the ith customer pays, return true if you can provide every customer with the correct change, or false otherwise.

 

Example 1:

Input: bills = [5,5,5,10,20]
Output: true
Explanation: 
From the first 3 customers, we collect three $5 bills in order.
From the fourth customer, we collect a $10 bill and give back a $5.
From the fifth customer, we give a $10 bill and a $5 bill.
Since all customers got correct change, we output true.
*/


class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;  // Count of $5 bills
        int ten = 0;   // Count of $10 bills
        
        for (int bill : bills) {
            if (bill == 5) {
                // Customer pays with $5, no change required
                five++;
            } else if (bill == 10) {
                // Customer pays with $10, need to give back $5 as change
                if (five > 0) {
                    five--;
                    ten++;
                } else {
                    return false;  // No $5 bill available for change
                }
            } else {
                // Customer pays with $20, need to give back $15 as change
                if (ten > 0 && five > 0) {
                    // Prefer giving back one $10 bill and one $5 bill
                    ten--;
                    five--;
                } else if (five >= 3) {
                    // Otherwise, give back three $5 bills
                    five -= 3;
                } else {
                    return false;  // Not enough change available
                }
            }
        }
        
        return true;  // All customers received correct change
    }
}
