/*In a prestigious Collaborative Innovation Summit, there are two key sessions: 
Artificial Intelligence (AI) and Sustainability (SUS). Teams for these sessions 
must adhere to strict size requirements:
    - Session AI: Each team participating in this session must have exactly 
      'TA' members.
    - Session SUS: Each team participating in this session must have exactly 
      'TS' members.

The total number of participants attending the summit is TP.

Your task is to determine the minimum number of teams needed to accommodate all 
participants such that:
    - Each participant is assigned to exactly one team.
    - Each team confirms to the size requirements of either the AI or the SUS 
      session.
If it is not possible to assign all participants into teams while meeting these 
criteria, return -1.

Input Format:
-------------
Three space sepaarted integers, TP, TA, TS

Output Format:
--------------
A single integer representing the minimum number of teams required to allocate 
all participants


Sample Input-1:
---------------
50 5 8

Sample Output-1:
----------------
7

Explanation:
------------
5 teams of size 8 → 5×8=40 participants.
2 teams of size 5 → 2×5=10 participants.
The total is: 40+10=50 (Total:50 participants,all accounted for).


Sample Input-2:
---------------
23 5 6

Sample Output-2:
----------------
4

Explanation:
------------
3 teams of size 6 → 3×6=18 participants.
1 teams of size 5 → 1×5=5 participants.
The total is: 18+5=23 (Total:23 participants,all accounted for).
 */
import java.util.*;
public class Day45P2 {

    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) {
        
        Scanner cin = new Scanner(System.in);
        int TP = cin.nextInt();
        int TA = cin.nextInt();
        int TS = cin.nextInt();

        int res = minTeams(TP,TA,TS);
        System.out.println(res);
        cin.close();
    }
    static int minTeams(int TP , int TA , int TS ){
        int min = Integer.MAX_VALUE;
        for(int ts = 0; ts <= (TP/TS) ; ts++){
            int remaining = TP - ts*TS;
            if(remaining%TA==0){
                int ta = remaining/TA;
                min = Math.min(min , (ta+ts)); 
            }
        }
        return (min==Integer.MAX_VALUE)? -1 : min;
    }
    // static int minTeams(int TP , int TA , int TS){
    //     backtrack(TP,TA,TS,0,0,0,0);
    //     return min;
    // }
    // static void backtrack(int TP , int TA , int TS, int participants, int teams , int taCount, int tsCount){
    //     if(participants>TP){
    //         return;
    //     }
    //     if(teams>min){
    //         return;
    //     }
    //     if(participants==TP){
    //         if(min>teams){
    //             System.out.println(" The Ta count :"+ taCount + " Ts Count " + tsCount);
    //             min = teams;
    //         }
    //         return;
    //     }
    //     backtrack(TP, TA, TS, participants + TA, teams + 1, taCount+1 , tsCount);
    //     backtrack(TP, TA, TS, participants + TS, teams + 1 , taCount , tsCount+1);
    // }
}
