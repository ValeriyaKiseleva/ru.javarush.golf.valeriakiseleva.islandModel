package MyIslandModel.IslandFauna.Animal;

import MyIslandModel.IslandFauna.AnimalClassParameters;
import MyIslandModel.IslandModel.*;
import MyIslandModel.IslandModel.Island.Coordinates;
import MyIslandModel.IslandModel.Island.Location;

public abstract class Animal {
    private Coordinates coordinatesOnIsland;
    private float currentSatiety;

    public Animal(Coordinates coordinates) {
        this.coordinatesOnIsland = coordinates;
        this.currentSatiety = this.getClass().getAnnotation(AnimalClassParameters.class).maxSatiety();
        appearOnIsland();
    }

    public float getCurrentSatiety() {
        return currentSatiety;
    }

    public Coordinates getCoordinatesOnIsland() {
        return coordinatesOnIsland;
    }

    private void appearOnIsland() {
        IslandModel.getIsland().getPopulationMap().get(this.getClass()).populationIncrease(this);
        addToLocation();
    }

    //
    public void transfer() {
        this.decreaseSatiety();

        Coordinates nextCoordinates = new RandomOperation().getRandomTransferCoordinate(this);

        if (coordinatesOnIsland.x != nextCoordinates.x || coordinatesOnIsland.y != nextCoordinates.y) {
            this.leaveLocation();

            coordinatesOnIsland.x = nextCoordinates.x;
            coordinatesOnIsland.y = nextCoordinates.y;
            this.addToLocation();
        }
    }

    private void leaveLocation() {
        Location.getLocationByCoordinates(coordinatesOnIsland).deleteFromLocation(this);
    }

    private void addToLocation() {
        Location.getLocationByCoordinates(coordinatesOnIsland).settlementLocation(this);
    }

    public abstract void eat();

    public void checkSatiety() {
        if (this.currentSatiety <= (this.getClass().getAnnotation(AnimalClassParameters.class).maxSatiety()) * 0.9) {
            eat();
        }
    }

    public void leaveTheWorld() {
        if (IslandModel.getIslandPopulationMap().get(this.getClass()) != null) {
            IslandModel.getIslandPopulationMap().get(this.getClass()).populationDecrease(this);
        }

        Location.getLocationByCoordinates(coordinatesOnIsland).deleteFromLocation(this);

    }

    public void increaseSatiety(float increasedWeigh) {
        if ((currentSatiety + increasedWeigh) > this.getClass().getAnnotation(AnimalClassParameters.class).maxSatiety()) {
            this.currentSatiety = this.getClass().getAnnotation(AnimalClassParameters.class).maxSatiety();
        } else {
            this.currentSatiety += increasedWeigh;
        }
    }

    private void decreaseSatiety() {
        currentSatiety -= currentSatiety * 0.1;
        if (currentSatiety < this.getClass().getAnnotation(AnimalClassParameters.class).maxSatiety() * 0.1) {
            this.leaveTheWorld();
        }
    }
}
