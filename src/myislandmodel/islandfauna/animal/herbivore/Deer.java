package myislandmodel.islandfauna.animal.herbivore;

import myislandmodel.islandfauna.AnimalClassParameters;
import myislandmodel.islandmodel.island.Coordinates;

@AnimalClassParameters(maxCount = 20, maxSpeed = 4, maxSatiety = 50, animalWeight = 300)
public class Deer  extends Herbivore{
    public Deer(Coordinates coordinates) {
        super(coordinates);
    }
}
