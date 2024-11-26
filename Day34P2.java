/*Mr Parandhamayya working with words.
He is given a word W, you need to divide the word into N non-empty parts, 
such that all the newly formed words should be distinct, and 
if you append all those words should form original word W.

Your task is to help Mr Parandhamayya to divide the word into N parts,
such that, the value of N should be maximized, and print N.

Input Format:
-------------
Line-1: A string W, a word.

Output Format:
--------------
Print an integer result, the value of N.


Sample Input-1:
---------------
banana

Sample Output-1:
----------------
4

Explanation: 
------------
One way to divide the word is "b","a","n","ana".
If you divide it like "b","a","n","an","a".The word "a" will be repeated.
So it is not allowed to divide like the second way.


Sample Input-2:
---------------
mississippi

Sample Output-2:
----------------
7

Explanation: 
------------
One of the way to divide the word is "m","i","s","si","ssi","p","pi".

NOTE: Subsequences are not allowed.
 */
import java.util.*;
public class Day34P2 {
    static int res = 0;
    public static void helper(String word, Set<String> set, int pos){
        if(pos>= word.length()){
            // System.out.println("end set :"+set);
            if(res<set.size()){
                // System.out.println("I am here");
                res = set.size();
            }
            return;
        }

        for (int i = pos+1; i <= word.length(); i++) {
            String t = word.substring(pos, i);
            if(set.contains(t)) continue;
            // System.out.println("current string "+t);
            set.add(t);
            helper(word, set, i);
            set.remove(t);
        }

    }
    public static int nWays(String word){
        Set<String> set = new HashSet<>();
        helper(word,set,0);
        return res;
    }
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        String word = cin.nextLine();
        System.out.println(nWays(word));
        cin.close();
    }
}
