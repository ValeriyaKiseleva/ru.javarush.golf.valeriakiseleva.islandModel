package myislandmodel.islandfauna.animal.predator;

import myislandmodel.islandfauna.AnimalClassParameters;
import myislandmodel.islandmodel.island.Coordinates;

@AnimalClassParameters(maxCount = 5, maxSpeed = 2, maxSatiety = 80, animalWeight = 500)
public class Bear extends Predator{
    public Bear(Coordinates coordinates) {
        super(coordinates);
    }
}
