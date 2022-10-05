package myislandmodel.islandfauna;

import myislandmodel.islandmodel.island.Coordinates;

import java.util.Random;

public interface AllEatable extends AnimalEatable, PlantEatable{

    default float eatSmth(Coordinates coordinates, float satiety) {
        float countOfEatenFood = 0f;
        if (new Random().nextBoolean()) {
            countOfEatenFood = hunting(coordinates);
        }
        if (countOfEatenFood == 0) {
            countOfEatenFood = plantEat(coordinates, satiety);
        }
        return countOfEatenFood;
    }

}
