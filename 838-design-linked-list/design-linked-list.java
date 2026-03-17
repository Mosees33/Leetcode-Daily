class MyLinkedList {

    class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    Node head;

    public MyLinkedList() {
        head = null;
    }

    public int get(int index) {
        Node temp = head;

        while (temp != null && index > 0) {
            temp = temp.next;
            index--;
        }

        return (temp == null) ? -1 : temp.val;
    }

    public void addAtHead(int val) {
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;
    }

    public void addAtTail(int val) {
        Node newNode = new Node(val);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
    }

    public void addAtIndex(int index, int val) {

        if (index == 0) {
            addAtHead(val);
            return;
        }

        Node temp = head;

        while (temp != null && index > 1) {
            temp = temp.next;
            index--;
        }

        if (temp == null) return;

        Node newNode = new Node(val);
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public void deleteAtIndex(int index) {

        if (head == null) return;

        if (index == 0) {
            head = head.next;
            return;
        }

        Node temp = head;

        while (temp.next != null && index > 1) {
            temp = temp.next;
            index--;
        }

        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }
}