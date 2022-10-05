package myislandmodel.islandfauna.animal.herbivore;

import myislandmodel.islandfauna.animal.Animal;
import myislandmodel.islandfauna.PlantEatable;
import myislandmodel.islandmodel.island.Coordinates;

public abstract class Herbivore extends Animal implements PlantEatable {


    public Herbivore(Coordinates coordinates) {
        super(coordinates);
    }

    @Override
    public void eat() {
        float weightOfEatenFood = this.plantEat(getCoordinatesOnIsland(), getCurrentSatiety());
        this.increaseSatiety(weightOfEatenFood);
    }

}
