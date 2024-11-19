/*
Implement a function calculate_total_balance that accepts a list of N transaction 
amounts and the number of threads as input. The function should divide the 
transactions equally among the specified number of threads, where each thread 
processes its assigned transactions and computes the partial balance. 

The function should then aggregate the partial balances from all threads and 
return the total balance. Ensure proper synchronization to prevent data 
inconsistencies.

Sample Input:
-------------
10          // N transactions
150 -50 200 -100 250 -75 300 -125 400 -200      // amounts[]
3           //threads

Sample Output:
--------------
750


*/


import java.util.*;

class BalanceCalculator extends Thread{
    
    int [] amounts;
    int start;
    int end;
    int partialAmount ;
    BalanceCalculator(int [] amounts, int start, int end){
        this.amounts = amounts;
        this.start = start;
        this.end = end;
    }
    @Override
    public void run() {
        for (int i = start; i < end; i++) {
            partialAmount+=amounts[i];
        }
    }

    public int getPartialAmount() {
        return partialAmount;
    }

}
public class Day19P2 {
    public static int calculate_total_balance(int n , int [] amounts, int threads){
        int result  = 0;
        List<BalanceCalculator> calculators = new ArrayList<>();
        int length = amounts.length;
        int chunkSize = (int)Math.ceil((double)length/threads);
        for (int i = 0; i < threads; i++) {
            int start = i*chunkSize;
            int end = Math.min(start+chunkSize,length);
            BalanceCalculator calculator = new BalanceCalculator(amounts, start, end);
            calculators.add(calculator);
            calculator.start();
        }

        for (BalanceCalculator balanceCalculator : calculators) {
            try{
                balanceCalculator.join();
                result+=balanceCalculator.getPartialAmount();
            }
            catch(Exception e){
                e.getMessage();
            }
        }
               

        return result;
    }
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        cin.nextLine();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = cin.nextInt();
        }
        int threads = cin.nextInt();
        System.out.println(calculate_total_balance(n,arr,threads));
    }
}
