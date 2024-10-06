package DynaminProgramming;

import java.util.Arrays;

class Solution1{
    static int[][] dp ;
    static int matrixMultiplication(int N, int arr[])
    {
        dp = new int[N][N];
        for(int[] d: dp){
            Arrays.fill(d, -1);
        }

        return solve(arr, 0, N-1);
    }

    static int solve(int[] arr, int i , int j){
        if(i+1== j ) return 0 ;
        if(dp[i][j] != -1) return dp[i][j];
        int result = Integer.MAX_VALUE;
        for(int k = i+1; k<j ; k++){
            int min =  solve(arr,i,k) + solve(arr,k,j) + arr[i] * arr[k] * arr[j];
            result = Math.min(result,min);
        }
        dp[i][j] = result;
        return dp[i][j];
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 3};
        System.out.println(matrixMultiplication( 5, arr));
    }
}

