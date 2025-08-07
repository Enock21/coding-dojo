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

class Solution2{
    public static ListNode reverseList(ListNode head) {

        ArrayList<Integer> vals = new ArrayList<Integer>();

        if (head == null) {
            return null;
        }

        while (head != null) {
            vals.add(head.val);
            head = head.next;
        }

        System.out.println(vals.toString());

        ListNode n = new ListNode(vals.get(0), null);
        for (int i = 1; i < vals.size(); i++) {

            n = new ListNode(vals.get(i), n);
        }

        return n;   
    }
}

//Mais otimizada
class Solution3{
    public static ListNode reverseList(ListNode head){
        if(head == null){return null;}
        if(head.next == null){return head;}

        ListNode tail = new ListNode(head.val);
        head = head.next;
        while(true){
            tail = new ListNode(head.val, tail);
            if (head.next == null){break;}
            head = head.next;
        }

        return tail;
    }
}

class Main{
    public static void main(String[] args){
        ListNode node = new ListNode(
            1, new ListNode(
                2, new ListNode(
                    3, new ListNode(
                        4, new ListNode(5)
                    )
                )
            )
        );

        node = Solution3.reverseList(node);
        
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