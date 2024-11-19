/*A dangerous virus, "Ebola," is spreading across several African countries. 
People are positioned in a grid of size p * q, where some positions in the grid 
are empty.

The grid is represented with three values: 0, 1, and 2, where:
    - 0 indicates an empty position,
    - 1 indicates a healthy person, and
    - 2 indicates an infected person.
    - Each minute, any healthy person who is 4-directionally adjacent (up, down, 
      left, or right) to an infected person becomes infected.

Your task is to determine the minimum amount of time, in minutes, for the virus 
to spread to all people in the grid. 
If it is impossible to infect everyone, return -1.

Input Format:
-------------
Line 1: Two integers, P and Q, representing the dimensions of the grid.
Next P lines: Each line contains Q space-separated integers, either 0, 1, or 2, 
              representing the grid.

Output Format:
--------------
An integer, the minimum amount of time in minutes


Sample Input-1:
---------------
3 3
2 1 1
1 1 0
0 1 1

Sample Output-1:
----------------
4

Explanation-1: (Refer the hint)
--------------
There is an infected person at position (0, 0).
In the first minute: people at positions (0, 1) and (1, 0) are infected.
In the second minute: people at positions (0, 2) and (1, 1) are infected.
In the third minute: the person at position (1, 2) is infected.
In the fourth minute: the person at position (2, 2) is infected.


Sample Input-2:
---------------
3 3
2 1 1
0 1 1
1 0 1

Sample Output-2:
----------------
-1

Explanation-2:
--------------
The healthy person at the bottom left corner (row 2, column 0) cannot be 
infected because infection only spreads in the four primary directions.

Sample Input-3:
---------------
1 2
0 2

Sample Output-3:
----------------
0

Explanation-3: 
-------------
Since there are no healthy people at minute 0, the answer is simply 0.
 */

import java.util.*;

public class Day25P3 {
    public static int minTime(int [][] arr , int row , int col){
        int minimum = 0;
        Queue<List<Integer>> queue = new ArrayDeque<>();
        boolean visited[][] = new boolean[row][col];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < col; j++) {
                if(arr[i][j]==2){
                    queue.add(Arrays.asList(i,j,0));
                    visited[i][j] = true;
                }
            }
        }
        int [][] directions = {
            {1,0},{-1,0},
            {0,1},{0,-1}
        };

        while (!queue.isEmpty()) {
            List<Integer> temp  = queue.poll();
            int r = temp.get(0);
            int c = temp.get(1);
            int d = temp.get(2);
            
            minimum = Math.max(d,minimum);
            for(int [] dir : directions){
                int nr = r + dir[0];
                int nc = c + dir[1];
                if(nr>=0 && nr<row && nc>=0 && nc<col && !visited[nr][nc] && arr[nr][nc]!=0){
                    queue.add(Arrays.asList(nr,nc,d+1));
                    visited[nr][nc] = true;
                }
            }            
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(!visited[i][j] && arr[i][j]!=0){
                    return -1;
                }
            }
        }
        return minimum;
    }
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int row = cin.nextInt();
        int col = cin.nextInt();
        cin.nextLine();
        int arr [] [] = new int[row][col];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < col; j++) {
                arr[i][j] = cin.nextInt();
            }
        }   
        System.out.println(minTime(arr,row,col));
        cin.close();
    }
}
