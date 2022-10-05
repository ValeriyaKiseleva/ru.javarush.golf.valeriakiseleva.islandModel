package myislandmodel.islandfauna.animal.herbivore;

import myislandmodel.islandfauna.AnimalClassParameters;
import myislandmodel.islandmodel.island.Coordinates;

@AnimalClassParameters(maxCount = 140, maxSpeed = 3, maxSatiety = 10, animalWeight = 60)
public class Goat extends Herbivore {
    public Goat(Coordinates coordinates) {
        super(coordinates);
    }
}
