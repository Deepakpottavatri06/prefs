/*
 In a township of size N×N, each 1x1 area is either a villa or a swimming pool. 
The layout of the township is represented as a 2D matrix of size N×N, 
filled with 0's and 1's, where:
    - 0 represents a swimming pool,
    - 1 represents a villa.

Your task is to identify a swimming pool such that its distance to the nearest 
villa(s) is maximized, and return this distance.

If the township contains only villas or only swimming pools, return -1.

Note: The distance used in this problem is the Manhattan distance: the distance 
between two cells (a0, b0) and (a1, b1) is defined as |a0 - a1| + |b0 - b1|

Input Format:
-------------
- The first line contains an integer N, the size of the 2D matrix
- The next N lines each contain N space-separated integers, either 0 or 1, 
  representing the township matrix.

Output Format:
--------------
Print an integer, representing the maximum distance from any swimming pool to 
the nearest villa.


Sample Input-1:
---------------
4
1 0 1 1
0 0 0 0
1 0 1 0
1 0 0 1

Sample Output-1:
----------------
2

Explanation: 
------------
The swimming pool at (1, 1) is with distance 2 from the nearest villas.



Sample Input-2:
---------------
4
1 0 0 0
0 0 0 0
1 0 0 0
0 1 0 1

Sample Output-2:
----------------
3

Explanation: 
------------
The swimming pool at (0,3) or (1, 2) are with distance 3 from the nearest villas.

 */

import java.util.*;

public class Day24P1 {

  public static int bfsHelper(int[][] arr, int i, int j) {
    Queue<int[]> queue = new ArrayDeque<>();
    Set<String> visited = new HashSet<>();
    queue.add(new int[] { i, j });
    // visited.add(i + "" + j);
    int distance = Integer.MAX_VALUE;
    int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int k = 0; k < size; k++) {
        int temp[] = queue.poll();
        int r = temp[0];
        int c = temp[1];
        if(arr[r][c]==1){
           distance = Math.min(distance, Math.abs(r-i)+Math.abs(c-j));
        }
        if (visited.contains(r + "" + c))
        continue;
        visited.add(r + "" + c);
        for (int l = 0; l < dir.length; l++) {
          if((r+dir[l][0])>=0 && (r+dir[l][0])<arr.length && (c+dir[l][1])>=0 && (c+dir[l][1])<arr[0].length && !visited.contains(r+dir[l][0]+""+c+dir[l][1])){
              queue.add(new int[] {r+dir[l][0],c+dir[l][1]});
              // System.out.println(r+dir[l][0]+""+c+dir[l][1]);
          }
        }
      }
      if(distance!=Integer.MAX_VALUE){
        return distance;
      }
    }
    return -1;
  }

  public static int maxDistance(int[][] arr, int row, int col) {
    int result = -1;
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (arr[i][j] == 0) {
          int t = bfsHelper(arr, i, j);
          if(t==-1) return -1;
          result = Math.max(result, t);
        }
      }
    }
    return result;
  }

  public static void main(String[] args) {
    Scanner cin = new Scanner(System.in);
    int row = cin.nextInt();
    int col = row;
    cin.nextLine();
    int arr[][] = new int[row][col];
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        arr[i][j] = cin.nextInt();
      }
    }
    System.out.println(maxDistance(arr, row, col));
    cin.close();

  }
}
