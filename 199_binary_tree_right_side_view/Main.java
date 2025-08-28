import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(){}
    TreeNode(int val){this.val = val;}
    TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution{
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> view = new ArrayList<>();
        if (root == null) return view;

        Deque<TreeNode> q = new ArrayDeque<>();
        q.add(root);

        while (!q.isEmpty()) {
            int levelSize = q.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = q.poll();
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
                if (i == levelSize - 1) { // último do nível = mais à direita
                    view.add(node.val);
                }
            }
        }
        return view;
    }
}

class Solution2 {
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        rightView(root, result, 0);
        return result;
    }
    
    public static void rightView(TreeNode curr, List<Integer> result, int currDepth){
        if(curr == null){
            return;
        }
        if(currDepth == result.size()){
            result.add(curr.val);
        }
        
        rightView(curr.right, result, currDepth + 1);
        rightView(curr.left, result, currDepth + 1);
        
    }
}

//Método recursivo do GPT
class Solution3{
    public static List<Integer> rightSideView(TreeNode root){
        List<Integer> rightmostList = new ArrayList<>();
        rightSideAux(root, rightmostList, 0);

        return rightmostList;
    }

    public static void rightSideAux(TreeNode node, List<Integer> rightmostList, int level){
        if (node == null) return;
        if (level == rightmostList.size()) rightmostList.add(node.val);

        rightSideAux(node.right, rightmostList, level+1);
        rightSideAux(node.left, rightmostList, level+1);
        
    }
}

//Reimplementando solução recursiva do zero
class Solution4{
    public static List<Integer> rightSideView(TreeNode node){
        ArrayList<Integer> view = new ArrayList<>();
        aux(node, 0, view);
        return view;
    }

    public static void aux(TreeNode node, int level, ArrayList<Integer> view){
        if (node == null) return;
        if (level == view.size()) view.add(node.val);
        aux(node.right, level+1, view);
        aux(node.left, level+1, view);
    }

}

public class Main {
    public static void main(String[] args){
        TreeNode caso1 = new TreeNode(1);

        TreeNode caso2 = new TreeNode(1,
            new TreeNode(2),
            new TreeNode(3)
        );
        
        TreeNode caso3 = new TreeNode(1,
            new TreeNode(2),
            new TreeNode(3, 
                new TreeNode(4),
                null
            )
        );

        TreeNode caso4 = new TreeNode(1,
            new TreeNode(2,
                new TreeNode(4),
                new TreeNode(5)
            ),
            new TreeNode(3,
                new TreeNode(6),
                new TreeNode(7)                
            )
        );

        System.out.println(Solution4.rightSideView(caso4));
    }
}
