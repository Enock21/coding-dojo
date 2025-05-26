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
    // public static int[] twoSum(int[] nums, int target) {
    //     Map<Integer, Integer> map = new HashMap<>();
    //     for (int i = 0; i < nums.length; i++){
    //         map.put(nums[i], i);
    //     };
    //     for (int i = 0; i < nums.length; i++){
    //         int complement = target - nums[i];
    //         if(map.containsKey(complement) && map.get(complement) != i){
    //             return new int[]{i, map.get(complement)};
    //         }
    //     }
    //     return new int[]{};
    // }

    /* Solução com hashmap e um laço 
     * É possível fazer funcionar com valor do array nums sendo valor no hashmap map e índice do array nums sendo chave no hashmap map?
    */
    public static int[] twoSum(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int complement = target - nums[i];
            if (map.containsKey(complement)){
                return new int[]{i, map.get(complement)};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }
    /*
    OBS1: Map é construído como uma estrutura de pilha? NÃO! Parece que ele itera sobre os elementos na ordem inversa as vezes. Mas na verdade essa ordem parece aleatória e é sujeita a mudanças conforme o código executa.

    OBS2: A ordem dos valores retornados pode sair diferente nessa versão

    E se invertermos o papel das chaves e valores?
    map.put(i, nums[i]);  // índice como chave, valor como valor
    Isso não funciona. Veja por quê:

    O objetivo do hashmap nesse problema é encontrar rapidamente o índice de um valor que completa o target.

    Se usamos o índice como chave, perdemos a capacidade de buscar rapidamente um valor (por exemplo, map.containsKey(complement) se torna impossível, porque complement seria um valor, não um índice).
    */
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