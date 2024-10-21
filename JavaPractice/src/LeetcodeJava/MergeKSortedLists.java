package LeetcodeJava;

import GenericClasses.Pair;

import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedLists {
    public ListNode createList(int[] arr){
        ListNode head = null;
        ListNode curr = null;
        for (int num: arr){
            if (head == null){
                head = new ListNode(num);
                curr = head;
            } else {
                curr.next = new ListNode(num);
                curr = curr.next;
            }
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

    public ListNode sortedMerge(ListNode list1, ListNode list2){
        ListNode merged;
        if (list1 == null){
            return list2;
        }
        if (list2 == null){
            return list1;
        }
        if (list1.val < list2.val){
            merged = list1;
            merged.next = sortedMerge(list1.next, list2);
        } else {
            merged = list2;
            merged.next = sortedMerge(list1, list2.next);
        }
        return merged;
    }

    public ListNode mergeUtil(ListNode[] lists, int start, int end){
        if (start == end){
            return lists[start];
        }
        int mid = (start + end)/2;
        ListNode head1 = mergeUtil(lists, start, mid);
        ListNode head2 = mergeUtil(lists, mid+1, end);
        return sortedMerge(head1, head2);
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0){
            return null;
        }
        return mergeUtil(lists, 0, lists.length-1);
    }

    public ListNode mergeKListsHeap(ListNode[] lists){
        if (lists == null || lists.length == 0){
            return null;
        }
        PriorityQueue<ListNode> heap = new PriorityQueue<>((a, b) -> (a.val - b.val));
        for (ListNode list: lists){
            if (list != null) {
                heap.offer(list);
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (!heap.isEmpty()){
            ListNode smallest = heap.poll();
            curr.next = smallest;
            curr = curr.next;
            if (smallest.next != null){
                heap.offer(smallest.next);
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        MergeKSortedLists mergeKSortedLists = new MergeKSortedLists();
        ListNode head1 = mergeKSortedLists.createList(new int[]{1, 4, 5});
        mergeKSortedLists.display(head1);
        ListNode head2 = mergeKSortedLists.createList(new int[]{1, 3, 4});
        mergeKSortedLists.display(head2);
        ListNode head3 = mergeKSortedLists.createList(new int[]{2, 6});
        mergeKSortedLists.display(head3);

        ListNode[] listNodes = new ListNode[3];
        listNodes[0] = head1;
        listNodes[1] = head2;
        listNodes[2] = head3;
        ListNode head = mergeKSortedLists.mergeKListsHeap(listNodes);
        mergeKSortedLists.display(head);
    }
}
