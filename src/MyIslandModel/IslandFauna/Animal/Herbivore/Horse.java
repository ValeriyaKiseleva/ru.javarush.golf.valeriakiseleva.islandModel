package MyIslandModel.IslandFauna.Animal.Herbivore;

import MyIslandModel.IslandFauna.AnimalClassParameters;
import MyIslandModel.IslandModel.Island.Coordinates;

@AnimalClassParameters(maxCount = 20, maxSpeed = 4, maxSatiety = 60, animalWeight = 400)
public class Horse extends Herbivore{
    public Horse(Coordinates coordinates) {
        super(coordinates);
    }
}
