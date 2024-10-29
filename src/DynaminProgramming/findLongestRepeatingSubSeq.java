package DynaminProgramming;// Java program to find the longest
// repeating subsequence
import java.io.*;
import java.util.*;

class LRS
{
    // Function to find the longest repeating subsequence
    static int findLongestRepeatingSubSeq(String str)
    {
        String str1 = new String(str);
        int m = str.length();
        int n = str1.length();
        int[][] dp = new int[m+1][n+1];
        // for(int[] d : dp){
        //     Arrays.fill( d, -1);
        // }
        // Arrays.fill(dp[0] , 0);
        // for(int i = 0 ; i <=m;i++){
        //     dp[i][0] = 0;
        // }
        for(int i = 1 ; i <=m ; i++ ){
            for(int j = 1 ; j<=n ; j++){
                if(str.charAt(i-1) == str1.charAt(j-1) && i!=j){
                    dp[i][j] = 1+ dp[i-1][j-1];
                }else{

                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }

    // driver program to check above function
    public static void main (String[] args)
    {
        String str = "aabb";
        System.out.println("The length of the largest subsequence that"
                +" repeats itself is : "+findLongestRepeatingSubSeq(str));
    }
}

// This code is contributed by Pramod Kumar
