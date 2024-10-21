package LeetcodeJava;

public class LinkedListPractice {
    public static ListNode createNode(ListNode head, int val){
        if (head == null){
            return new ListNode(val);
        }
        ListNode curr = head;
        while (curr.next != null){
            curr = curr.next;
        }
        curr.next = new ListNode(val);
        return head;
    }

    public static void display(ListNode head){
        while (head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        ListNode next;
        while (curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static ListNode reverseRecursive(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode node = reverseRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }

    public static void main(String[] args) {
        ListNode head = null;
        for (int i=0; i<10; i++){
            head = createNode(head, i);
        }
        display(head);
        head = reverse(head);
        display(head);

        head = reverseRecursive(head);
        display(head);
    }
}
