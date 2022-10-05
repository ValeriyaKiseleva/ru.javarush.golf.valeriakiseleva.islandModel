package myislandmodel.islandfauna.animal.predator;

import myislandmodel.islandfauna.AnimalClassParameters;
import myislandmodel.islandmodel.island.Coordinates;

@AnimalClassParameters(maxCount = 30, maxSpeed = 1, maxSatiety = 3, animalWeight = 15)
public class Boa extends Predator {
    public Boa(Coordinates coordinates) {
        super(coordinates);
    }
}
