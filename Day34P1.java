/*Given an 2D character array, Letters[][], of size r*c.
You have to construct the word W, using the given array.

Rules to construct the word are as follows:
	- All the letters of the word W, should be adjacent to each other 
	in the array Letters(either horizontal or vertical).
	- You can use each charcater in Letters[][] only once.

If you are able to construct the word W, return 'true'
Otherwise 'false'.

Input Format:
-------------
Line-1 -> two integers R and C, array size.
R lines -> C space separated characters.
Last line -> a string, word W

Output Format:
--------------
print the boolean result.


Sample Input-1:
---------------
3 3
a b c
d e f
g h i
bad

Sample Output-1:
----------------
true


Sample Input-2:
---------------
3 3
a b c
d e f
g h i
ace

Sample Output-2:
----------------
false


Sample Input-3:
---------------
3 3
a b c
d e f
g h i
add

Sample Output-3:
----------------
false
 */
import java.util.*;

public class Day34P1 {
    public static boolean helper(char[][] letters, String word, int pos, int r, int c){
        if(r>=0 && r<letters.length && c>=0 && c<letters[0].length && pos<word.length() && letters[r][c]==word.charAt(pos)){
            char temp = letters[r][c];
            letters[r][c] = '-';
            boolean t =  helper(letters, word, pos+1, r+1, c) || helper(letters, word, pos+1, r, c+1)
                || helper(letters, word, pos+1, r-1, c) || helper(letters, word, pos+1, r, c-1);
            letters[r][c] = temp;
            return t;
        }
        else if(pos>=word.length()){
            return true;
        }
        else{
            return false;
        }
    }
    public static boolean constructWord(char[][] letters, String word){
        for (int i = 0; i < letters.length; i++) {
            for (int j = 0; j < letters[0].length; j++) {
                if(word.charAt(0)==letters[i][j]){
                    boolean t =helper(letters, word, 0,i,j);
                    if(t) return t;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int r = cin.nextInt();
        int c = cin.nextInt();
        cin.nextLine();
        char [][] letters = new char[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                letters[i][j] = cin.next().charAt(0);
            }
        }
        cin.nextLine();
        String word = cin.nextLine();
        System.out.println(constructWord(letters,word));
        cin.close();
    }
}
