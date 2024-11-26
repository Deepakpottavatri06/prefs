/*
 * Given a classic mobile phone, and the key pad of the phone looks like below.
	1		2		3
           abc	   def
		 
	4		5		6
    ghi    jkl     mno
  
	7		8		9
    pqrs    tuv     wxyz
	
	*		0		#


You are given a string S contains digits between [2-9] only, 
For example: S = "2", then the possible words are "a", "b", "c".

Now your task is to find all possible words that the string S could represent.
and print them in a lexicographical order. 

Input Format:
-------------
A string S, consist of digits [2-9]

Output Format:
--------------
Print the list of words in lexicographical order.


Sample Input-1:
---------------
2

Sample Output-1:
----------------
[a, b, c]


Sample Input-2:
---------------
24

Sample Output-2:
----------------
[ag, ah, ai, bg, bh, bi, cg, ch, ci]

 */

import java.util.*;
public class Day33P1 {
    String keyPad []={
        "",   
        "",    
        "abc", 
        "def", 
        "ghi", 
        "jkl", 
        "mno", 
        "pqrs",
        "tuv",
        "wxyz" 
    };
    List<String> res = new ArrayList<>();
    public void helper(String inp,int pos,String curr){
        if(pos>=inp.length()){
            res.add(new String(curr));
            return;
        }
        int num = Integer.parseInt(inp.substring(pos, pos+1));
        
        for(int i = 0; i< keyPad[num].length();i++){
            helper(inp, pos+1, curr+keyPad[num].charAt(i));
        }

    }
    public List<String> possibleWords(String inp){
        helper(inp,0,"");
        return res;
    }
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        String inp = cin.nextLine();
        System.out.println(new Day33P1().possibleWords(inp));
        cin.close();

    }
}