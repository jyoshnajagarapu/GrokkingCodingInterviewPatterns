package stack;
//https://leetcode.com/problems/trapping-rain-water/
import java.util.*;

// Function to find the maximum amount of water that can be trapped
class GfG {
    //brute force using left and and right max
    // public int trap(int[] height) {
    //     int res = 0;
    //     int n = height.length;
    //     int[] leftmax = new int[n];
    //     int[] rightmax = new int[n];
    //     for(int i = 1; i < n ; i++){
    //         leftmax[i] = Math.max(leftmax[i-1], height[i-1]);
    //     }
    //     for(int i = n-2; i>=0;i--){
    //         rightmax[i] = Math.max(rightmax[i+1],height[i+1]);
    //     }

    //     for(int i = 0 ; i<n;i++){
    //         int temp = Math.min(leftmax[i],rightmax[i]) - height[i];
    //         res+= temp > 0 ? temp : 0;
    //     }

    //     return res;

    // }

    static int trap(int[] height) {
        int n = height.length;
        int l = 0, r = n-1;
        int res = 0 ;
        int leftmax = height[l],  rightmax = height[r];
        while(l < r){
            if(leftmax <= rightmax){
                l++;
                leftmax = Math.max(leftmax, height[l]);
                res+= leftmax-height[l];
            }else{
                r--;
                rightmax = Math.max(rightmax,height[r]);
                res+= rightmax-height[r];
            }
        }

        return res;
    }

    // Driver program
    public static void main(String[] args) {
        int[] arr = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        System.out.println(trap(arr));
    }
}
