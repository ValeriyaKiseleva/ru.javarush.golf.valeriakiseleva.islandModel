package myislandmodel.islandmodel.island;

import myislandmodel.islandfauna.animal.Animal;
import myislandmodel.islandfauna.AnimalClassParameters;
import myislandmodel.islandmodel.IslandModel;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Location {
    private volatile ConcurrentHashMap<Class, HashSet<Animal>> locationEntities;
    private int plantsCount;
    private final static int MAX_PLANTS_COUNT = 200;

    public Location() {
        this.locationEntities = new ConcurrentHashMap<Class, HashSet<Animal>>();
    }

    public int getPlantsCount() {
        return plantsCount;
    }

    public void settlementLocation(Animal animal) {
        if (!locationEntities.containsKey(animal.getClass())) {
            locationEntities.put(animal.getClass(), new HashSet<>());
        }
        locationEntities.get(animal.getClass()).add(animal);
    }

    //
    public void  deleteFromLocation(Animal animal) {
        locationEntities.get(animal.getClass()).remove(animal);
    }

    //
    public boolean locationOverflowCheck(Class animalClass) {
        if (!animalClass.isAnnotationPresent(AnimalClassParameters.class)) {
            throw new RuntimeException();
        }
        AnimalClassParameters annotations = (AnimalClassParameters) animalClass.getAnnotation(AnimalClassParameters.class);
        int maxCountOnLocation = annotations.maxCount();

        return this.locationEntities.containsKey(animalClass) && this.locationEntities.get(animalClass).size() >= maxCountOnLocation;
    }

    public int getCountOfSameAnimal(Class animalClass) {
        if (locationEntities.containsKey(animalClass)) {
            return locationEntities.get(animalClass).size();
        }
        return 0;
    }

    public Animal getFoodOnLocation(ArrayList<Class> animalsForFinding) {
        Collections.shuffle(animalsForFinding);
        for (Class foundAnimal : animalsForFinding) {
            if (locationEntities.containsKey(foundAnimal) && locationEntities.get(foundAnimal).size() > 0) {
                Iterator<Animal> it = locationEntities.get(foundAnimal).iterator();
                return it.next();
            }
        }
        return null;
    }

    public ArrayList<Animal> getAnimalsOnLocation(Class animalClass) {
        if (locationEntities.containsKey(animalClass) && locationEntities.get(animalClass).size() > 0) {
            return new ArrayList<>(locationEntities.get(animalClass));
        }
        return null;
    }

    public void startPlantsFill() {
        plantsCount = new Random().nextInt(MAX_PLANTS_COUNT) + 1;
    }

    public void plantDecrease(int decreaseCount) {
        this.plantsCount -= decreaseCount;
    }

    public static Location getLocationByCoordinates(Coordinates coordinates) {
        return IslandModel.getIsland().getLocation(coordinates);
    }


    public void plantIncrease() {
        int countPlantsToGrow = MAX_PLANTS_COUNT;

        if (plantsCount > 0) {
            countPlantsToGrow = MAX_PLANTS_COUNT - plantsCount;
        }

        plantsCount = new Random().nextInt(countPlantsToGrow + 1);

    }
}
