package myislandmodel.islandfauna.animal.herbivore;

import myislandmodel.islandfauna.AnimalClassParameters;
import myislandmodel.islandmodel.island.Coordinates;

@AnimalClassParameters(maxCount = 10, maxSpeed = 3, maxSatiety = 100, animalWeight = 700)
public class Buffalo extends Herbivore{
    public Buffalo(Coordinates coordinates) {
        super(coordinates);
    }
}
