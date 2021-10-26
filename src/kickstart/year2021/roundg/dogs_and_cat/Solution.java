package kickstart.year2021.roundg.dogs_and_cat;

import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Solution d = new Solution();
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(in.nextLine()); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; i++) {
            String S0 = in.nextLine();
            //System.out.println(S0);
            int N = Integer.parseInt(S0.split(" ")[0]);   //total number of animals
            int D = Integer.parseInt(S0.split(" ")[1]);   //number of Dogs
            int C = Integer.parseInt(S0.split(" ")[2]);   //number of Cats
            int M = Integer.parseInt(S0.split(" ")[3]);   //number of Cats portion to bring extra
            String S = in.nextLine();
            //System.out.println(S);
            if(d.ifAllTheDogsWillBeFed(N,D,C, M, S)){
                System.out.println("Case #" + i + ": " +  "YES");
            }else{
                System.out.println("Case #" + i + ": " +  "NO");
            }

        }
    }

    boolean ifAllTheDogsWillBeFed(int N,int D,int C,int M, String S){
        boolean ifAllTheDogsWillBeFed = false;
        int maxNumPortions = 1000000;
        if(!S.contains("D")){
            return true;
        }
        for(int i=0; i<N; i++){
            char animal = S.charAt(i);
            if(animal == 68 && D>0){
                D--;
                C = C+M > maxNumPortions ? maxNumPortions : C+M;
                //above condition will limit the count so it cannot grow beyond range of integer
            }else if(animal == 67 && C>0){
                C--;
            }else{
                //if no dogs left in remaining substring then return true
                if(!S.substring(i).contains("D")){
                    return true;
                }
                return false;
            }
        }
        ifAllTheDogsWillBeFed = true;
        return ifAllTheDogsWillBeFed;
    }
}
