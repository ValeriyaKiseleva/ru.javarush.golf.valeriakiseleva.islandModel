package MyIslandModel.IslandFauna.Animal.Herbivore;

import MyIslandModel.IslandFauna.AllEatable;
import MyIslandModel.IslandFauna.AnimalClassParameters;
import MyIslandModel.IslandModel.Island.Coordinates;

@AnimalClassParameters(maxCount = 50, maxSpeed = 2, maxSatiety = 50, animalWeight = 400)
public class Boar extends Herbivore implements AllEatable {
    public Boar(Coordinates coordinates) {
        super(coordinates);
    }

    @Override
    public void eat() {
        float weightOfEatenFood = this.eatSmth(getCoordinatesOnIsland(), getCurrentSatiety());
        this.increaseSatiety(weightOfEatenFood);
    }
}
