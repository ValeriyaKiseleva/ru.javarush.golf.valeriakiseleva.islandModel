package myislandmodel.islandfauna.animal.herbivore;

import myislandmodel.islandfauna.AnimalClassParameters;
import myislandmodel.islandmodel.island.Coordinates;

@AnimalClassParameters(maxCount = 140, maxSpeed = 3, maxSatiety = 15, animalWeight = 70)
public class Sheep extends Herbivore{
    public Sheep(Coordinates coordinates) {
        super(coordinates);
    }
}
