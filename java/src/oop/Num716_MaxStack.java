package oop;

public class Num716_MaxStack {

    Node topNode = null;
    Node maxNode = null;

    public Num716_MaxStack() {
        maxNode = null;
    }

    public static void main(String[] args) {
        Num716_MaxStack stack = new Num716_MaxStack();
        stack.push(5);
        stack.push(1);
        System.out.println(stack.popMax());
        System.out.println(stack.peekMax());
    }

    public void push(int x) {
        if (topNode == null) {
            topNode = new Node(x);
            maxNode = topNode;
        } else {
            Node node = new Node(x);
            node.previous = topNode;
            topNode.next = node;
            topNode = topNode.next;
            if (node.val >= maxNode.val) {
                maxNode = node;
            }
        }
    }

    public int top() {
        return topNode.val;
    }

    public int peekMax() {
        return maxNode.val;
    }

    public int pop() {
        if (maxNode == topNode) {
            int val = topNode.val;
            topNode = topNode.previous;
            if (topNode != null) {
                topNode.next = null;
                maxNode = null;
                findMaxNode();
            } else {
                maxNode = null;
            }
            return val;
        } else {
            int val = topNode.val;
            topNode = topNode.previous;
            topNode.next = null;
            return val;
        }
    }

    public int popMax() {
        if (maxNode == topNode) {
            return pop();
        }
        int val = maxNode.val;
        if (maxNode.previous == null) {
            maxNode.next.previous = null;
            maxNode = null;
            findMaxNode();
        } else {
            removeNode(maxNode);
            maxNode = null;
            findMaxNode();
        }
        return val;
    }

    private void findMaxNode() {
        Node ptr = topNode;
        maxNode = topNode;
        while (ptr != null) {
            if (ptr.val > maxNode.val) {
                maxNode = ptr;
            }
            ptr = ptr.previous;
        }
    }

    private void removeNode(Node n) {
        n.previous.next = n.next;
        if (n.next != null) n.next.previous = n.previous;
    }


    class Node {
        int val;
        Node previous;
        Node next;

        public Node(int val) {
            this.val = val;
        }

        public String toString() {
            return "" + val;
        }
    }
}
