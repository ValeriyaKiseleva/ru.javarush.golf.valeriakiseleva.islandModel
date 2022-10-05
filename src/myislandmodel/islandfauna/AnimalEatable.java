package myislandmodel.islandfauna;

import myislandmodel.islandfauna.animal.Animal;
import myislandmodel.islandmodel.island.Coordinates;
import myislandmodel.islandmodel.island.Location;
import myislandmodel.islandmodel.RandomOperation;
import myislandmodel.islandreferences.AnimalRationReference;

import java.util.*;

public interface AnimalEatable {

    default float hunting(Coordinates coordinates) {
        ArrayList<Class> animalsForFinding = AnimalRationReference.getWhatAnimalCanToIt(this.getClass());
        Collections.shuffle(animalsForFinding);

        Animal animalForHunt = Location.getLocationByCoordinates(coordinates).getFoodOnLocation(animalsForFinding);

        if (animalForHunt != null) {
            boolean isEat = new RandomOperation().getRandomResultOfHunting(this, animalForHunt);

            if (isEat) {
                animalForHunt.leaveTheWorld();
                return animalForHunt.getClass().getAnnotation(AnimalClassParameters.class).animalWeight();
            }
        }
        return 0f;
    }
}