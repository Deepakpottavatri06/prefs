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
public class Day24P1 {
    public static void main(String[] args) {
        
    }
}
