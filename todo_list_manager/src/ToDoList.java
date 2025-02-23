public class ToDoList {

    private class TaskNode {
        Task task;
        TaskNode next;

        TaskNode(Task task){
            this.task = task;
            this.next = null;
        }
    }

    private TaskNode head;
    public ToDoList(){
        this.head = null;
    }

    public void addTask(Task task) {
        TaskNode newTaskNode = new TaskNode(task);

        if (head == null) {
            // Create a new task node and make it the head of the To-Do List
            head = newTaskNode;
        } else {
            // 1. Starts at the head node
            TaskNode currentTaskNode = head;
            // 2. Iterates through the To-Do Linked List
            while (currentTaskNode.next != null) {
                currentTaskNode = currentTaskNode.next;
            }
            // 3. When it arrives at the last node, it creates one after it
            currentTaskNode.next = newTaskNode;
        }
    }

    public void completeTask(String taskDescription) {
        TaskNode currentTaskNode = head;

        while (currentTaskNode != null) {
            if (currentTaskNode.task.getDescription().equals(taskDescription)) {
                currentTaskNode.task.markAsDone();
                return;
            }
            currentTaskNode = currentTaskNode.next;
        }
    }

    public void displayToDoList() {
        TaskNode currentTaskNode = head;

        while (currentTaskNode != null) {
            System.out.println(currentTaskNode.task.toString());
            currentTaskNode = currentTaskNode.next;
        }
    }

}
