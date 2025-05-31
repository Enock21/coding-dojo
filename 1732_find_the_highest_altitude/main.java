class Solution {
    public static int largestAltitude(int[] gain) {
        int[] result = new int[gain.length + 1];
        int max = -100;
        result[0] = 0;
        for (int i = 0; i < gain.length - 1; i++){
            result[i+1] = result[i] + gain[i];
        }
        for (int i = 0; i < result.length; i++){
            if (result[i] > max) max = result[i];
        }
        return max;

    }
}

class Main{
    public static void main(String[] args) {
        System.out.println(Solution.largestAltitude(new int[]{44,32,-9,52,23,-50,50,33,-84,47,-14,84,36,-62,37,81,-36,-85,-39,67,-63,64,-47,95,91,-40,65,67,92,-28,97,100,81}));
    }
}