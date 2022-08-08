package MyIslandModel.IslandFauna.Animal.Herbivore;

import MyIslandModel.IslandFauna.AnimalClassParameters;
import MyIslandModel.IslandModel.Island.Coordinates;

@AnimalClassParameters(maxCount = 140, maxSpeed = 3, maxSatiety = 15, animalWeight = 70)
public class Sheep extends Herbivore{
    public Sheep(Coordinates coordinates) {
        super(coordinates);
    }
}
