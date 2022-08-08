package MyIslandModel.IslandFauna.Animal.Herbivore;

import MyIslandModel.IslandFauna.AllEatable;
import MyIslandModel.IslandFauna.AnimalClassParameters;
import MyIslandModel.IslandModel.Island.Coordinates;

@AnimalClassParameters(maxCount = 500, maxSpeed = 1, maxSatiety = 0.01f, animalWeight = 0.05f)
public class Mouse extends Herbivore implements AllEatable {
    public Mouse(Coordinates coordinates) {
        super(coordinates);
    }

    @Override
    public void eat() {
        float weightOfEatenFood = this.eatSmth(getCoordinatesOnIsland(), getCurrentSatiety());
        this.increaseSatiety(weightOfEatenFood);
    }
}
