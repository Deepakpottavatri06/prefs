/*There are P people in a Village, some of the people are relatives, others are not.
Their relationship is transitive in nature. 

For example, 
 if A is a direct relative of B, and B is a direct relative of C, 
then A is an indirect relative of C. And we define a Relation Chain is a group 
of people who are direct or indirect relatives.
 
 Given a P*P matrix R representing the relationship between people in the village. 
 If R[i][j] = 1, then the i and j persons are direct relatives with each other, 
 otherwise not. 

Your task is to findout the total number of Relation Chains among all the people.

Input Format:
-------------
Line-1 : An integer P, number of people
Next P lines : P space separated integers.

Output Format:
--------------
Print an integer, the total number of Relation Chains


Sample Input-1:
---------------
3
1 1 0
1 1 0
0 0 1

Sample Output-1:
----------------
 2

 Explanation:
 ------------
 The 0-th and 1-st people are direct relatives, so they are in a relation chain.
 The 2-nd person himself is in a relation chain. So return 2.

Sample Input-2:
---------------
3
 1 1 0
 1 1 1
 0 1 1
 
Sample Output-2:
----------------
 1

Explanation:
------------
The 0-th and 1-st people are direct relatives, 1-st and 2-nd people are direct 
relatives. So, the 0-th and 2-nd people are indirect relatives.
All of them in the same relative chain. So return 1.

 */
import java.util.*;
public class Day35P3 {

    public static int relationshipChains( int [][] village, int n){
        int chains = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
        for(int i =0 ;i < n; i++){
            if(visited.contains(i)) continue;
            queue.add(i);
            while (!queue.isEmpty()) {
                int t = queue.poll();
                if(visited.contains(t)) continue;
                visited.add(t);

                for (int j = 0; j < n; j++) {
                    if(village[t][j]==1 && !visited.contains(j)){
                        queue.add(j);
                    }
                }
            }
            chains++;
        }
        return chains;
    }
    public static int relationshipChainsDFS( int [][] village , int n){
        Set<Integer> visited = new HashSet<>();
        int relationShipChains = 0;
        for (int i = 0; i < n; i++) {
            if(!visited.contains(i)){
                relationShipChains++;
                dfs(village,visited,i);
            }
        }
        return relationShipChains;
    }
    static void dfs(int [][] village, Set<Integer> visited, int currNode){
        visited.add(currNode);
        for (int i = 0; i < village.length; i++) {
            if(!visited.contains(i) && village[currNode][i]==1){
                dfs(village, visited, i);
            }
        }

    }
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int row = cin.nextInt();
        cin.nextLine();
        int col = row;
        int village [][] = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                village[i][j] = cin.nextInt();
            }
        }

        // System.out.println(relationshipChains(village, row));
        System.out.println(relationshipChainsDFS(village, col));

    }
}
