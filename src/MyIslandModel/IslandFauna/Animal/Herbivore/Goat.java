package MyIslandModel.IslandFauna.Animal.Herbivore;

import MyIslandModel.IslandFauna.AnimalClassParameters;
import MyIslandModel.IslandModel.Island.Coordinates;

@AnimalClassParameters(maxCount = 140, maxSpeed = 3, maxSatiety = 10, animalWeight = 60)
public class Goat extends Herbivore {
    public Goat(Coordinates coordinates) {
        super(coordinates);
    }
}
