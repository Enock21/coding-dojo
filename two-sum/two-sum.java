/*
 * https://leetcode.com/problems/two-sum/
 */

import java.util.HashMap;
import java.util.Map;

class Solution {
    /* Solução força bruta */
    // public static int[] twoSum(int[] nums, int target) {
    //     for(int i = 0; i < nums.length; i++){
    //         for(int j = i + 1; j < nums.length; j++){
    //             if (nums[i] + nums[j] == target){
    //                 return new int[]{i, j};
    //             };
    //         }
    //     }
    //     return new int[]{};
    // }

    /* Solução errada com hashmap e dois laços. Falta verificação <&& map.get(complement) != i>*/
    // public static int[] twoSum(int[] nums, int target) {
    //     Map<Integer, Integer> map = new HashMap<>();
    //     for (int i = 0; i < nums.length; i++){
    //         map.put(nums[i], i);
    //     };
    //     for (int i = 0; i < nums.length; i++){
    //         int complement = target - nums[i];
    //         if(map.containsKey(complement)){
    //             return new int[]{i, map.get(complement)};
    //         }
    //     }
    //     return new int[]{};
    // }
    /*
     * A H
     * V K: 3 2 4
     * I V: 0 1 2
     */

    /* Solução com hashmap e dois laços*/
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            map.put(nums[i], i);
        };
        for (int i = 0; i < nums.length; i++){
            int complement = target - nums[i];
            if(map.containsKey(complement) && map.get(complement) != i){
                return new int[]{i, map.get(complement)};
            }
        }
        return new int[]{};
    }

    /* Solução com hashmap e um laço 
     * É possível fazer funcionar com valor sendo valor e índice sendo chave no hashmap?
    */
    // public static int[] twoSum(int[] nums, int target){
    //     Map<Integer, Integer> map = new HashMap<>();
    //     for(int i = 0; i < nums.length; i++){
    //         int complement = target - nums[i];
    //         if (map.containsKey(complement)){
    //             return new int[]{i, map.get(complement)};
    //         }
    //         map.put(nums[i], i);
    //     }
    //     return new int[]{};
    // }
}

class Main{
    public static void main(String[] args){
        // int[] nums = new int[]{4, 1, 3, 2, 5};
        // int target = 3;

        // int[] nums = new int[]{3, 3};
        // int target = 6;

        int[] nums = {3, 2, 4};
        int target = 6;

        int[] result = Solution.twoSum(nums, target);

        System.out.println(result[0] + " e " + result[1]);
        //Resposta esperada: 1 e 2
    }
}