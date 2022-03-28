package Lab8;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lab82 {

    public static void main(String[] args) {

        //declare animal
        Animal horse = new Horse();
        Animal tiger = new Tiger();
        Animal dog = new Dog();

        //add to list
        List<Animal> animalList = new ArrayList<>();
        animalList.add(horse);
        animalList.add(tiger);
        animalList.add(dog);

        //max speed list
        final int HORSE_MAX_SPEED = 75;
        final int TIGER_MAX_SPEED = 100;
        final int DOG_MAX_SPEED = 60;

        //trigger the race or not
        System.out.println("Start the race? (y/n): ");
        Scanner scanner = new Scanner(System.in);
        String option = scanner.next();

        if (option.equals("y")) {

            //random speed for the animal
            horse.setSpeed(HORSE_MAX_SPEED);
            tiger.setSpeed(TIGER_MAX_SPEED);
            dog.setSpeed(DOG_MAX_SPEED);

            int topSpeed = 0; //for finding top speed between animals

            //print out each animal's speed for comparing
            for (Animal animal : animalList) {
                System.out.println(animal.getClass().getSimpleName() + " speed: " + animal.getSpeed() + " km/h");
            }

            //print the first part of result
            System.out.printf("\nThe winner is ");
            for (Animal animal : animalList) {
                for (Animal animal1 : animalList) {
                    //find top speed in the animal list
                    if (topSpeed < animal1.getSpeed()) {
                        topSpeed = animal1.getSpeed();
                    }
                }
                //find which animal has top speed
                if (animal.getSpeed() == topSpeed) {
                    System.out.print(animal.getClass().getSimpleName() + ", "); //print out that animal name and separate by comma (for case multiple animals have same top speed)
                } else {
                    System.out.print("");
                }
            }
            System.out.print("with speed " + topSpeed + " km/h"); //print top speed at the end of result
        } else {
            System.out.println("See you next time!");
        }
    }



}
