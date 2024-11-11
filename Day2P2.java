import java.util.*;
/*
 * You are developing an inventory management system for a retail company. 
The company wants to introduce a new feature where it can predict when 
the inventory for a product might need restocking. The inventory levels 
for various products are recorded daily, and the company wants to monitor 
the next higher stock level for each product to anticipate demand.

Given an array stock_levels where each element represents the daily inventory 
level of a particular product over a certain period, write a function to find 
the "next higher stock level" for every day. The "next higher stock level" for
a given day is defined as the first higher stock level recorded in 
the subsequent days. If no higher stock level is found in the following days, 
return -1.

Sample Input:
---------
Line-1: An integer N, Number of days.
Line-2: N space seprated integers,  

Sample Output:
--------------
An integer array acoording to problem.


Sample Input-1:
---------------
3
10 15 10

Sample Output-1: 
---------------
[15, -1, -1]

Explanation-1:
--------------
- For day 1 (stock level = 10), the next higher stock level is 15.
- For day 2 (stock level = 15), there is no higher stock level in the subsequent days.
- For day 3 (stock level = 10), there is no higher stock level in the subsequent days.


Sample Input-2:
---------------
6
20 25 30 15 20 35

Sample Output-2: 
---------------
[25, 30, 35, 20, 35, -1]

Explanation-2:
--------------
- For day 1 (stock level = 20), the next higher stock level is 25.
- For day 2 (stock level = 25), the next higher stock level is 30.
- For day 3 (stock level = 30), the next higher stock level is 35.
- For day 4 (stock level = 15), the next higher stock level is 20.
- For day 5 (stock level = 20), the next higher stock level is 35.
- For day 6 (stock level = 35), there is no higher stock level in 
  the subsequent days.


 */

import java.util.*;

public class Day2P2 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n =  cin.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = cin.nextInt();
        }
        
        arr = compute(arr,n);
        System.out.println(Arrays.toString(arr));
        cin.close();
    }   
    private static int [] compute(int [] arr ,int n){
        int result [] = new int[n];
        // for (int i = 0; i < n; i++) {
        //     int j = i+1;
        //     while(j<n && arr[i] > arr[j]){
        //         j++;
        //     }
        //     if(j==n) result[i] = -1;
        //     else result[i] = arr[j];
        // }
        Stack<Integer> stack = new Stack<>();
        for(int i = n-1 ; i>=0 ; i--){
            if(stack.empty()){
                result[i] = -1;
            }
            else if(stack.peek()>arr[i]){
                    result[i] = stack.peek();
            }
            else{
                while(!stack.empty() && stack.peek()<=arr[i]){
                    stack.pop();
                }
                if(stack.empty()) result[i] = -1;
                else result[i] = stack.peek();
            }
            stack.push(arr[i]);
        }
        return result;
        
    }
}
