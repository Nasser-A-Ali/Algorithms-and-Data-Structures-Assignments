import animals.Cat;
import animals.Dog;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class AnimalShelter {
    private Queue<Cat> catQueue = new LinkedList<>();
    private Queue<Dog> dogQueue = new LinkedList<>();

    public void enqueueAny(String name, double arrivalTime, String animalType) {
        // Checks the animalType and add to appropriate queue
        if (Objects.equals(animalType, "cat")){
            catQueue.add(new Cat(name, arrivalTime));
        } else if (Objects.equals(animalType, "dog")){
            dogQueue.add(new Dog(name, arrivalTime));
        } else {
            System.out.println("Animal type must be 'cat' or 'dog'.");
        }
    }

    // Removes dog or cat based on limitations first then based on arrival time
    public void dequeueAny(){
        if (dogQueue.isEmpty() && catQueue.isEmpty()){
            System.out.println("There are no cats or dogs in the shelter.");
        } else if (catQueue.isEmpty()){
            System.out.println("Not cats in the shelter. Adopted a dog named '" + dogQueue.peek().getName() + "'.");
            dogQueue.remove();
        } else if (dogQueue.isEmpty()){
            System.out.println("Not dogs in the shelter. Adopted a cat named '" + catQueue.peek().getName() + "'.");
            catQueue.remove();
        } else {
            if (catQueue.peek().getArrivalTime() <= dogQueue.peek().getArrivalTime()){
                System.out.println("Adopted a cat named '" + catQueue.peek().getName() + "' based on arrival time.");
                catQueue.remove();
            } else {
                System.out.println("Adopted a dog named '" + dogQueue.peek().getName() + "' based on arrival time.");
                dogQueue.remove();
            }
        }
    }

    // Removes the first dog in the queue
    public void dequeueDog(){
        if (dogQueue.isEmpty()){
            System.out.println("There are no dogs in the shelter.");
        } else {
            System.out.println("As requested, a dog named '" + dogQueue.peek().getName() + "' has been adopted.");
            dogQueue.remove();
        }
    }

    // Removes the first cat in the queue
    public void dequeueCat(){
        if (catQueue.isEmpty()){
            System.out.println("There are no cats in the shelter.");
        } else {
            System.out.println("As requested, a cat named '" + catQueue.peek().getName() + "' has been adopted.");
            catQueue.remove();
        }
    }

    // Iterates through all animals in shelter and prints them to console
    public void displayAnimalsInShelter(){
        System.out.println();
        System.out.println("\u001b[33;1mAnimals currently in the shelter:\u001B[0m");

        System.out.println("\u001b[35;1mDogs:\u001B[0m");
        if (dogQueue.isEmpty()){
            System.out.println("There are no dogs currently in the shelter.");
        } else {
            for(Dog dog : dogQueue){
                System.out.println("Name: " + dog.getName() + ". Arrival Time: " + dog.getArrivalTime() + ".");
            }
        }

        System.out.println("\u001b[35;1mCats:\u001B[0m");
        if (catQueue.isEmpty()){
            System.out.println("There are no cats currently in the shelter.");
        } else {
            for(Cat cat : catQueue){
                System.out.println("Name: " + cat.getName() + ". Arrival Time: " + cat.getArrivalTime() + ".");
            }
        }
    }
}
