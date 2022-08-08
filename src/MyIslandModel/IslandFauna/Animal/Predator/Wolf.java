package MyIslandModel.IslandFauna.Animal.Predator;


import MyIslandModel.IslandFauna.AnimalClassParameters;
import MyIslandModel.IslandModel.Island.Coordinates;

@AnimalClassParameters(maxCount = 30, maxSpeed = 3, maxSatiety = 8, animalWeight = 50)
public class Wolf extends Predator {


    public Wolf(Coordinates coordinates) {
        super(coordinates);
    }





}
