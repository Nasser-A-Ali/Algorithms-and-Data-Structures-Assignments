public class Main {
    public static void main(String[] args) {

        System.out.println("---------------------------------");
        System.out.println("Generating users with to-do lists");
        System.out.println("---------------------------------");

        User[] listOfUsers = new User[3];

        listOfUsers[0] = new User("User 1");
        listOfUsers[1] = new User("User 2");
        listOfUsers[2] = new User("User 3");

        listOfUsers[0].addTask(new Task("Prepare meals for the week"));
        listOfUsers[0].addTask(new Task("Go to the gym"));

        listOfUsers[1].addTask(new Task("Do Data Structures assignment"));
        listOfUsers[1].addTask(new Task("Submit Data Structures assignment"));

        listOfUsers[2].addTask(new Task("Prepare lesson plan"));
        listOfUsers[2].addTask(new Task("Prepare PowerPoint for lesson"));

        for (User user: listOfUsers) {
            user.displayToDoList();
            System.out.println("--------------------");
        }

        System.out.println("---------------------------------");
        System.out.println("Marking some tasks as completed");
        System.out.println("---------------------------------");

        listOfUsers[0].completeTask("Prepare meals for the week");
        listOfUsers[0].completeTask("Go to the gym");

        listOfUsers[1].completeTask("Do Data Structures assignment");

        for (User user: listOfUsers) {
            user.displayToDoList();
            System.out.println("--------------------");
        }
    }
}
