//https://leetcode.com/problems/maximum-average-subarray-i/?envType=study-plan-v2&envId=leetcode-75

class Solution1 {
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

class Solution2 {
    public static double findMaxAverage(int[] nums, int k) {
        int limiteEsq = 0;
        int limiteDir = k - 1;
        int soma = 0;
        double media;
        double max;

        for(int i = 0; i <= limiteDir; i++){
            soma += nums[i];
        }

        max = (double) soma / k;

        while(limiteDir < nums.length - 1){
            soma -= nums[limiteEsq++];
            soma += nums[++limiteDir];
            media = (double) soma / k;
            if (media > max) max = media;
        }

        return max;
    }
}

class Solution3{
    public static double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        // Calcula a soma dos primeiros k elementos
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int maxSum = sum;
        // Desliza a janela pelo array
        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i - k];//Qual a lógica matemática por trás desse i-k?
            if (sum > maxSum) {
                maxSum = sum;
            }
        }
        return (double) maxSum / k;
    }
}

class Main{
    public static void main(String[] args){
        System.out.println(Solution3.findMaxAverage(new int[]{1,12,-5,-6,50,3}, 4));
    }
}