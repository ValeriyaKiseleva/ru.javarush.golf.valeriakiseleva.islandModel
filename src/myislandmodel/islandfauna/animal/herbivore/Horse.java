package myislandmodel.islandfauna.animal.herbivore;

import myislandmodel.islandfauna.AnimalClassParameters;
import myislandmodel.islandmodel.island.Coordinates;

@AnimalClassParameters(maxCount = 20, maxSpeed = 4, maxSatiety = 60, animalWeight = 400)
public class Horse extends Herbivore{
    public Horse(Coordinates coordinates) {
        super(coordinates);
    }
}
