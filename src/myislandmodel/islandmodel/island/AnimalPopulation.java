package myislandmodel.islandmodel.island;

import myislandmodel.islandfauna.animal.Animal;
import myislandmodel.islandfauna.AnimalClassParameters;
import myislandmodel.islandmodel.IslandModel;
import myislandmodel.islandmodel.RandomOperation;
import myislandmodel.islandreferences.IconsReference;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

public class AnimalPopulation<T extends Animal> {
    private CopyOnWriteArrayList<T> population;
    private int populationCounter;
    private Class clazz;

    public AnimalPopulation(Class clazz) {
        this.clazz = clazz;
        this.population = new CopyOnWriteArrayList<>();
        this.populationCounter = 0;
    }

    public void populationIncrease(T animal) {
        population.add(animal);
        populationCounter++;
    }

    public void appearNewAnimal(int countOfAppearedEntities) throws Exception {
        for (int i = 0; i < countOfAppearedEntities; i++) {
            Coordinates randomCoordinates = new RandomOperation().getRandomCoordinates(clazz);
            Constructor<?> animalConstructor = clazz.getConstructor(Coordinates.class);
            animalConstructor.newInstance(randomCoordinates);
        }
    }

    private void appearNewbornAnimal(int countOfAppearedEntities, Coordinates locationCoordinates) throws Exception {
        for (int i = 0; i < countOfAppearedEntities; i++) {
            Constructor<?> animalConstructor = clazz.getConstructor(Coordinates.class);
            animalConstructor.newInstance(locationCoordinates);
        }
    }

    public void animalsMove() {
        for (T oneAnimal : population) {
            oneAnimal.transfer();
        }
    }

    public void animalReproduction() throws Exception {
        if (population.size() == 0) {
            return;
        }
        for (int i = 0; i < IslandModel.getIsland().getIslandHeight(); i++) {
            for (int j = 0; j < IslandModel.getIsland().getIslandWidth(); j++) {
                Coordinates locationCoordinates = new Coordinates();
                locationCoordinates.x = j;
                locationCoordinates.y = i;
                int countOfSameAnimal = Location.getLocationByCoordinates(locationCoordinates).getCountOfSameAnimal(clazz);

                if (countOfSameAnimal < 2) {
                    continue;
                }

                AnimalClassParameters annotations = (AnimalClassParameters) clazz.getAnnotation(AnimalClassParameters.class);
                int possibleCountOfNewAnimal = annotations.maxCount() - countOfSameAnimal;
                if (countOfSameAnimal / 2 < possibleCountOfNewAnimal) {
                    possibleCountOfNewAnimal = countOfSameAnimal / 2;
                }

                int countOfNewbornAnimals = 0;

                if (possibleCountOfNewAnimal != 0) {
                    countOfNewbornAnimals = new Random().nextInt(possibleCountOfNewAnimal + 1);
                }

                if (countOfNewbornAnimals != 0) {
                    appearNewbornAnimal(countOfNewbornAnimals, locationCoordinates);
                }
            }
        }
    }

    public void animalEat(Coordinates locCoordinates) {
        if (Location.getLocationByCoordinates(locCoordinates).getAnimalsOnLocation(clazz) == null) {
            return;
        }
        ArrayList<Animal> animalsOnLocation = Location.getLocationByCoordinates(locCoordinates).getAnimalsOnLocation(clazz);
        Collections.shuffle(animalsOnLocation);
        for (Animal someAnimal : animalsOnLocation) {
            someAnimal.checkSatiety();
        }
    }

    public void populationDecrease(Animal animal) {

        population.remove(animal);
        populationCounter--;

        if (populationCounter == 0) {
            System.out.println(IconsReference.getClassIcons().get(clazz) + " - the animal population is extinct...");
            IslandModel.getIsland().animalPopulationIsExtinct(clazz);
        }
    }

    public int getPopulationCounter() {
        return populationCounter;
    }
}
