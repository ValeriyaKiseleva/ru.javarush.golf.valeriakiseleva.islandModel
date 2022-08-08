package MyIslandModel.IslandFauna.Animal.Predator;

import MyIslandModel.IslandFauna.AnimalClassParameters;
import MyIslandModel.IslandModel.Island.Coordinates;

@AnimalClassParameters(maxCount = 30, maxSpeed = 2, maxSatiety = 2, animalWeight = 8)
public class Fox extends Predator{
    public Fox(Coordinates coordinates) {
        super(coordinates);
    }
}
