package LeetcodeJava;

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null){
            return list2;
        }
        if (list2 == null){
            return list1;
        }
        ListNode head = null;
        if (list1.val < list2.val){
            head = list1;
            head.next = mergeTwoLists(list1.next, list2);
        } else {
            head = list2;
            head.next = mergeTwoLists(list1, list2.next);
        }
        return head;
    }

    public void display(ListNode head){
        while (head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        MergeTwoSortedLists mergeTwoSortedLists = new MergeTwoSortedLists();
        ListNode head = mergeTwoSortedLists.mergeTwoLists(list1, list2);
        mergeTwoSortedLists.display(head);
    }
}
