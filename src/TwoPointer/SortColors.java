package TwoPointer;
import java.util.*;
public class SortColors {
    public static void main(String[] args) {
        int[][] inputs = {
                {0, 1, 0},
                {1, 1, 0, 2},
                {2, 1, 1, 0, 0},
                {2, 2, 2, 0, 1, 0},
                {2, 1, 1, 0, 1, 0, 2}
        };

        for (int i = 0; i < inputs.length; i++) {
            int[] sortedColors = sortColors(inputs[i].clone());
            System.out.println("\n\tThe sorted array is: " + Arrays.toString(sortedColors));
        }
    }
    public static int[] sortColors(int[] colors) {
        int start = 0;
        int current = 0;
        int end = colors.length -1;
        while(current<=end){
            if(colors[current] == 0 ){
                if(colors[start] != 0){
                    int temp = colors[start];
                    colors[start] = 0;
                    colors[current] = temp;
                }
                start++;
                current++;
            }else if(colors[current] == 1) current++;
            else if(colors[current] == 2){
                if(colors[end] != 2){
                    int temp = colors[end];
                    colors[current] = temp;
                    colors[end] = 2;
                }
                end--;


            }
        }

        return colors;
    }


}
