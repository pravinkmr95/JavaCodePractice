package LeetcodeJava;

import java.util.List;

public class ReverseLinkedList {

    public ListNode reverseList(ListNode curr) {
        ListNode prev = null;
        //ListNode curr = head;
        while (curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public ListNode reverseListRec(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode curr = reverseListRec(head.next);
//        System.out.println("curr " + curr.val);
//        System.out.println("head " + head.val);
        head.next.next = head;
        head.next = null;
        return curr;
    }

    public void display(ListNode head){
        while (head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        head = reverseLinkedList.reverseList(head);
        reverseLinkedList.display(head);

        head = reverseLinkedList.reverseListRec(head);
        reverseLinkedList.display(head);
    }

}
