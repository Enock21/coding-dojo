
import java.util.Arrays;

class Solution {
    public static void moveZeroes(int[] nums) {
        int a = nums.length -1;
        int b = nums.length -1;
        while (a >= 0){
            if (nums[a] == 0 &&
            a < nums.length - 1){
                while(b < nums.length - 1 &&
                nums[b+1] != 0){
                    int p = nums[b+1];
                    nums[b+1] = nums[b];
                    nums[b] = p;
                    b++;
                }
                b = a;
            }
            b--;
            a--;
        }
    }
}

class Main {
    public static int[] nums = new int[]{0,1,0,3,12,0};

    public static void main(String[] args){
        Solution.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
    
}
