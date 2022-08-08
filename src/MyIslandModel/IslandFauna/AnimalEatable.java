package MyIslandModel.IslandFauna;

import MyIslandModel.IslandFauna.Animal.Animal;
import MyIslandModel.IslandModel.Island.Coordinates;
import MyIslandModel.IslandModel.Island.Location;
import MyIslandModel.IslandModel.RandomOperation;
import MyIslandModel.IslandReferences.AnimalRationReference;

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