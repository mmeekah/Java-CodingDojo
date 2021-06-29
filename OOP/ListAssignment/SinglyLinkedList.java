package ListAssignment;

public class SinglyLinkedList {
    public Node head;

    public SinglyLinkedList() {
        // your code here
        this.head = null;
    }

    // METHODS

    private boolean isEmpty() {
        return this.head == null;
    }

    public void addFront(int value) {
        Node newNode = new Node(value);
        if (isEmpty()) {
            head = newNode;
            return;

        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public void addBack(int value) {
        Node newNode = new Node(value);
        if (isEmpty()) {
            head = newNode;
            return;
        } else {
            Node runner = head;
            while (runner.next != null) {
                runner = runner.next;
            }
            runner.next = newNode;
        }
    }

    // SLL methods go here. As a starter, we will show you how to add a node to the
    // list.

    public void add(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            Node runner = head;
            while (runner.next != null) {
                runner = runner.next;
            }
            runner.next = newNode;
        }
    }

    public Integer removeBack() {
        Node runner = head;
        int vatToReturn;

        // 0 nodes = return null
        if (isEmpty()) {
            System.out.println("Empty List");
            return null;
        }

        // 1 node - remove& return head

        int valToReturn;
        if (head.next == null) {
            valToReturn = head.value;
            head = null;
            return valToReturn;
        }

        // more than 1 node - loop to end, remove and return last node
        while (runner.next.next != null) {
            runner = runner.next;
        }
        valToReturn = runner.next.value;
        runner.next = null;
        return valToReturn;

    }

    public void printValues() {
        if (isEmpty()) {
            System.out.println("List is empty");
            return;
        }
        Node runner = this.head;
        while (runner.next != null) {
            System.out.println("$$$$$$$$$$$$$$$");
            String s = String.format("Node value: %s :: Nexint Value: %s", runner.value, runner.next.value);
            System.out.println(s);
            runner = runner.next;
        }
        System.out.println("$$$$$$$$$$$$$$$");
        String s = String.format("Node value: %s :: Nexint Value: null", runner.value);
        System.out.println(s);

    }

    public Node find(int value) {
        System.out.println("Finding value " + value);
        if (isEmpty()) {
            System.out.println("List is empty");
            return null;
        }
        Node runner = this.head;
        if (runner.value == value) {
            String s = String.format("Node found: " + runner + " :: Value: " + value);
            System.out.println(s);
            return runner;
        } else {
            while (runner.next != null) {
                runner = runner.next;
                if (runner.value == value) {
                    String s = String.format("Node found: " + runner + " :: Value: " + value);
                    System.out.println(s);
                    return runner;
                }
            }
            System.out.println("Value not in list");
            return null;
        }
    }
}