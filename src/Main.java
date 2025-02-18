public class Main {
    public static void main(String[] args) {
        AnimalShelter animalShelter = new AnimalShelter();

        System.out.println();
        System.out.println("\u001B[32mTesting the creation of a variety of cats and dogs.\u001B[0m");
        animalShelter.enqueueAny("Cat 1", 123.1, "cat");
        animalShelter.enqueueAny("Dog 1", 123.1, "dog");
        animalShelter.enqueueAny("Dog 2", 123.2, "dog");
        animalShelter.enqueueAny("Cat 2", 123.2, "cat");
        animalShelter.enqueueAny("Cat 3", 123.3, "cat");
        animalShelter.enqueueAny("Dog 3", 123.3, "dog");
        animalShelter.enqueueAny("Dog 4", 123.4, "dog");
        animalShelter.displayAnimalsInShelter();

        System.out.println();
        System.out.println("\u001B[32mTesting the dequeueAny() method.\u001B[0m");
        animalShelter.dequeueAny();
        animalShelter.displayAnimalsInShelter();
        animalShelter.dequeueAny();
        animalShelter.displayAnimalsInShelter();
        animalShelter.dequeueAny();
        animalShelter.displayAnimalsInShelter();
        animalShelter.dequeueAny();
        animalShelter.displayAnimalsInShelter();
        animalShelter.dequeueAny();
        animalShelter.displayAnimalsInShelter();
        animalShelter.dequeueAny();
        animalShelter.displayAnimalsInShelter();
        animalShelter.dequeueAny();
        animalShelter.displayAnimalsInShelter();
        animalShelter.dequeueAny();

        System.out.println();
        System.out.println("\u001B[32mRecreating the same set of cats and dogs.\u001B[0m");
        animalShelter.enqueueAny("Cat 1", 123.1, "cat");
        animalShelter.enqueueAny("Dog 1", 123.1, "dog");
        animalShelter.enqueueAny("Dog 2", 123.2, "dog");
        animalShelter.enqueueAny("Cat 2", 123.2, "cat");
        animalShelter.enqueueAny("Cat 3", 123.3, "cat");
        animalShelter.enqueueAny("Dog 3", 123.3, "dog");
        animalShelter.enqueueAny("Dog 4", 123.4, "dog");
        animalShelter.displayAnimalsInShelter();

        System.out.println();
        System.out.println("\u001B[32mTesting dequeueCat() x2.\u001B[0m");
        animalShelter.dequeueCat();
        animalShelter.displayAnimalsInShelter();
        animalShelter.dequeueCat();
        animalShelter.displayAnimalsInShelter();

        System.out.println();
        System.out.println("\u001B[32mTesting dequeueDog() x3.\u001B[0m");
        animalShelter.dequeueDog();
        animalShelter.displayAnimalsInShelter();
        animalShelter.dequeueDog();
        animalShelter.displayAnimalsInShelter();
        animalShelter.dequeueDog();
        animalShelter.displayAnimalsInShelter();

        System.out.println();
        System.out.println("\u001B[32mTesting Completed.\u001B[0m");
    }
}
