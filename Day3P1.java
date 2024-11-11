
/*
In a futuristic virtual reality (VR) game world, players are provided with custom VR keypads that are similar to modern American keyboards but have some restrictions. The keypad is divided into three distinct zones, and each zone contains specific letters that the player can use for a task.
	- Zone 1: Letters on the top row: "qwertyuiop"
	- Zone 2: Letters on the middle row: "asdfghjkl"
	- Zone 3: Letters on the bottom row: "zxcvbnm"

Players are given a set of secret codes (words), and they must type these codes using only letters from one zone at a time. If a word uses letters from more than one zone, it will be considered invalid and cannot be typed.

Your task is to help the players by filtering out the valid secret codes (words) that can be typed using letters from only one zone.

Given a list of secret codes (words), return the codes that can be typed using letters from only one zone of the VR keypad.

Constraints:
------------
1 ≤ secretCodes.length ≤ 20
1 ≤ secretCodes[i].length ≤ 100
secretCodes[i] consists of English letters (both lowercase and uppercase).

Input Format:
-------------
Space separated words, secretCodes[]

Output Format:
--------------
A list of codes that can be typed using letters from only one zone.


Sample Input-1:
---------------
Galaxy Mars Venus Sky

Sample Output-1:
----------------
["Mars", "Sky"]

Explanation:
------------
"Mars" can be typed using only Zone 2.
"Sky" can be typed using only Zone 3.
"Galaxy" and "Venus" use letters from multiple zones and are thus invalid.


Sample Input-2:
---------------
keyboard monkey

Sample Output-2:
----------------
[]

Explanation:
------------
None of the words can be typed using letters from only one zone.


Sample Input-3:
---------------
qw er ty

Sample Output-3:
----------------
["qw", "er", "ty"]

Explanation:
------------
All the codes can be typed using only letters from Zone 1.

*/
import java.util.*;

public class Day3P1 {
    public static void main(String[] args) {
        Set<String> Zone1 = new HashSet<>(Arrays.asList("q", "w", "e", "r", "t", "y", "u", "i", "o", "p"));
        Set<String> Zone2 = new HashSet<>(Arrays.asList("a", "s", "d", "f", "g", "h", "j", "k", "l"));
        Set<String> Zone3 = new HashSet<>(Arrays.asList("z", "x", "c", "v", "b", "n", "m"));
        Scanner cin = new Scanner(System.in);
        String[] words = cin.nextLine().split(" ");
        List<String> ans = new ArrayList<>();

        for (String string : words) {
            boolean flag = true;
            int zone = 0;
            if (Zone1.contains(string.substring(0, 1).toLowerCase())) {
                zone = 1;
            } else if (Zone2.contains(string.substring(0, 1).toLowerCase())) {
                zone = 2;
            } else {
                zone = 3;
            }
            for (int i = 0; i < string.length(); i++) {
                if (zone == 1 && !Zone1.contains(string.substring(i, i + 1).toLowerCase())) {
                    flag = false;
                    break;
                }
                if (zone == 2 && !Zone2.contains(string.substring(i, i + 1).toLowerCase())) {
                    flag = false;
                    break;
                }
                if (zone == 3 && !Zone3.contains(string.substring(i, i + 1).toLowerCase())) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                ans.add(string);
            }
        }
        System.out.println(ans);
        cin.close();
    }
}
