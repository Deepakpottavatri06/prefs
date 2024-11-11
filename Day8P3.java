/*
 To maximize energy efficiency and lighting optimization, you are allowed to perform 
an operation multiple times:
	You can choose any row or column of the grid and toggle all the bulbs in 
	that row or column. Toggling means:
		- Bulbs that are ON (1) will turn OFF (0).
		- Bulbs that are OFF (0) will turn ON (1).

Each row in the grid can be interpreted as a binary number, where the leftmost bulb 
is the most significant bit and the rightmost bulb is the least significant bit. 
The goal is to maximize the sum of these binary numbers for all rows in the grid, 
after performing any number of toggles on the grid.

Your task is to find the highest possible score, which is the maximum sum of all 
the binary numbers that can be obtained after optimizing the grid through these 
toggling operations.

Input Format:
-------------
Line-1: Two space separated integers, M and N
Next M lines: N space separated integers, grid[][]

Output Format:
--------------
Print an integer result.


Sample Input-1:
---------------
3 5
0 1 1 1 1 
1 0 1 1 1 
0 0 0 0 1 

Sample Output-1:
----------------
78

Explanation:
------------
Given grid is 
0 1 1 1 1
1 0 1 1 1
0 0 0 0 1

Perform operation on row-0 and row-2
1 0 0 0 0
1 0 1 1 1
1 1 1 1 0

Perform operation on col-1 and col-4
1 1 0 0 1 = 25
1 1 1 1 0 = 30
1 0 1 1 1 = 23
So, now the total value of Binary Equivalent is 78


Sample Input-2:
---------------
2 3
0 1 0
0 0 1

Sample Output-2:
----------------
11

 */
import java.util.*;
public class Day8P3 {
    public static void main(String[] args) {
        Scanner cin =  new Scanner(System.in);
        int row = cin.nextInt();
        int col = cin.nextInt();
        int result = 0;
        int arr [] [] = new int[row][col];
        for (int i = 0; i < row; i++) {
            for(int j = 0; j<col ; j++ ){
                arr[i][j] = cin.nextInt();
            }
        }
        
        for (int i = 0; i < row; i++) {
            if(arr[i][0]==0){
                for (int j = 0; j < col; j++) {
                    arr[i][j] = 1-arr[i][j];
                }
            }
        }

        for (int j = 0; j < col; j++) {
            int count = 0;
            for (int i = 0; i < row; i++) {
                count+=arr[i][j];
            }

            if((double)count < Math.ceil(((double)row)/2)){
                for (int i = 0; i < row; i++) {
                    arr[i][j] = 1 - arr[i][j];
                }
            }
        }
       

        for (int i = 0; i < row; i++) {
            String temp = "";
            for (int j = 0; j < col; j++) {
                temp+=arr[i][j];
            }   
            System.out.println();
            result+=Integer.parseInt(temp,2);
        }
        System.out.println(result);
        cin.close();
    }
}
