package DynaminProgramming;

import java.util.Arrays;

class R25_LongestCommonSubstring {
//    public static int lcSubStr(String s1, String s2) {
//       int m = s1.length();
//       int n = s2.length();
//       return findsub(s1,s2,m , n, 0 );
//    }
//
//    static int findsub(String s1, String s2, int i, int j, int l){
//        if(i ==0 || j==0) return l;
//        int f = Integer.MIN_VALUE;
//        if(s1.charAt(i-1) ==s2.charAt(j-1)){
//             return findsub(s1,s2,i-1,j-1,l+1);
//        }else{
//              f = Math.max(findsub(s1,s2,i,j-1,0), findsub(s1,s2,i-1,j,0));
//        }
//        return Math.max(l,f);
//    }
    static int[][] dp;
     public static int lcSubStr(String s1, String s2) {

         int m = s1.length();
         int n = s2.length();
         dp = new int[m+1][n+1];
         for(int[] d : dp){
             Arrays.fill(d,-1);
         }
         Arrays.fill(dp[0] , 0);
         for(int i = 0 ; i <=m;i++){
             dp[i][0] = 0;
         }
         int result = Integer.MIN_VALUE;
         for(int i = 1 ; i <=m ; i++ ){
             for(int j = 1 ; j<=n ; j++){
                 if(s1.charAt(i-1) == s2.charAt(j-1)){
                     dp[i][j] = 1+ dp[i-1][j-1];
                     result = Math.max(result,dp[i][j]);
                 }else{
                     dp[i][j] = 0;
                 }
             }
         }
         return result;

    }




    public static void main(String[] args) {

        String s1 = "abcdbc";
        String s2 = "afbcdgb";

        System.out.println(lcSubStr(s1, s2)); //3
    }
}