package myislandmodel.islandfauna.animal.predator;

import myislandmodel.islandfauna.AnimalClassParameters;
import myislandmodel.islandmodel.island.Coordinates;

@AnimalClassParameters(maxCount = 20, maxSpeed = 3, maxSatiety = 1, animalWeight = 6)
public class Eagle extends Predator{
    public Eagle(Coordinates coordinates) {
        super(coordinates);
    }
}
