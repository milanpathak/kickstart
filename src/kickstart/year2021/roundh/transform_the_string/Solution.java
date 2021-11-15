package kickstart.year2021.roundh.transform_the_string;
//https://codingcompetitions.withgoogle.com/kickstart/round/0000000000435914/00000000008da461
//  a w g l
//l

import java.io.*;
import java.util.*;

public class Solution {


    public static void main(String[] args) {
		/*for(int i=0; i<26; i++){
			System.out.println("i = "+i +" char = "+(char)(i+97));
		}*/
        Solution d = new Solution();
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(in.nextLine()); // Scanner has functions to
        // read ints, longs,
        // strings, chars, etc.
        for (int i = 1; i <= t; i++) {
            String S = in.nextLine();
            // System.out.println(S);
            String F = in.nextLine();
            // System.out.println(F);
            System.out.println("Case #" + i + ": " + d.numsOfOperationsPerformed(S, F));
        }
    }

    int numsOfOperationsPerformed(String S, String F){
        int ans = 0;
        int totalCharRange = 26;
        int [] minOperationMapForEachChar = new int[totalCharRange];
        for(int i=0; i<totalCharRange; i++ ){
            minOperationMapForEachChar[i] = totalCharRange + 1;
        }
        for(int i=0; i<S.length(); i++){
            int charFromS = S.charAt(i);
            int minNumOfOps = minOperationMapForEachChar[charFromS - 97];
            if(minNumOfOps < 27){
                ans = ans+ minNumOfOps;
                continue;
            }
            for(int j=0; j<F.length(); j++){
                //System.out.println("inside j");
                int charFromF = F.charAt(j);

                int opesInPreceding = 27;
                int opsInFollowing = 27;
                //if(charFromS - charFromF >= 0 ){
                opesInPreceding = charFromS - charFromF > 0 ? (charFromS - charFromF) : (charFromS - charFromF + 26)%26;
                //}else{
                opsInFollowing = (charFromF - charFromS) > 0 ? (charFromF - charFromS) : (charFromF - charFromS + 26)%26;
                //}
                int minHere = opesInPreceding < opsInFollowing ? opesInPreceding : opsInFollowing;

                if(minHere < minNumOfOps){
                    minNumOfOps = minHere;
                    minOperationMapForEachChar[charFromS - 97] = minNumOfOps;
                }
            }
            ans = ans + minNumOfOps;
        }
        return ans;
    }
}