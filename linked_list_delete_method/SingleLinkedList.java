package LinkedList;

public class SingleLinkedList {
    public Node head;
    public Node tail;
    public int size;

    // Create a linked list
    public Node createdLinkedList (int nodeValue) {
        Node node = new Node();
        node.next = null;
        node.value = nodeValue;
        head = node;
        tail = node;
        size = 1;
        return head;
    }

    // Insert an integer in a linked list
        // 1. if the link list doesn't exist
        // 2. inserting at the beginning
        // 3. inserting at the ending
        // 4. inserting anywhere

    public void insertInLinkedList(int nodeValue, int location) {
        Node node = new Node();
        node.value = nodeValue;
        if (head == null) {
            createdLinkedList(nodeValue);
            return;
        } else if (location == 0) {
            node.next = head;
            head = node;
        } else if (location >= size) {
            tail.next = node;
            node.next = null;
            tail = node;
        } else {
            Node tempNode = head;
            int index = 0;
            while (index < location - 1) {
                tempNode = tempNode.next;
                index++;
            }
            Node nextNode = node;
            node.next = nextNode;
        }
        size++;
    }

    // Traverse a Linked List
    public void traverseLinkedList(){
        if (head == null) {
            System.out.println("SLL does not exist");
        } else {
            Node temNode = head;
            for (int i = 0; i < size; i++) {
                System.out.print(temNode.value);
                if (i != size -1 ){
                    System.out.print(" -> ");
                }
                temNode = temNode.next;
            }
            System.out.print("\n");
        }
    }


    // Search for a Node within a Linked List
    public boolean searchNode (int nodeValue) {
        if (head != null) {
            Node tempNode = head;
            for (int i = 0; i < size; i++) {
                if (tempNode.value == nodeValue) {
                    System.out.println("Found the node: " + tempNode.value + " at location: " + i + "\n");
                    return true;
                }
                tempNode = tempNode.next;
            }
        }
        System.out.println("Node not found");
        return false;
    }

    // Assignment

    // Delete an int from a Linked List
        // 1. if the linked list doesn't exist
        // 2. delete at the beginning
        // 3. delete at the ending
        // 4. delete from anywhere

    public void deleteFromLinkedList (int valueToDelete) {
        Node preTempNode = null;
        Node tempNode = head;

        if (head == null) {
            System.out.println("The linked list does not exist");
        } else if (head.value == valueToDelete){
            head = head.next;
            this.size--;
            System.out.println("Successfully deleted the value: " + valueToDelete + " (head). The value of the new head is: " + head.value + ".");
        } else {
            for (int i=0; i < size; i++){
                if (tempNode.value == valueToDelete) {
                    if (tempNode.next == null) {
                        preTempNode.next = null;
                        tail = preTempNode;
                        this.size--;
                        System.out.println("Successfully deleted the value: " + valueToDelete + " (tail). The value of the new tail is: " + tail.value + ".");
                    } else {
                        preTempNode.next = tempNode.next;
                        this.size--;
                        System.out.println("Successfully deleted the value: " + valueToDelete + ".");
                    }
                    return;
                } else {
                    preTempNode = tempNode;
                    tempNode = tempNode.next;
                }
            }

            System.out.println("The value " + valueToDelete + " does not exist within the linked list.");
        }
    }

}