package DynaminProgramming;

import java.io.*;
import java.util.*;

class GFG {
    static int[][][] dp;
    public static int countWays(int n, String s)
    {
        dp = new int[n][n][2];
        for(int[][] a : dp){
            for(int[] b : a)
                Arrays.fill(b,-1);
        }
        return count(s,0,n-1, 1);
    }

    static int count(String s, int i , int j , int istrue){
        if(i > j) return 0 ;
        if(i == j){
            if(istrue == 1){
                return s.charAt(i) == 'T' ? 1:0;
            }else{
                return s.charAt(i) == 'F' ? 1 : 0;
            }
        }
        if(dp[i][j][istrue] != -1) return  dp[i][j][istrue];
        int result = 0 ;
        for(int k = i+1 ; k<j ; k+=2){
            int lt = count(s,i, k-1, 1);
            int lf = count(s,i, k-1, 0);
            int rf = count(s,k+1, j ,0);
            int rt = count(s,k+1,j, 1);

            if(s.charAt(k) == '|'){
                if(istrue == 1){
                    result += lt * rt  + lt * rf + rt * lf;
                }else{
                    result += lf * rf;
                }
            } else if(s.charAt(k) == '&'){
                if(istrue == 1){
                    result += lt * rt;
                }else{
                    result += lt * rf + rt * lf + lf * rf;
                }
            } else if(s.charAt(k) == '^'){
                if(istrue == 1){
                    result += lt * rf + rt * lf;
                }else{
                    result += lf * rf + lt * rt;
                }
            }
        }
        dp[i][j][istrue] = result;
        return dp[i][j][istrue];

    }


    // Driver code
    public static void main(String[] args)
    {
        String symbols = "TTFT";
        String operators = "|&^";
        StringBuilder S = new StringBuilder();
        int j = 0;

        for (int i = 0; i < symbols.length(); i++)
        {
            S.append(symbols.charAt(i));
            if (j < operators.length())
                S.append(operators.charAt(j++));
        }

        // We obtain the string T|T&F^T
        int N = S.length();

        // There are 4 ways
        // ((T|T)&(F^T)), (T|(T&(F^T))), (((T|T)&F)^T) and
        // (T|((T&F)^T))
        System.out.println(countWays(N, S.toString()));
    }
}

// This code is contributed by farheenbano.
