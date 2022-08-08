package MyIslandModel.IslandFauna.Animal.Herbivore;

import MyIslandModel.IslandFauna.AnimalClassParameters;
import MyIslandModel.IslandModel.Island.Coordinates;

@AnimalClassParameters(maxCount = 10, maxSpeed = 3, maxSatiety = 100, animalWeight = 700)
public class Buffalo extends Herbivore{
    public Buffalo(Coordinates coordinates) {
        super(coordinates);
    }
}
