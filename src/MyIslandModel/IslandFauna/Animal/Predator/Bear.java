package MyIslandModel.IslandFauna.Animal.Predator;

import MyIslandModel.IslandFauna.AnimalClassParameters;
import MyIslandModel.IslandModel.Island.Coordinates;

@AnimalClassParameters(maxCount = 5, maxSpeed = 2, maxSatiety = 80, animalWeight = 500)
public class Bear extends Predator{
    public Bear(Coordinates coordinates) {
        super(coordinates);
    }
}
