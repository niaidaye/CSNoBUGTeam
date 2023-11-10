public class ReverseLinkedList {
    public static void main(String[] args) {
        // 翻转链表
        // a --> b --> c --> d --> e
        Node e = new Node("e");
        Node d = new Node("d", e);
        Node c = new Node("c", d);
        Node b = new Node("b", c);
        Node a = new Node("a", b);

        // e  --> d  -->  c  --> b  --> a
        Node newLinked = reLinked(a);

        System.out.println(newLinked.data);
    }
    /**
     * 翻转链表
     * @param head : 原链表头结点
     * @return : 经过翻转链表的头结点
     */
    private static Node reLinked(Node head) {
        Node current=head;
        if (current.next == null) {
            return current;
        }
        Node pre=current;
        current=current.next;
        while (current.next!= null) {
            Node prepre=pre;
            pre=current;
            current=current.next;
            pre.next=prepre;
        }
        current.next=pre;
        return current;
    }
}

class Node {
    String data;
    Node next;

    public Node(String data, Node next) {
        this.data = data;
        this.next = next;
    }

    public Node(String data) {
        this.data = data;
    }
}
