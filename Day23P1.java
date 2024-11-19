/*
Brahmi and his gang have been chased by a group of police officers and are now 
trapped in a building with M×N rooms, arranged in a grid format. Each room is 
connected to its adjacent rooms both horizontally and vertically, forming a 
complex layout. Fortunately, some rooms in the building are designated as 
"safe zones," providing a possible escape for Brahmi and his gang.

The building's rooms are marked with the following values:
    -1 : Danger Zone - an area that Brahmi and his gang cannot enter.
    0 : Safe Zone - an area that provides a possible escape.
    -2 : Occupied by a gang member.
    
Your task is to help Brahmi and his gang reach the nearest safe zones by 
calculating the minimum distance from each gang member's room to a safe zone, 
avoiding danger zones. If a gang member is unable to reach any safe zone, 
mark their room with -2.

Input Format:
-------------
Line-1 -> two integers M and N, size of the grid of rooms.
Next M Lines -> N space separated integers, from this set [-2,-1,0] only.

Output Format:
--------------
Print an integer as result.


Sample Input-1:
---------------
4 4
-2 -1 0 -2
-2 -2 -2 -1
-2 -1 -2 -1
0 -1 -2 -2

Sample Output-1:
----------------
3 -1 0 1
2 2 1 -1
1 -1 2 -1
0 -1 3 4

NOTE: Please refer the hint.

 */

import java.util.*;

public class Day23P1 {


    public static int[][] minMatrix(int [][] arr, int row , int col){
        Queue<int []> queue = new ArrayDeque<>();
        int [][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
        int [][]distance = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(arr[i][j]==0){
                    distance[i][j] = 0;
                    queue.add(new int[]{i,j});
                }
                else{
                    distance[i][j] = arr[i][j];
                }
            }
        }
        while (!queue.isEmpty()) {
            int temp [] = queue.poll();
            int r = temp[0];
            int c = temp[1];
            for (int k = 0; k < dir.length; k++) {
                if((r+dir[k][0])>=0 && (r+dir[k][0])<arr.length && (c+dir[k][1])>=0 && (c+dir[k][1])<arr[0].length && (distance[r+dir[k][0]][c+dir[k][1]])==-2){
                    
                    distance[r+dir[k][0]][c+dir[k][1]] = distance[r][c]+1;
                    queue.add(new int[]{r+dir[k][0],c+dir[k][1]});
                }
            }
        }

        return distance;
       
    }
    public static void main(String[] args) {
        Scanner cin  = new Scanner(System.in);
        int row = cin.nextInt();
        int col  = cin.nextInt();
        cin.nextLine();
        int arr[][] = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                arr[i][j] = cin.nextInt();
            }
        }
        arr = minMatrix(arr, row, col);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        
    }
}
