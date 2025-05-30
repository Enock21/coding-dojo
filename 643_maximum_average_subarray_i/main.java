//https://leetcode.com/problems/maximum-average-subarray-i/?envType=study-plan-v2&envId=leetcode-75

class Solution {
    public static double findMaxAverage(int[] nums, int k) {
        int soma = 0;
        double max = -10000.0;
        int limiteEsq = 0;
        int limiteDir = k - 1;
        while(limiteDir < nums.length){
            for (int i = limiteEsq; i <= limiteDir; i++){
                soma += nums[i];
            }
            double media = (double) soma / k;
            soma = 0;
            if (media > max) max = media; 
            limiteEsq++;
            limiteDir++;
        }
        return max;
    }
}

class Main{
    public static void main(String[] args){
        System.out.println(Solution.findMaxAverage(new int[]{1,12,-5,-6,50,3}, 4));
    }
}