import java.util.*;

public class Day35P1 {

    static List<List<Integer>> result = new ArrayList<>();
    public static List<List<Integer>> nSumLists( int n){
        backtrack(new ArrayList<>(),n,1);
        return result;
    }
    static void backtrack(List<Integer> currList, int n, int currMultiple){
        if(currMultiple>n){
            return;
        }
        if(currMultiple==n){
            result.add(new ArrayList<>(currList));
            return;
        }
        int currNum = (currList.size()!=0)? currList.get(currList.size()-1) : 2;
        for(int i=currNum ;i<n ;i++){
            if(n%(currMultiple*i)!=0) continue;
            currList.add(i);
            backtrack(currList, n, currMultiple*i);
            currList.remove(currList.size()-1);
        }

    }
    public static void main(String[] args) {
        Scanner cin =  new Scanner(System.in);
        int n = cin.nextInt();
        System.out.println(nSumLists(n));
        cin.close();
    }
}
