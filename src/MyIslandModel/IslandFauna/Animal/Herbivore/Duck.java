package MyIslandModel.IslandFauna.Animal.Herbivore;

import MyIslandModel.IslandFauna.AllEatable;
import MyIslandModel.IslandFauna.AnimalClassParameters;
import MyIslandModel.IslandModel.Island.Coordinates;

@AnimalClassParameters(maxCount = 200, maxSpeed = 4, maxSatiety = 0.15f, animalWeight = 1)
public class Duck extends Herbivore implements AllEatable {

    public Duck(Coordinates coordinates) {
        super(coordinates);
    }


    @Override
    public void eat() {
        float weightOfEatenFood = this.eatSmth(getCoordinatesOnIsland(), getCurrentSatiety());
        this.increaseSatiety(weightOfEatenFood);
    }


}
