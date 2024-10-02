package DynaminProgramming;

import java.util.Arrays;

class Solution{
    static int[][] dp ;
    public static int perfectSum(int arr[],int n, int sum)
    {
        dp = new int[n+1][sum+1];
        for(int[] a :dp){
            Arrays.fill(a , -1);
        }
        findsum(sum,arr,n);
        System.out.println(dp[n][sum]);
        return dp[n][sum];
        // Your code goes here
    }
    static int findsum(int sum , int[] nums, int n){
        if(dp[n][sum] != - 1) return dp[n][sum];
        if(sum == 0) return 1 ;
        if(n == 0 ) return 0 ;
        if(nums[n- 1] <= sum){
            dp[n][sum] = findsum(sum-nums[n-1], nums, n-1) + findsum(sum,nums,n-1) ;
        }else{
            dp[n][sum] = findsum(sum,nums,n-1);
        }
        return dp[n][sum];

    }

    public static void main(String[] args)
    {
        int set[] = { 1, 2, 3, 4, 5 };
        perfectSum(set, 5, 9);
    }
}