import java.util.ArrayList;
import java.util.Collections;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution{
    public static ListNode reverseList(ListNode node){
        ArrayList<Integer> list = new ArrayList<>();
        while(true){
            if (node == null){
                return null;
            }
            list.add(node.val);
            if (node.next == null){
                break;
            }
            node = node.next;
        }
        
        Collections.reverse(list);

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        for (int val : list){
            current.next = new ListNode(val);
            current = current.next;
        }

        return dummy.next;
    }
}

class Main{
    public static void main(String[] args){
        // ListNode node = new ListNode(
        //     1, new ListNode(
        //         2, new ListNode(
        //             3, new ListNode(
        //                 4, new ListNode(5)
        //             )
        //         )
        //     )
        // );

        ListNode node = null;

        node = Solution.reverseList(node);
        
        while(true){
            if (node == null){break;}
            System.out.println(node.val);
            if (node.next == null){
                break;
            }
            node = node.next;
        }
    }
}