package myislandmodel.islandfauna;


import myislandmodel.islandmodel.island.Coordinates;
import myislandmodel.islandmodel.island.Location;

import java.util.Random;

public interface PlantEatable {
    default float plantEat(Coordinates coordinates, float currentSatiety) {

        if (!this.getClass().isAnnotationPresent(AnimalClassParameters.class)) {
            throw new RuntimeException();
        }
        float maxSatiety = this.getClass().getAnnotation(AnimalClassParameters.class).maxSatiety();

        int canToEatPlantElse = (int) Math.ceil(maxSatiety - currentSatiety);

        int plantsCount = Location.getLocationByCoordinates(coordinates).getPlantsCount();

        if (canToEatPlantElse > plantsCount) {
            canToEatPlantElse = plantsCount;
        }

        int countOfEatenPlants = 0;
        if (canToEatPlantElse > 0) {
            countOfEatenPlants = new Random().nextInt(canToEatPlantElse + 1);
        }

        Location.getLocationByCoordinates(coordinates).plantDecrease(countOfEatenPlants);

        return countOfEatenPlants;
    }

}
