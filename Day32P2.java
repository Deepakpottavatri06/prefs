import java.util.*;

public class Day32P2 {
    Set<String> distinct = new HashSet<>();

    public void helper(char cubes [], String s, int len, boolean used[]){
        if(len>cubes.length){
            return;
        }
        if(!distinct.contains(s)){
            distinct.add(s);
        }
        for (int i = 0; i < cubes.length; i++) {
            if(used[i]) continue;
            used[i] = true;
            helper(cubes, s+cubes[i], len+1, used);
            used[i] = false; 
        }
    }
    public  int findDistinct(String inp){

        char cubes[] = inp.toCharArray();
        boolean used [] = new boolean[cubes.length];
        helper(cubes,"",0,used);
        return distinct.size()-1;
    }
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        String inp = cin.nextLine();
        System.out.println(new Day32P2().findDistinct(inp));
    }
}
