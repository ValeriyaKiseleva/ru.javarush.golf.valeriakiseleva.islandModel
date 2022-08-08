package MyIslandModel.IslandFauna.Animal.Predator;

import MyIslandModel.IslandFauna.AnimalClassParameters;
import MyIslandModel.IslandModel.Island.Coordinates;

@AnimalClassParameters(maxCount = 30, maxSpeed = 1, maxSatiety = 3, animalWeight = 15)
public class Boa extends Predator {
    public Boa(Coordinates coordinates) {
        super(coordinates);
    }
}
