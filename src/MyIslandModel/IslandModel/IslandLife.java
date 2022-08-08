package MyIslandModel.IslandModel;

import MyIslandModel.IslandModel.Island.AnimalPopulation;
import MyIslandModel.IslandModel.Island.Coordinates;
import MyIslandModel.IslandModel.Island.Location;
import MyIslandModel.IslandReferences.IconsReference;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class IslandLife {
    public static boolean isLife = true;

    public static void islandLifeRun() throws Exception {

        plantsGrow();


        while (isLife) {
            timeToMove();
            timeToReproduce();
            timeToEat();
            printStatistic();
        }

    }

    private static void timeToMove() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        CountDownLatch countDownLatch = new CountDownLatch(IslandModel.getIsland().getPopulationMap().size());
        for (AnimalPopulation onePopulation : IslandModel.getIsland().getPopulationMap().values()) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    onePopulation.animalsMove();
                    countDownLatch.countDown();
                }
            });
        }
        executorService.shutdown();
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void timeToReproduce() throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        CountDownLatch countDownLatch = new CountDownLatch(IslandModel.getIsland().getPopulationMap().size());
        for (AnimalPopulation onePopulation : IslandModel.getIsland().getPopulationMap().values()) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        onePopulation.animalReproduction();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    countDownLatch.countDown();
                }
            });
        }
        try {
            executorService.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }
        countDownLatch.await();
    }

    private static void timeToEat() {
        ExecutorService executorService = Executors.newFixedThreadPool(25);
        CountDownLatch countDownLatch = new CountDownLatch(IslandModel.getIsland().getCountOfLocation());
        for (int i = 0; i < IslandModel.getIsland().getIslandHeight(); i++) {
            for (int j = 0; j < IslandModel.getIsland().getIslandWidth(); j++) {
                Coordinates locCoordinates = new Coordinates();
                locCoordinates.x = j;
                locCoordinates.y = i;
                executorService.execute(new Runnable() {
                    @Override
                    public void run() {
                        foodExtract(locCoordinates);
                        countDownLatch.countDown();
                    }
                });

            }
        }
        executorService.shutdown();
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void foodExtract(Coordinates locCoordinates) {
        for (AnimalPopulation onePopulation : IslandModel.getIsland().getPopulationMap().values()) {
            onePopulation.animalEat(locCoordinates);
        }
    }

    private static void printStatistic() {
        if (IslandModel.getIsland().getPopulationMap().size() != 0) {
            System.out.println("On the Island:");
            for (Class animalClass : IslandModel.getIsland().getPopulationMap().keySet()) {
                System.out.print(IconsReference.getClassIcons().get(animalClass) + " - ");
                System.out.print(IslandModel.getIsland().getPopulationMap().get(animalClass).getPopulationCounter() + "\t");
            }
            System.out.println();

        }


    }

    private static void plantsGrow() {
        Thread growing = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        for (int i = 0; i < IslandModel.getIsland().getIslandHeight(); i++) {
                            for (int j = 0; j < IslandModel.getIsland().getIslandWidth(); j++) {
                                Coordinates locCoordinates = new Coordinates();
                                locCoordinates.x = j;
                                locCoordinates.y = i;
                                Location.getLocationByCoordinates(locCoordinates).plantIncrease();
                            }
                        }
                        Thread.sleep(10);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        growing.setDaemon(true);
        growing.start();

    }


}
