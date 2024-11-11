import java.util.*;

public class Day10P2 {

    public static int binarySearch(char [] arr , int low , int high , char clue){
        while (low<high) {
            int mid = (low+high)/2;
            // System.err.println((int)arr[mid]);
            if((int)arr[mid]<=(int)clue){
                low = mid+1;
            }
            else{
                high = mid;
            }
        }
        return (low==arr.length)? 0:low;
    }
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        char str [] = cin.nextLine().toCharArray();
        char clue[] = cin.nextLine().toCharArray();
        System.out.println(str[binarySearch(str, 0, str.length, clue[0])]);

    }
}
