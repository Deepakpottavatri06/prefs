import java.util.*;


public class Day8P1 {
    public static void main(String[] args) {
        Scanner cin  = new Scanner(System.in);
        int n = cin.nextInt();
        int arr [] = new int[n];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr[i] = cin.nextInt();
            list.add(arr[i]);
        } 
        Collections.sort(list);
        List<String> result = new ArrayList<>();
        for (int i = 0; i < arr.length ; i++) {
            if(list.indexOf(arr[i])==n-1){
                result.add("Champion");
            }
            else if(list.indexOf(arr[i])==n-2){
                result.add("RunnerUp-1");
            }
            else if(list.indexOf(arr[i])==n-3){
                result.add("RunnerUp-2");
            }
            else{
                result.add(String.valueOf(n-list.indexOf(arr[i])));
            }
        }
        System.out.println(result);
        cin.close();
    }
}
