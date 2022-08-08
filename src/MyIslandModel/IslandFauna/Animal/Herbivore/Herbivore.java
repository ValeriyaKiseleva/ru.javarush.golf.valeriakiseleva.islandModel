package MyIslandModel.IslandFauna.Animal.Herbivore;

import MyIslandModel.IslandFauna.Animal.Animal;
import MyIslandModel.IslandFauna.PlantEatable;
import MyIslandModel.IslandModel.Island.Coordinates;

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
