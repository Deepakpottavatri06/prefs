import java.util.*;


public class Day10P1{
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int countFive = 0;
        for (int i = 1; i <= n; i++) {
            int temp = i;
            while (temp%5==0) {
                countFive++;
                temp = temp/5;
            }
        }

        System.out.println(countFive);
        cin.close();
    }
}