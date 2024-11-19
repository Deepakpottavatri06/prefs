/*
 A robot is placed in a n×n grid warehouse where it can move in four directions: 
"UP", "DOWN", "LEFT", and "RIGHT". Each cell in the grid represents a section 
of the warehouse, identified by its position: grid[i][j], where i is 
the row index and j is the column index. 

The indexes are starts from 0, 1, 2, and so on, row wise next row index 
starts with next number in the sequence.

The robot starts at cell grid[0][0] and follows a sequence of commands to move 
between sections.

The robot can:
    - Navigate through the grid based on the given sequence of commands.
    - Stay within the bounds of the grid—if a command attempts to move 
      the robot outside the grid, the command should be ignored.

The goal is to identify the 1D index of the robot’s final position in the grid 
after executing all the commands.

Sample Input:
---------
Line-1: An integer N, Number of days.
Line-2: N space seprated integers,  

Sample Output:
--------------
An integer array acoording to problem.


Sample Input:
-------------
2               //grid size
RIGHT DOWN      //commmands

Sample Output:
--------------
3

Explanation:
------------
The snake starts at grid[0][0] (index 0). 
- "RIGHT": moves to grid[0][1] (index 1).
- "DOWN": moves to grid[1][1] (index 3).


Sample Input:
-------------
3
DOWN LEFT RIGHT

Sample Output:
--------------
4

Explanation:
------------
The snake starts at grid[0][0] (index 0).
- "DOWN": moves to grid[1][0] (index 3).
- "LEFT": ignored (out of bounds).
- "RIGHT": moves to grid[1][1] (index 4).

 */

import java.util.*;


public class Day19P1 {
    public static int oneDIndex(int n,String [] d){
        List<String> dir = Arrays.asList("UP", "DOWN", "LEFT", "RIGHT");
        int [][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
        int arr [][] = new int[n][n];
        int start [] ={0,0};
        int result  = 0;
        for (int i = 0; i < d.length; i++) {
            int temp [] = directions[dir.indexOf(d[i])];
            if((start[0]+temp[0])>=0 && (start[0]+temp[0])<arr.length && (start[1]+temp[1])>=0 && (start[1]+temp[1])<arr[0].length){
                start[0]+=temp[0];
                start[1]+=temp[1];
                result = start[0]*n + start[1];
                System.out.println("start :"+start[0]+start[1]);
                System.out.println(result);
            }
        }

        return result;

    }
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        cin.nextLine();
        String [] d = cin.nextLine().split(" ");
        System.out.println(oneDIndex(n,d));
        cin.close();
    }
}
