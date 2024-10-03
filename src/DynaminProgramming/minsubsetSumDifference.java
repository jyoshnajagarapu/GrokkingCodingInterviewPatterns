package DynaminProgramming;

import java.util.*;

 class Difference {

    // Function to find the minimum sum

     //using recursion

//    public static int findMinRec(int[] arr, int i, int sumCalculated, int sumTotal) {
//        if(i ==0 ){
//            return Math.abs(sumCalculated - (sumTotal-sumCalculated));
//        }
//        return Math.min(findMinRec(arr,i-1,arr[i-1] + sumCalculated,sumTotal) , findMinRec(arr,i-1,sumCalculated,sumTotal));
//    }
//
//    // Returns the minimum possible difference between sums of two subsets
//    public static int findMin(int[] arr) {
//        int total = 0 ;
//        int n = arr.length;
//        for(int a : arr){
//            total += a;
//        }
//        return findMinRec(arr,n , 0, total);
//    }
//
//    public static void main(String[] args) {
//        int[] vec = {3, 1, 4, 2, 2, 1};
//        System.out.println("The minimum difference of 2 sets is " + findMin(vec));
//    }

     //using memoization

//     public static int findMinRec(int[] arr, int i, int sumCalculated, int sumTotal, int[][] dp) {
//             if(dp[i][sumCalculated] != -1 ) return dp[i][sumCalculated];
//             if(i ==0 ){
//                 return Math.abs(sumCalculated - (sumTotal-sumCalculated));
//             }
//             dp[i][sumCalculated] = Math.min(findMinRec(arr,i-1,arr[i-1] + sumCalculated,sumTotal,dp) , findMinRec(arr,i-1,sumCalculated,sumTotal,dp));
//             return dp[i][sumCalculated];
//         }
//
//         // Returns the minimum possible difference between sums of two subsets
//         public static int findMin(int[] arr) {
//             int total = 0 ;
//             int n = arr.length;
//             for(int a : arr){
//                 total += a;
//             }
//             int[][] dp = new int[n+1][total+1];
//             for(int[] a : dp){
//                 Arrays.fill(a,-1);
//             }
//             return findMinRec(arr,n , 0, total,dp);
//         }
//
//         public static void main(String[] args) {
//             int[] vec = {3, 1, 4, 2, 2, 1};
//             System.out.println("The minimum difference of 2 sets is " + findMin(vec));
//     }

     // using tabulization


     // Returns the minimum possible difference between sums of two subsets
     public static int findMin(int[] arr) {
         int total = 0 ;
         int n = arr.length;
         for(int a : arr){
             total += a;
         }
         int[][] dp = new int[n+1][total+1];
         for(int[] a : dp){
             Arrays.fill(a,-1);
         }
         Arrays.fill(dp[0], 0);
         for(int i = 0 ; i<=n ; i++){
             dp[i][0] = 1;
         }
         for(int i = 1; i <=n ; i++){
             for(int j = 1; j<=total ; j++){
                 if(arr[i-1] <= j){
                     dp[i][j] = dp[i-1][j-arr[i-1]] ==1  || dp[i-1][j] == 1 ? 1:0;
                 }else{
                     dp[i][j] = dp[i-1][j];
                 }
             }
         }
         int result = Integer.MAX_VALUE;
         for(int i = total/2 ; i >=0 ; i--){
             if(dp[n][i] ==1){
                 result = Math.min(result,Math.abs(i - (total- i) ));
             }

         }
         return result;
     }

     public static void main(String[] args) {
         int[] vec = {3, 1, 4, 2, 2, 1};
         System.out.println("The minimum difference of 2 sets is " + findMin(vec));
     }
}
