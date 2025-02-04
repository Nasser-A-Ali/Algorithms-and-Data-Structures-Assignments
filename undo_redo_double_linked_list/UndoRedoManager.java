package DoubleLinkedList;

/**
 * Implement an application that support undo/redo functionality. Use a linked list to maintain a sequence of states.\
 * Each state change is stored as a node in the list, allowing for easy navigation
 * 1<>2<>3<>4<>5
 */

public class UndoRedoManager<T> {
    private class Node {
        private T state;
        private Node prev;
        private Node next;
        private Node (T state) {
            this.state = state;
        }

    }
    private Node currentState;

    // Undo operation
    public void undo(){
       if (currentState != null && currentState.prev != null){
           currentState = currentState.prev;
           System.out.println("Undo successful. Current State: " + currentState.state);
       } else {
           System.out.println("There are previous states to undo to. Current State: " + currentState.state);
       }
    }

    // Operation to add state
    public void  addState (T newState) {
        Node newNode = new Node(newState);

        if (currentState != null) {
            newNode.prev = currentState;
            currentState.next = newNode;
            currentState = newNode;
            System.out.println("State added successfully. Current state: " + currentState.state);
        } else {
            currentState = newNode;
            System.out.println("Instantiated a new state. Current state: " + currentState.state);
        }

    }

    // Redo Operation
    public void redo(){
        if (currentState != null && currentState.next != null){
            currentState = currentState.next;
            System.out.println("Redo successful. Current State: " + currentState.state);
        } else {
            System.out.println("There are followup states to redo. Current State: " + currentState.state);
        }
    }

    // Test method
    public static void main(String[] args) {
        UndoRedoManager<String> undoRedoInstance = new UndoRedoManager<>();

        undoRedoInstance.addState("State 1");
        undoRedoInstance.addState("State 2");
        undoRedoInstance.addState("State 3");
        undoRedoInstance.addState("State 4");

        undoRedoInstance.undo(); // State 3
        undoRedoInstance.undo(); // State 2
        undoRedoInstance.undo(); // State 1
        undoRedoInstance.undo(); // Error + State 1
        undoRedoInstance.undo(); // Error + State 1

        undoRedoInstance.redo(); // State 2
        undoRedoInstance.redo(); // State 3
        undoRedoInstance.redo(); // State 4
        undoRedoInstance.redo(); // Error + State 4
        undoRedoInstance.redo(); // Error + State 4

        undoRedoInstance.undo(); // State 3
    }
}
