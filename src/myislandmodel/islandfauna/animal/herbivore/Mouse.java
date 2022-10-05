package myislandmodel.islandfauna.animal.herbivore;

import myislandmodel.islandfauna.AllEatable;
import myislandmodel.islandfauna.AnimalClassParameters;
import myislandmodel.islandmodel.island.Coordinates;

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
