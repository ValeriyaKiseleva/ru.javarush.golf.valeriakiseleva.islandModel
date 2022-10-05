package myislandmodel.islandfauna.animal.predator;

import myislandmodel.islandfauna.animal.Animal;
import myislandmodel.islandfauna.AnimalEatable;
import myislandmodel.islandmodel.island.Coordinates;

public abstract class Predator extends Animal implements AnimalEatable {


    public Predator(Coordinates coordinates) {
        super(coordinates);
    }

    @Override
    public void eat() {
        float victimWeight = this.hunting(getCoordinatesOnIsland());
        this.increaseSatiety(victimWeight);
    }
}
