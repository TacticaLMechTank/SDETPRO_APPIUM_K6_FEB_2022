package Lab9;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static Lab9.Animal.Builder;

public class Lab9 {

    public static void main(String[] args) {

        //max speed list
        final int HORSE_MAX_SPEED = 75;
        final int TIGER_MAX_SPEED = 100;
        final int DOG_MAX_SPEED = 60;
        final int EAGLE_MAX_SPEED = 180;
        final int FINCH_MAX_SPEED = 90;

        //build new animal
        Builder builder = new Builder();
        Animal horse = builder.withFlyable(false).withSpeed(HORSE_MAX_SPEED).withName("Horse").build();
        Animal tiger = builder.withFlyable(false).withSpeed(TIGER_MAX_SPEED).withName("Tiger").build();
        Animal dog = builder.withFlyable(false).withSpeed(DOG_MAX_SPEED).withName("Dog").build();
        Animal eagle = builder.withFlyable(true).withSpeed(EAGLE_MAX_SPEED).withName("Eagle").build();
        Animal finch = builder.withFlyable(true).withSpeed(FINCH_MAX_SPEED).withName("Finch").build();

        //add to list
        List<Animal> animalList = new ArrayList<>();
        animalList.add(horse);
        animalList.add(tiger);
        animalList.add(dog);
        animalList.add(eagle);
        animalList.add(finch);

        //trigger the race or not
        System.out.println("Start the race? (y/n): ");
        Scanner scanner = new Scanner(System.in);
        String option = scanner.next();

        if (option.equals("y")) {
            int topSpeed = 0; //for finding top speed between animals

            //print out each animal's speed for comparing
            System.out.println("1. Animal that cannot fly:");
            for (Animal animal : animalList) {
                if (!animal.isFlyable()) {
                    System.out.println(animal.getName() + " speed: " + animal.getSpeed() + " km/h");
                }
            }
            System.out.println("\n2. Animal that can fly:");
            for (Animal animal : animalList) {
                if (animal.isFlyable()) {
                    System.out.println(animal.getName() + " speed: " + animal.getSpeed() + " km/h");
                }
            }

            //print the first part of result
            System.out.printf("\nThe winner is ");
            for (Animal animal : animalList) {
                for (Animal animal1 : animalList) {
                    //find top speed in the animal list
                    if (!animal1.isFlyable() && topSpeed < animal1.getSpeed()) {
                        topSpeed = animal1.getSpeed();
                    }
                }
                //find which animal has top speed
                if (!animal.isFlyable() && animal.getSpeed() == topSpeed) {
                    System.out.print(animal.getName() + ", "); //print out that animal name and separate by comma (for case multiple animals have same top speed)
                } else {
                    System.out.print("");
                }
            }
            System.out.print("with speed " + topSpeed + " km/h\n"); //print top speed at the end of result
            System.out.println("(Animal that can fly does not count)");
        } else {
            System.out.println("See you next time!");
        }
    }
}
