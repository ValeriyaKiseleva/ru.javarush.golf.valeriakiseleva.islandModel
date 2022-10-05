package myislandmodel.islandfauna.animal.herbivore;

import myislandmodel.islandfauna.AllEatable;
import myislandmodel.islandfauna.AnimalClassParameters;
import myislandmodel.islandmodel.island.Coordinates;

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
