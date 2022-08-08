package MyIslandModel.IslandModel;

import MyIslandModel.IslandFauna.Animal.Animal;
import MyIslandModel.IslandFauna.AnimalEatable;
import MyIslandModel.IslandFauna.AnimalClassParameters;
import MyIslandModel.IslandModel.Island.Coordinates;
import MyIslandModel.IslandModel.Island.Location;
import MyIslandModel.IslandReferences.AnimalRationReference;

import java.util.Random;

public class RandomOperation {

    public Coordinates getRandomCoordinates(Class appearedAnimalClass) {
        Coordinates randomCoordinates = new Coordinates();
        boolean isCheck = false;

        while (!isCheck) {
            randomCoordinates.x = new Random().nextInt(IslandModel.getIsland().getIslandWidth());
            randomCoordinates.y = new Random().nextInt(IslandModel.getIsland().getIslandHeight());

            if (Location.getLocationByCoordinates(randomCoordinates).locationOverflowCheck(appearedAnimalClass)) {
                continue;
            }
            isCheck = true;
        }
        return randomCoordinates;
    }

    public Coordinates getRandomTransferCoordinate(Animal animal) {

        if (!animal.getClass().isAnnotationPresent(AnimalClassParameters.class)) {
            throw new RuntimeException();
        }
        int speed = animal.getClass().getAnnotation(AnimalClassParameters.class).maxSpeed();

        Coordinates nextCoordinates = animal.getCoordinatesOnIsland();

        boolean isCheck = false;
        int counter = 0;

        while (!isCheck && counter < 20) {     // ????
            Coordinates randomNextCoordinates = new Coordinates();
            randomNextCoordinates.x = animal.getCoordinatesOnIsland().x;
            randomNextCoordinates.y = animal.getCoordinatesOnIsland().y;

            int steps = new Random().nextInt(speed) + 1;
            if (!new Random().nextBoolean()) {
                steps *= -1;
            }

            boolean isHorizontal = new Random().nextBoolean();
            if (isHorizontal) {
                randomNextCoordinates.x += steps;
            } else {
                randomNextCoordinates.y += steps;
            }

            if (randomNextCoordinates.x >= IslandModel.getIsland().getIslandWidth() || randomNextCoordinates.x < 0) {
                counter++;
                continue;
            }
            if (randomNextCoordinates.y >= IslandModel.getIsland().getIslandHeight() || randomNextCoordinates.y < 0) {
                counter++;
                continue;
            }
            if (Location.getLocationByCoordinates(randomNextCoordinates).locationOverflowCheck(animal.getClass())) {
                counter++;
                continue;
            }

            isCheck = true;
            nextCoordinates = randomNextCoordinates;
        }

        return nextCoordinates;

    }

    public boolean getRandomResultOfHunting(AnimalEatable animalEatable, Animal animalForHunt) {
        int luckPercent = AnimalRationReference.getAnimalFoodRation(animalEatable.getClass()).get(animalForHunt.getClass());
        int numberOfLuck = new Random().nextInt(101);
        return (numberOfLuck < luckPercent);
    }
}
