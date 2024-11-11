import java.util.*;




public class Day1P1{
    public static void main(String [] args){
        Scanner cin  = new Scanner(System.in);
        String inp = cin.nextLine();
        System.out.println(compute(inp));
        cin.close();
    }
    private static boolean compute(String str){
        List<String> stack = new ArrayList<>();
        int len = str.length();
        for(int i=0;i<len;i++){
            if(str.charAt(i)=='{'){
                stack.add("{");
            }
            else if(str.charAt(i)=='}'){
                if(stack.size()==0 || !stack.get(stack.size()-1).equals("{")){
                    return false;
                }
                stack.remove(stack.size()-1);
            }
            else if(str.charAt(i)=='/' && i+1<len && str.charAt(i+1)=='*'){
                stack.add("/*");
                i++;
            }
            else if(str.charAt(i)=='*' && i+1<len && str.charAt(i+1)=='/'){
                if(stack.size()==0 || !stack.get(stack.size()-1).equals("/*")){
                    return false;
                }
                stack.remove(stack.size()-1);
                i++;
            }
            else if(str.charAt(i)=='/' && i+1<len && str.charAt(i+1)=='/'){
                while(i<len && str.charAt(i)!='\n'){
                    i++;
                }
            }
        }
        
        return stack.size()==0;
    }
}