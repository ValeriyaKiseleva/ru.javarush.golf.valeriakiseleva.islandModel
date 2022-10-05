package myislandmodel.islandfauna.animal.predator;

import myislandmodel.islandfauna.AnimalClassParameters;
import myislandmodel.islandmodel.island.Coordinates;

@AnimalClassParameters(maxCount = 30, maxSpeed = 2, maxSatiety = 2, animalWeight = 8)
public class Fox extends Predator{
    public Fox(Coordinates coordinates) {
        super(coordinates);
    }
}
