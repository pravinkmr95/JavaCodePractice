package LeetcodeJava;

import java.util.HashSet;
import java.util.List;

public class LinkedListCycle {
    public void display(ListNode head){
        HashSet<ListNode> set = new HashSet<>();
        while (head != null && !set.contains(head)){
            System.out.print(head.val + " ");
            set.add(head);
            head = head.next;
        }
        System.out.println();
    }

    public boolean hasCycle(ListNode head) {
        ListNode slowPtr = head;
        ListNode fastPtr = head;
        while (fastPtr != null && fastPtr.next != null){
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
            if (slowPtr == fastPtr){
                return true;
            }
        }
        return false;
    }

    public void breakCycle(ListNode head){
        ListNode slowPtr = head;
        ListNode fastPtr = head;
        while (fastPtr != null && fastPtr.next != null){
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
            if (slowPtr == fastPtr){
                break;
            }
        }
        if (slowPtr == fastPtr){
            slowPtr = head;
            if (slowPtr != fastPtr){
                while (slowPtr.next != fastPtr.next){
                    slowPtr = slowPtr.next;
                    fastPtr = fastPtr.next;
                }
                fastPtr.next = null;
            } else {
                while (fastPtr.next != slowPtr){
                    fastPtr = fastPtr.next;
                }
                fastPtr.next = null;
            }
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next;
        LinkedListCycle linkedListCycle = new LinkedListCycle();
        linkedListCycle.display(head);
        System.out.println(linkedListCycle.hasCycle(head));

        linkedListCycle.breakCycle(head);
        linkedListCycle.display(head);

        System.out.println(linkedListCycle.hasCycle(head));
    }
}
