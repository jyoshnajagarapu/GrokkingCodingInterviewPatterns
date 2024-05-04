package TwoPointer;
//Time complexity
//The time complexity is O(n) where is the number of characters in the string. However, our algorithm will only run (n/2) times, since two pointers are traversing toward each other.
//Space complexity The space complexity is O(1) since we use constant space to store two indexes.
public class Palindrome {
    public static void main(String[] args){
        String pal = "abba";
        System.out.println(isPalindrome(pal));
        String[] testCase = {
                "RACEACAR",
                "A",
                "ABCDEFGFEDCBA",
                "ABC",
                "ABCBA",
                "ABBA",
                "RACEACAR"
        };
        for (int k = 0; k < testCase.length; k++) {
            System.out.println("Test Case #" + (k + 1));
            System.out.println(new String(new char[100]).replace('\0', '-'));
            System.out.println("The input string is " + testCase[k] + "' and the length of the string is " + testCase[k].length() + ".");
            System.out.println("\nIs it a palindrome?..... " + isPalindrome(testCase[k]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }

    public static boolean isPalindrome(String s) {

        // Replace this placeholder return statement with your code
        int one = 0;
        int two = s.length() - 1;
        while(one <= two){
            if(s.charAt(one) != s.charAt(two)) return false;
            one++;
            two--;
        }
        return true;
    }
}
