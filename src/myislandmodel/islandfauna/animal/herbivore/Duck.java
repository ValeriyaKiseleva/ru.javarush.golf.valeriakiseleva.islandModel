package myislandmodel.islandfauna.animal.herbivore;

import myislandmodel.islandfauna.AllEatable;
import myislandmodel.islandfauna.AnimalClassParameters;
import myislandmodel.islandmodel.island.Coordinates;

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
