package MyIslandModel.IslandFauna.Animal.Predator;

import MyIslandModel.IslandFauna.AnimalClassParameters;
import MyIslandModel.IslandModel.Island.Coordinates;

@AnimalClassParameters(maxCount = 20, maxSpeed = 3, maxSatiety = 1, animalWeight = 6)
public class Eagle extends Predator{
    public Eagle(Coordinates coordinates) {
        super(coordinates);
    }
}
