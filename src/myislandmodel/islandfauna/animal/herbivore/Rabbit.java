package myislandmodel.islandfauna.animal.herbivore;

import myislandmodel.islandfauna.AnimalClassParameters;
import myislandmodel.islandmodel.island.Coordinates;

@AnimalClassParameters(maxCount = 150, maxSpeed = 2, maxSatiety = 0.45f, animalWeight = 2)
public class Rabbit extends Herbivore {

    public Rabbit(Coordinates coordinates) {
        super(coordinates);
    }
}
