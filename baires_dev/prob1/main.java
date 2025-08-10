class Solution1{
    public static int function(int N, String S, String[] comments){
        String SMinusculo = S.toLowerCase();
        int result = 0;

        for (String str : comments){
            String strMinusculo = str.toLowerCase();
            int a = 0;
            for (int i = 0; i < str.length(); i++){
                if(SMinusculo.charAt(a) == strMinusculo.charAt(i)){
                    a++;
                    if(a == S.length()){
                        a = 0;
                        result++;
                        break;
                    }
                }else{
                    a = 0;
                }
            }
        }

        return result;
    }
}

class Main{
    public static void main(String[] args){
        System.out.println(Solution1.function(2, "bad", new String[]{"The_video_is_BAD","bad_bad_bad"}));
    }
}