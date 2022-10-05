package myislandmodel.islandfauna.animal.predator;


import myislandmodel.islandfauna.AnimalClassParameters;
import myislandmodel.islandmodel.island.Coordinates;

@AnimalClassParameters(maxCount = 30, maxSpeed = 3, maxSatiety = 8, animalWeight = 50)
public class Wolf extends Predator {


    public Wolf(Coordinates coordinates) {
        super(coordinates);
    }





}
