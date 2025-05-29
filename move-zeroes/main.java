
//https://leetcode.com/problems/move-zeroes/submissions/1648178724/?envType=study-plan-v2&envId=leetcode-75

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution1 {
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

class Solution2 {
    public static void moveZeroes(int[] nums) {
        List<Integer> naoZeros = new ArrayList<>();
        List<Integer> zeros = new ArrayList<>();
        int tam = nums.length;
        for(int i = 0; i < tam; i++){
            if (nums[i] == 0) zeros.add(0);
            else naoZeros.add(nums[i]);
        }

        int i = 0;
        for(int num : naoZeros){
            nums[i++] = num;
        }
        for(int zero : zeros){
            nums[i++] = zero;
        }
    }
}

class Main {
    public static int[] nums = new int[]{0,1,0,3,12,0};

    public static void main(String[] args){
        Solution2.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
    
}
