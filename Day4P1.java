import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.*;
import java.util.*;

/**
 * Day4P1
 */
public class Day4P1 {
    public static void main(String[] args) {
        String regex = "\\+91\\s[0-9]{5}\\s[0-9]{5}|0[0-9]{2}\\-[0-9]{4}\\-[0-9]{4}";
        Pattern p = Pattern.compile(regex);
        Scanner cin = new Scanner(System.in);
        List<String> l = new ArrayList<>();
        int n = cin.nextInt();
        for (int i = 0; i < n; i++) {
            String temp = cin.nextLine();
            Matcher m = p.matcher(temp);
            if(m.matches()){
                l.add(temp);
            }
        }
        System.out.println(l);

        cin.close();

    }
    
}
/*
 * +91 98765 43210
+91 9876543210
012-3456-7890
01-2345-67890
+91 321 456 7890

 */