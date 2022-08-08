package MyIslandModel.IslandFauna.Animal.Predator;

import MyIslandModel.IslandFauna.Animal.Animal;
import MyIslandModel.IslandFauna.AnimalEatable;
import MyIslandModel.IslandModel.Island.Coordinates;

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
