
import java.util.*;
public class Day32P1 {

    public static boolean converse(int n){
        String nString  = Integer.toBinaryString(n);
        System.out.println(nString);
        int bit = nString.charAt(0) - '0';
        for (int i = 1; i < nString.length(); i++) {
            if(bit!=nString.charAt(i)-'0'){
                bit = nString.charAt(i)-'0';
            }
            else{
                return false;
            }
        }

        return true;
    }
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        System.out.println(converse(n));
    }
}