/*
 Mahalakshmi is participating in a treasure hunt that includes N boxes, each 
numbered sequentially from 0 to N-1. Initially, all the boxes are locked with 
unique passcodes, except for Box-0, which is unlocked.

Each box in the treasure hunt contains a list of envelopes, with each envelope 
holding the passcode to unlock a different box. The envelope is labeled with 
the box number it can unlock.

Mahalakshmi can open the boxes in any order, but she must start with Box-0.

The goal of the treasure hunt is to unlock all the boxes. Your task is to 
determine if Mahalakshmi can open every box and win the game.

If she can unlock all the boxes, print "Win". Otherwise, print "Lost".

Input Format:
-------------
Line-1: An integer, number of boxes.
Next N lines: space separated integers, box numbers.

Output Format:
--------------
Print a string value, Win or Lost


Sample Input-1:
---------------
5
1
2
3
4
3

Sample Output-1:
----------------
Win

Sample Input-2:
---------------
4
1 3
3 0 1
2
0

Sample Output-2:
----------------
Lost

 */

import java.util.*;

public class Day26P1 {
    public static String game(List<List<Integer>> arr, int n){
        boolean boxes [] = new boolean[n];
        for (int i = 1; i < n; i++) {
            boxes[i]= false;
        }
        boxes[0] = true;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(0);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int t = queue.poll();
                List<Integer> temp = arr.get(t);
                for (Integer integer : temp) {
                    if(!boxes[integer]){
                        queue.add(integer);
                        boxes[integer] = true;
                    }
                }
            }
        }

        int count = 0;
        for (int i = 0; i < boxes.length; i++) {
            if(boxes[i]==true){
                count++;
            }
        }

        if(count==n){
            return "Win";
        }
        return "Lost";        
    }
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        cin.nextLine();
        List<List<Integer>> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String temp [] = cin.nextLine().split(" ");
            List<Integer> t = new ArrayList<>();
            for (String string : temp) {
                t.add(Integer.parseInt(string));
            }
            arr.add(t);
        }

        System.out.println(game(arr,n));
        cin.close();
    }
}
