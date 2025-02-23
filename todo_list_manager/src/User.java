public class User {
    private String userName;
    private ToDoList toDoList;

    public User(String userName) {
        this.userName = userName;
        this.toDoList = new ToDoList();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void addTask(Task task) {
        toDoList.addTask(task);
    }

    public void completeTask(String taskDescription) {
        toDoList.completeTask(taskDescription);
    }

    public ToDoList getToDoList() {
        return toDoList;
    }

    public void displayToDoList() {
        System.out.println(userName + "'s To-Do List: ");
        toDoList.displayToDoList();
    }

}
