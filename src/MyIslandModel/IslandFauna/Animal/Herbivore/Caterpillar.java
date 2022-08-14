package MyIslandModel.IslandFauna.Animal.Herbivore;

import MyIslandModel.IslandFauna.AnimalClassParameters;
import MyIslandModel.IslandModel.Island.Coordinates;
import MyIslandModel.IslandModel.Island.Location;

import java.util.Random;

@AnimalClassParameters(maxCount = 1000, maxSpeed = 0, maxSatiety = 0, animalWeight = 0.01f)
public class Caterpillar extends Herbivore {
    public Caterpillar(Coordinates coordinates) {
        super(coordinates);
    }

    @Override
    public void transfer() {
    }

    @Override
    public void checkSatiety() {
       eat();
    }

    @Override
    public void eat() {
        float eatenFood = plantEat(getCoordinatesOnIsland(), getCurrentSatiety());
        if (eatenFood == 0 && new Random().nextBoolean()) {
            this.leaveTheWorld();
        }

    }

    @Override
    public float plantEat(Coordinates coordinates, float currentSatiety) {
        int plantsCount = Location.getLocationByCoordinates(coordinates).getPlantsCount();

        if (plantsCount > 0 && new Random().nextBoolean()) {
                Location.getLocationByCoordinates(coordinates).plantDecrease(1);
                return 1;
        }
        return 0;
    }
}
