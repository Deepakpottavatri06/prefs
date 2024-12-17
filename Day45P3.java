
/*A covert agent has crucial information stored in the form of an array of integers. 
The array contains sensitive information, and it must not be revealed to anyone. 
However, certain properties about the array are known:
 - The length of the array is equal to the "length of a secret array + 1".
 - Each integer in the array lies within a specific interval [lowerBound L,
   upperBound U ].
 
The difference between each pair of consecutive integers in the array must be equal
to the difference between the respective pair of integers in the secret array.

Given a list of consecutive differences representing the secret array.
The values of lowerBound and upperBound.

Your task is to find the total number of arrays that satisfy the conditions to 
be analogous to the secret array. If no such arrays exist, return 0.

Input Format:
-------------
Three space sepaarted integers, N, L, U
N space serapated inteegrs, secret array[].

Output Format:
--------------
An integers, number of analogous arrays.


Sample Input-1:
---------------
4 3 10
-2 -1 -2 5

Sample Output-1:
----------------
3

Explanation:
--------------
There are 3 valid arrays:
    [3, 5, 6, 8, 3]
    [4, 6, 7, 9, 4]
    [5, 7, 8, 10, 5]


Sample Input-2:
---------------
3 1 6
1 2 1

Sample Output-2:
----------------
2

Explanation:
------------
There are 2 valid arrays:
    [1, 2, 4, 5]
    [2, 3, 5, 6]
 */
import java.util.*;
public class Day45P3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int L = sc.nextInt();
        int U = sc.nextInt();
        int[] secretArray = new int[N];
        for (int i = 0; i < N; i++) {
            secretArray[i] = sc.nextInt();
        }
        sc.close();
        
        System.out.println(countAnalogousArrays(N, L, U, secretArray));
        }
    
    static int countAnalogousArrays(int N , int L , int U , int [] secretArray){
        // int size = N+1;
        int res = 0;
        l1 :for (int i = L; i <= U; i++) {
            int temp = i;
            for (int j = 0; j < N; j++) {
                if((temp - secretArray[j] )>=L && (temp-secretArray[j])<=U){
                    temp = temp - secretArray[j];
                }
                else{
                    continue l1;
                }
            }
            res++;
        }
        return res;
    }
}
