/*A system is designed to distribute even-sized allocations for a given 
resourceLimit. The goal is to maximize the number of unique allocations 
while ensuring that their sum equals resourceLimit.

Given an integer resourceLimit, split it into a sum of a maximum number of 
unique positive even integers. The following conditions must be met:
    - Each allocation must be a unique positive even integer.
    - The total sum of the integers must equal resourceLimit.
    - The number of integers in the split must be maximized.
    
If it is not possible to split resourceLimit into valid even allocations, 
return an empty list.

Input Format:
-------------
A single integer, resourceLimit (1 ≤ resourceLimit ≤ 10^9).

Output Format:
--------------
A list of integers representing the allocations. 
If no valid allocations exist, return an empty list.


Sample Input-1:
---------------
12

Sample Output-1:
----------------
[2, 4, 6]

Explanation:
------------
The possible splits are:
    - [12] (1 allocation)
    - [2, 10] (2 allocations)
    - [2, 4, 6] (3 allocations)
The split [2, 4, 6] has the maximum number of allocations.


Sample Input-2:
---------------
7

Sample Output-2:
----------------
[]

Explanation: 
------------
It's not possible to split 7 into unique positive even integers.

Sample Input-3:
---------------
28

Sample Output-3:
----------------
[2, 4, 6, 16]

Explanation: 
The possible splits are:
    - [2, 26] (2 allocations)
    - [6, 8, 2, 12] (4 allocations)
    - [2, 4, 6, 16] (4 allocations)

The split [2, 4, 6, 16] has the maximum number of allocations.

NOTE:
=====
Please refer the sample outputs to generate the solution.
 */
import java.util.*;
public class Day32P3 {
    List<Integer> result = new ArrayList<>();
    public  void helper(List<Integer> current, int currentSum,int curr,int n){
        if(currentSum>n){
            return;
        }
        if(currentSum==n){
            if(result.size()<current.size()){
                result = new ArrayList<>(current);
            }
            return;
        }
        for (int i = curr; i <= n - currentSum; i+=2) {
                current.add(i);
                helper(current, currentSum+i,i+2, n);
                current.remove((Integer)i);
            
        }
    }
    public  List<Integer> maximized(int n){
        if(n%2!=0){
            return new ArrayList<>();
        }
        List<Integer> temp = new ArrayList<>();
        helper(temp, 0, 2, n);

        return result;
    }
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        Day32P3 p = new Day32P3();
        System.out.println(p.maximized(n));
        cin.close();
    }
}

// greedy
/*import java.util.*;

public class Day32P3 {
    public List<Integer> maximized(int resourceLimit) {
        if (resourceLimit % 2 != 0) {
            return new ArrayList<>();
        }

        List<Integer> allocations = new ArrayList<>();
        int currentSum = 0;
        int nextEven = 2;

        while (currentSum + nextEven <= resourceLimit) {
            allocations.add(nextEven);
            currentSum += nextEven;
            nextEven += 2;
        }

        int leftover = resourceLimit - currentSum;
        if (leftover > 0) {
            int lastIndex = allocations.size() - 1;
            allocations.set(lastIndex, allocations.get(lastIndex) + leftover);
        }

        return allocations;
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int resourceLimit = cin.nextInt();
        Day32P3 p = new Day32P3();
        List<Integer> result = p.maximized(resourceLimit);
        System.out.println(result);
        cin.close();
    }
}
 */