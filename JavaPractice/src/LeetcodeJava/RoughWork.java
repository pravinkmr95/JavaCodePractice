package LeetcodeJava;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class RoughWork {
    public ListNode createList(int[] arr){
        ListNode head = new ListNode(arr[0]);
        ListNode curr = head;
        for (int i=1; i<arr.length; i++){
            curr.next = new ListNode(arr[i]);
            curr = curr.next;
        }
        return head;
    }

    public ListNode mergeKLists(ListNode[] lists){
        if (lists.length == 0){
            return null;
        }
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));

        for (ListNode listHead: lists){
            priorityQueue.offer(listHead);
        }
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        while (!priorityQueue.isEmpty()){
            ListNode top = priorityQueue.poll();
            curr.next = new ListNode(top.val);
            curr = curr.next;
            if (top.next != null){
                priorityQueue.offer(top.next);
            }
        }
        ListNode head = dummy.next;
        dummy.next = null;
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
        RoughWork roughWork = new RoughWork();
        // Merge K sorted Lists
        ListNode[] listNodes = new ListNode[3];
        listNodes[0] = roughWork.createList(new int[]{1, 4, 5});
        listNodes[1] = roughWork.createList(new int[]{1, 3, 4});
        listNodes[2] = roughWork.createList(new int[]{2, 6});
        //System.out.println(Arrays.toString(listNodes));
        ListNode newHead = roughWork.mergeKLists(listNodes);
        roughWork.display(newHead);
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        priorityQueue.offer(10);
        priorityQueue.offer(9);
        priorityQueue.offer(20);
        priorityQueue.offer(0);
        System.out.println(priorityQueue.peek());
        System.out.println(priorityQueue.poll());
    }
}
