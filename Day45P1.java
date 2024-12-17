/*Mr Govind is working with words in English.
He found something interesting between the words.
The properties of those words are as follows:
	- The words have same set of letters and occurrences of each letter is also same.
	- For example, read and dear are the two words having same letters,
	and each letter appeared for same number of times in each word.
	- Only the positions of the letters may vary in the words.

You will be given the list of words, Your task is to find and
group the words which have the properties mentioned above.
And print them as list of list of words as shown in the samples. 

Input Format:
-------------
Line-1: A single line space space-separated words, list[].

Output Format:
--------------
Print the list of list of strings.


Sample Input-1:
---------------
tear tera dare dear read rate tare earn near rena

Sample Output-1:
----------------
[[tear, tera, rate, tare], [dare, dear, read], [earn, near, rena]]


Sample Input-2:
---------------
rate tar eat tare tear tea rat

Sample Output-2:
----------------
[[rate, tare, tear], [tar, rat], [eat, tea]]
 */

import java.util.*;

public class Day45P1 {
    static String grouping(String [] words){
        Map<String,List<String>> group = new LinkedHashMap<>();
        int n = words.length;
        for (int i = 0; i < n; i++) {
            char [] t = words[i].toCharArray();
            Arrays.sort(t);
            String temp = String.valueOf(t);
            if(!group.containsKey(temp)){
                group.put(temp, new ArrayList<>());
            }
            group.get(temp).add(words[i]);
        }
        int size = group.size();
        String [][] grouped = new String[size][];
        int i = 0;
        for(Map.Entry<String,List<String>> entry : group.entrySet()){
            String [] oneGroup = new String[entry.getValue().size()];
            entry.getValue().toArray(oneGroup);
            grouped[i] = oneGroup;
            i++;
        }

        return Arrays.deepToString(grouped);

    }
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        String input = cin.nextLine();
        String[] words = input.split(" ");
        System.out.println(grouping(words));
        cin.close();
    }
}
