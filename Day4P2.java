import java.util.Scanner;

public class Day4P2 {

    private static int binarySearch(int [] arr , int low , int high){
        int i = low ;
        int j = high;
        while(i<j){
            int mid = (i+j)/2;
            if(arr[mid]>=0){
                i = mid+1;
            }
            else if(arr[mid]<0){
                j = mid;
            }

        }
        System.out.println(arr[i]+" "+arr[j]);
        return (arr[i]<0)? i : -1;

    }
    public static void main(String[] args) {
        Scanner cin  = new Scanner(System.in);
        int m = cin.nextInt();
        int n = cin.nextInt();
        int arr [][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = cin.nextInt();
            }
        }
        int count = 0;
        for (int i = 0; i < m; i++) {
            int temp = binarySearch(arr[i], 0, arr[i].length-1);
            if(temp!=-1){
                count += (arr[i].length-temp);
            }
        }
        System.out.println(count);
        cin.close();
    }
}
