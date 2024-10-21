package LeetcodeJava;

public class ReOrderList {
    public ListNode reverse(ListNode curr){
        ListNode prev = null;
        while (curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null){
            return;
        }
        ListNode slowPointer = head;
        ListNode fastPointer = head.next;
        while (fastPointer != null && fastPointer.next != null){
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        //System.out.println(slowPointer.val + " Slow");
        ListNode secondHead = slowPointer.next;
        slowPointer.next = null;
        secondHead = reverse(secondHead);
        //display(head);
        //display(secondHead);
        ListNode first = head;
        while (first != null && secondHead != null){
            ListNode temp1 = first.next;
            ListNode temp2 = secondHead.next;
            first.next = secondHead;
            secondHead.next = temp1;
            first = temp1;
            secondHead = temp2;
        }

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
        ReOrderList reOrderList = new ReOrderList();
        reOrderList.display(head);

        reOrderList.reorderList(head);
        reOrderList.display(head);
    }
}
