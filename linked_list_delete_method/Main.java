package LinkedList;

public class Main {
    public static void main(String[] args) {
        SingleLinkedList sll = new SingleLinkedList();
        sll.insertInLinkedList(1,0);
        sll.insertInLinkedList(2, 1);
        sll.insertInLinkedList(3, 2);
        sll.insertInLinkedList(4, 3);
        sll.insertInLinkedList(5, 4);
        sll.insertInLinkedList(6, 5);
        sll.insertInLinkedList(7, 6);
        sll.insertInLinkedList(8, 7);

        sll.traverseLinkedList();
        sll.searchNode(5);

        sll.deleteFromLinkedList(4);
        sll.traverseLinkedList();

        sll.deleteFromLinkedList(1);
        sll.traverseLinkedList();

        sll.deleteFromLinkedList(3);
        sll.traverseLinkedList();

        sll.deleteFromLinkedList(3);
        sll.traverseLinkedList();

        sll.deleteFromLinkedList(8);
        sll.traverseLinkedList();
    }
}
