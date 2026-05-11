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

        if(head == null)
            return null;
        
        Node dummy = new Node(-1);
        Map<Node, Node> nodeMap = new HashMap<>();
        
        Node temp = head;
        Node copyHead = dummy;
        while(temp != null){
            Node node = new Node(temp.val);
            copyHead.next = node;
            copyHead = node;
            if (!nodeMap.containsKey(temp)) {
                nodeMap.put(temp, node);
            }
            temp = temp.next;
        }

        temp = head;
        copyHead = dummy.next;
        while(temp != null){
            if(temp.random != null){
                copyHead.random = nodeMap.get(temp.random);
            }
            temp = temp.next;
            copyHead = copyHead.next;
        }
        return dummy.next;
    }
}
