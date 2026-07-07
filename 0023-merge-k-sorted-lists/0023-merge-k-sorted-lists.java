/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

 //heap and priority Queue
 
// class Solution {
//     public ListNode mergeKLists(ListNode[] lists) {
//         PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
//         for (ListNode node : lists) {
//             if (node != null)
//                 pq.offer(node);
//         }
//         ListNode dummy = new ListNode(-1);
//         ListNode tail = dummy;

//         while (!pq.isEmpty()) {
//             ListNode curr = pq.poll();

//             tail.next = curr;
//             tail = tail.next;

//             if (curr.next != null)
//                 pq.offer(curr.next);
//         }
//         return dummy.next;
//     }
// }


//divide and conquer techniques
class Solution {

    public ListNode mergeKLists(ListNode[] lists) {

        if (lists == null || lists.length == 0)
            return null;

        int interval = 1;

        while (interval < lists.length) {

            for (int i = 0; i + interval < lists.length; i += interval * 2) {

                lists[i] = merge(lists[i], lists[i + interval]);
            }

            interval *= 2;
        }

        return lists[0];
    }

    private ListNode merge(ListNode a, ListNode b) {

        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        while (a != null && b != null) {

            if (a.val <= b.val) {
                tail.next = a;
                a = a.next;
            } else {
                tail.next = b;
                b = b.next;
            }

            tail = tail.next;
        }

        if (a != null)
            tail.next = a;

        if (b != null)
            tail.next = b;

        return dummy.next;
    }
}