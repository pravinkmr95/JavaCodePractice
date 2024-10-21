package LeetcodeJava;

public class RemoveNthFromEndOfTheList {
    public int countNodes(ListNode head){
        int count = 0;
        while (head != null){
            count++;
            head = head.next;
        }
        return count;
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null){
            return head;
        }
        int fromStart = countNodes(head) - n;
        //System.out.println(fromStart);
        if (fromStart == 0){
            return head.next;
        }
        ListNode prev = null;
        ListNode curr = head;
        int start = 0;
        while (start < fromStart){
            prev = curr;
            curr = curr.next;
            start++;
        }
        prev.next = curr.next;
        return head;
    }

    public void display(ListNode head){
        while (head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public ListNode removeNthFromEndOnePass(ListNode head, int n){
        if (head == null){
            return null;
        }
        int i=1;
        ListNode fastPointer = head;
        while (fastPointer != null && i<n){
            fastPointer = fastPointer.next;
            i++;
        }

        if (fastPointer == null || fastPointer.next == null){
            return head.next;
        }
        //System.out.println(fastPointer.val);
        ListNode slowPointer = head;
        ListNode prev = null;
        while (fastPointer.next != null){
            fastPointer = fastPointer.next;
            prev = slowPointer;
            slowPointer = slowPointer.next;
        }
        prev.next = prev.next.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        RemoveNthFromEndOfTheList removeNthFromEndOfTheList = new RemoveNthFromEndOfTheList();
        removeNthFromEndOfTheList.display(head);
        head = removeNthFromEndOfTheList.removeNthFromEndOnePass(head, 2);
        removeNthFromEndOfTheList.display(head);

        ListNode head1 = new ListNode(1);
        head1 = removeNthFromEndOfTheList.removeNthFromEndOnePass(head1, 1);
        removeNthFromEndOfTheList.display(head1);

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2 = removeNthFromEndOfTheList.removeNthFromEndOnePass(head2, 1);
        removeNthFromEndOfTheList.display(head2);
    }
}
