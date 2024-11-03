package stack;

// Java program to print next
// greater element using stack

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

 class MonotonicStack {
    public static int[] previousGreater(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = 0 ; i < n ; i++){
            while(!st.isEmpty() && st.peek() <= nums[i]){
                st.pop();
            }
            if(!st.isEmpty()) result[i] = st.peek();
            else result[i] = -1;
            st.push(nums[i]);
        }
        return result;
    }
     public static int[] previousSmaller(int[] nums) {
         int n = nums.length;
         int[] result = new int[n];
         Stack<Integer> st = new Stack<>();
         for(int i = 0 ; i < n ; i++){
             while(!st.isEmpty() && st.peek() >= nums[i]){
                 st.pop();
             }
             if(!st.isEmpty()) result[i] = st.peek();
             else result[i] = -1;
             st.push(nums[i]);
         }
         return result;
     }
     public static int[] nextGreater(int[] nums) {
         int n = nums.length;
         int[] result = new int[n];
         Stack<Integer> st = new Stack<>();
         for(int i = n-1 ; i >=0 ; i--){
             while(!st.isEmpty() && st.peek() <= nums[i]){
                 st.pop();
             }
             if(!st.isEmpty()) result[i] = st.peek();
             else result[i] = -1;
             st.push(nums[i]);
         }
         return result;
     }
     public static int[] nextSmaller(int[] nums) {
         int n = nums.length;
         int[] result = new int[n];
         Stack<Integer> st = new Stack<>();
         for(int i = n-1 ; i >=0 ; i--){
             while(!st.isEmpty() && st.peek() >= nums[i]){
                 st.pop();
             }
             if(!st.isEmpty()) result[i] = st.peek();
             else result[i] = -1;
             st.push(nums[i]);
         }
         return result;
     }

    public static void main(String[] args) {
        int[] nums = {3, 1, 4, 1, 5, 9, 2, 6};
        int[] result = previousGreater(nums);
        System.out.println("previousGreater: " + Arrays.toString(result));
        result = previousSmaller(nums);
        System.out.println("previousSmaller: " + Arrays.toString(result));
        result = nextGreater(nums);
        System.out.println("nextGreater: " + Arrays.toString(result));
        result = nextSmaller(nums);
        System.out.println("nextSmaller: " + Arrays.toString(result));
    }
}


// Thanks to Rishabh Mahrsee for contributing this code
