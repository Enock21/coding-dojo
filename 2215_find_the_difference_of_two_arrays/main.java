//https://leetcode.com/problems/find-the-difference-of-two-arrays/description/?envType=study-plan-v2&envId=leetcode-75

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

class Solution1 {
    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();
        List<HashMap<Integer, Integer>> answer = new ArrayList<>();
        answer.add(new HashMap<>());
        answer.add(new HashMap<>());
        for (int i = 0; i < nums1.length; i++){
            map1.put(nums1[i], i);
        }
        for (int i = 0; i < nums2.length; i++){
            map2.put(nums2[i], i);
        }
        for (int i = 0; i < nums1.length; i++){
            if (!map2.containsKey(nums1[i]) && !answer.get(0).containsKey(nums1[i])){
                answer.get(0).put(nums1[i], i);
            }
        }
        for (int i = 0; i < nums2.length; i++){
            if (!map1.containsKey(nums2[i]) && !answer.get(1).containsKey(nums2[i])){
                answer.get(1).put(nums2[i], i);
            }
        }

        List<List<Integer>> retorno = new ArrayList<>();
        retorno.add(new ArrayList<>(answer.get(0).keySet()));
        retorno.add(new ArrayList<>(answer.get(1).keySet()));
        return retorno;

    }
}

//Solução com HashSet em vez de HashMap, permitindo pular a etapa de verificação para elementos repetidos, coisa que o HashSet já resolve por padrão.
class Solution2 {
    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        List<HashSet<Integer>> answer = new ArrayList<>();
        answer.add(new HashSet<>());
        answer.add(new HashSet<>());
        for (int i = 0; i < nums1.length; i++){
            set1.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++){
            set2.add(nums2[i]);
        }
        for (int i = 0; i < nums1.length; i++){
            if (!set2.contains(nums1[i])){
                answer.get(0).add(nums1[i]);
            }
        }
        for (int i = 0; i < nums2.length; i++){
            if (!set1.contains(nums2[i])){
                answer.get(1).add(nums2[i]);
            }
        }

        List<List<Integer>> retorno = new ArrayList<>();
        retorno.add(new ArrayList<>(answer.get(0)));
        retorno.add(new ArrayList<>(answer.get(1)));
        return retorno;

    }
}

//Solução que diminui um laço. No segundo laço já é feita a verificação que na solução 2 era feita no quarto laço: verificar se no conjunto 2 existe elementos não contidos no conjunto 1 e adicioná-los a resposta final se for o caso.
class Solution3 {
    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        List<HashSet<Integer>> answer = new ArrayList<>();
        answer.add(new HashSet<>());
        answer.add(new HashSet<>());
        for (int i = 0; i < nums1.length; i++){
            set1.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++){
            set2.add(nums2[i]);
            if (!set1.contains(nums2[i])){
                answer.get(1).add(nums2[i]);
            }
        }
        for (int i = 0; i < nums1.length; i++){
            if (!set2.contains(nums1[i])){
                answer.get(0).add(nums1[i]);
            }
        }

        List<List<Integer>> retorno = new ArrayList<>();
        retorno.add(new ArrayList<>(answer.get(0)));
        retorno.add(new ArrayList<>(answer.get(1)));
        return retorno;

    }
}

//Substituindo a lista de hashsets "answer" por duas variáveis HashSet para armazenar números que estao somente em seus respectivos conjuntos. Melhora legibilidade e um pouco a eficiência.
class Solution4 {
    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();

        HashSet<Integer> onlyInNums1 = new HashSet<>();
        HashSet<Integer> onlyInNums2 = new HashSet<>();

        //Itera em nums1 e constrói seu hashset
        for (int i = 0; i < nums1.length; i++){
            set1.add(nums1[i]);
        }
        //Itera em nums2, construindo seu hashset e simultaneamente adicionando os elementos que estão em set2 mas não em set1 (hashset onlyInNums2)
        for (int i = 0; i < nums2.length; i++){
            set2.add(nums2[i]);
            if (!set1.contains(nums2[i])){
                onlyInNums2.add(nums2[i]);
            }
        }
        //Itera em nums1 e adiciona os elementos que estão em set1 mas não em set2 (hashset onlyInNums1)
        for (int i = 0; i < nums1.length; i++){
            if (!set2.contains(nums1[i])){
                onlyInNums1.add(nums1[i]);
            }
        }

        List<List<Integer>> retorno = new ArrayList<>();
        retorno.add(new ArrayList<>(onlyInNums1));
        retorno.add(new ArrayList<>(onlyInNums2));
        return retorno;

    }
}

//Usando operações nativas do HashSet em vez de implementá-las manualmente. Menos eficiente do que a solução 4, mas mais bonita e legível.
class Solution5 {
    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        
        for (int num : nums1) set1.add(num);
        for (int num : nums2) set2.add(num);

        HashSet<Integer> onlyInNums1 = new HashSet<>(set1);
        HashSet<Integer> onlyInNums2 = new HashSet<>(set2);

        onlyInNums1.removeAll(set2);
        onlyInNums2.removeAll(set1);

        List<List<Integer>> retorno = new ArrayList<>();
        retorno.add(new ArrayList<>(onlyInNums1));
        retorno.add(new ArrayList<>(onlyInNums2));
        return retorno;

    }
}

class Main{
    public static void main(String[] args){
        System.out.println(Solution5.findDifference(new int[]{1,2,3}, new int[]{2,4,6}));
    }
}