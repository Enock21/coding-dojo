
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

class Main{
    public static void main(String[] args){
        System.out.println(Solution2.findDifference(new int[]{1,2,3}, new int[]{2,4,6}));
    }
}