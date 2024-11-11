/*
 
 For a Movie Premiere in US, advance booking is opened,
At Quad Cinema theater, each ticket costs $25.
And issue only one ticket per head. 

People are standing in a queue to buy from Quad Cinema counter, 
and order one at a time. And they are paying with either a $25, $50, or $100 notes.

You will be given, an array of notes[], the people are carrying with them.
Your task is to issue ticket and settle the balance to each person, 
If a person given a $50 note, Issue the ticket worth $25 and settle the balance $25.

Print true, if and only if you can provide tickets and settle the balance 
for all the people in the queue. Otherwise, false.

Note: Initially you don't have any amount in hand.

Input Format:
-------------
Line-1: An integer N, number of persons
Line-2: N space separated integers, notes with the persons.

Output Format:
--------------
Print a boolean value.


Sample Input-1:
---------------
5
25 25 25 50 100

Sample Output-1:
----------------
true

Explanation:
-----------
- The first three people pay with $25, so no change is needed.
- The fourth person pays with $50, and you return $25 as change.
- The fifth person pays with $100, and you return $75 as change ($50 + $25).
- Since every person gets their ticket and correct change, the answer is true.

Sample Input-2:
---------------
5
25 25 50 50 100

Sample Output-2:
----------------
false

Explanation:
-----------
- The first two people pay with $25, so no change is needed.
- The third and fourth people pay with $50, and you return $25 as change.
- The fifth person pays with $100, but you cannot return $75 as change 
(you only have $50 bills).
Since not everyone can receive their correct change, the answer is false.

 */

import java.util.*;
public class Day10P3 {
    public static void main(String[] args) {
        Scanner cin  = new Scanner(System.in);
        int n = cin.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]  = cin.nextInt();
        }
        int count25 = 0;
        int count50 = 0;
        for (int i = 0; i < n; i++) {
            if(arr[i]==25){
                count25++;
            }
            else if(arr[i]==50){
                if(count25!=0){
                count25--;
                count50++;
                }    
                else{
                    System.out.println(false);
                    return;
                }
            }
            else{
                if(count50!=0 && count25!=0){
                    count25--;
                    count50--;

                }
                else if(count25>=3){
                    count25-=3;
                }
                else{
                    System.err.println(false);
                    return;
                }
            }   
        }
        System.out.println(true);

    }
}
