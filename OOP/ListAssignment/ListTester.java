package ListAssignment;

public class ListTester {
    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.add(3);
        sll.add(4);
        sll.add(10);
        sll.add(5);
        sll.add(15);
        sll.add(2);
        sll.printValues();
        sll.removeBack();
        sll.printValues();
        sll.removeBack();
        sll.addFront(4);
        sll.printValues();
        System.out.println(sll.find(2));
        System.out.println(sll.find(5));
        SinglyLinkedList sll2 = new SinglyLinkedList();
        System.out.println(sll2.find(2));
    }
}