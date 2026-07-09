// Last updated: 7/9/2026, 5:24:02 PM
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Map<Node , Node > map = new HashMap<>();
        Node newhead = new Node(head.val);
        Node oldtemp = head.next;
        Node newtemp = newhead;
        map.put(head , newhead);

        while(oldtemp != null){
            Node copynode = new Node(oldtemp.val);
            newtemp.next = copynode;
            map.put(oldtemp , copynode);

            oldtemp = oldtemp.next;
            newtemp = newtemp.next;

        }

        oldtemp = head;
        newtemp = newhead;

        while(oldtemp != null){
            newtemp.random = map.get(oldtemp.random);
            oldtemp = oldtemp.next;
            newtemp = newtemp.next;
        }
        return newhead;

        
    }
}