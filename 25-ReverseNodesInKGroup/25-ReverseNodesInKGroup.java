// Last updated: 7/9/2026, 5:25:48 PM
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode next = null;
        ListNode kth = null;
        ListNode pre = null;


        while(temp != null){
            kth = kthNode(temp,k);
            if(kth == null){
                if(pre  != null){
                    pre.next = temp;
                    break;
                }
            }

            next = kth.next;
            kth.next = null;
            reverse(temp);
            if(temp == head){
                head = kth;

            }else{
                pre.next = kth;
            }

            pre = temp;
            temp = next;
        }
        return head;
    }

    public ListNode kthNode(ListNode head , int n){
        n--;
        while(head != null && n-- > 0){
            head = head.next;
        }

        return head;
    }

    public void reverse(ListNode head){
        ListNode pre = null;
        ListNode temp = head;

        while(temp != null){
            ListNode curr = temp.next;
            temp.next = pre;
            pre = temp;
            temp = curr;
        }
    }
}