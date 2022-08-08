package MyIslandModel.IslandFauna.Animal.Herbivore;

import MyIslandModel.IslandFauna.AnimalClassParameters;
import MyIslandModel.IslandModel.Island.Coordinates;

@AnimalClassParameters(maxCount = 20, maxSpeed = 4, maxSatiety = 50, animalWeight = 300)
public class Deer  extends Herbivore{
    public Deer(Coordinates coordinates) {
        super(coordinates);
    }
}
