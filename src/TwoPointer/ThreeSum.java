package TwoPointer;

//In the solution above, sorting the array takes O(nlog(n)) and the nested loop takes O(n2) to find the triplet. Here, n is the number of elements in the input array. Therefore, the total time complexity of this solution is O(nlog(n)+n2), which simplifies to O(n2).
//Space complexity
//The space complexity of this solution, primarily, depends on the sorting algorithm we use. We use the built-in Java function, Arrays.sort(), so the space complexity of the provided solution is O(log(n)).
import java.util.*;


//find all possible 3sum sets
public class ThreeSum {
    public static void main(String[] args){
        List<List<Integer>> result = new ArrayList<>();
        result = threeSum(new int[]{-1,0,1,2,-1,-4});
        for(List<Integer> a: result){
            System.out.println(a);
        }
        int[][] numsList = {{3, 7, 1, 2, 8, 4, 5},
                {-1, 2, 1, -4, 5, -3},
                {2, 3, 4, 1, 7, 9},
                {1, -1, 0},
                {2, 4, 2, 7, 6, 3, 1}};

        int[] testList = {10, 7, 20, -1, 8};


        for (int i=0; i<testList.length; i++) {
            System.out.print(i+1);
            System.out.println(".\tInput array: " + Arrays.toString(numsList[i]));

            if (findSumOfThree(numsList[i], testList[i])) {
                System.out.println("\tSum for " + testList[i] + " exists ");
            } else {
                System.out.println("\tSum for " + testList[i] + " does not exist ");
            }

            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

    }
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Set<List<Integer>> temp = new HashSet<>();
        Arrays.sort(nums);
        for(int i=0 ; i <nums.length-2; i++){
            int left = i+1;
            int right = nums.length-1;
            while(left<right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum < 0 ) left++;
                else if(sum > 0) right--;
                else if (sum == 0 && left != i && right != i ){
                    temp.add(new ArrayList<>(List.of(nums[i] , nums[left], nums[right])));
                    left++;
                    right--;
                }
            }
        }
        result.addAll(temp);
        return result;
    }



    //find if any set exists
    public static boolean findSumOfThree(int[] nums, int target) {
        Arrays.sort(nums);
        for(int i = 0; i < nums.length-2 ; i++){
            int start = i+1;
            int end = nums.length -1;
            while(start < end){
                int sum = nums[i] + nums[start] + nums[end];
                if(sum == target ) return true;
                else if(sum < target) start++;
                else end--;
            }
        }
        return false;
    }



}
