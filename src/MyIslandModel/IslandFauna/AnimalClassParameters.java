package MyIslandModel.IslandFauna;

import java.lang.annotation.*;

@Target(value = ElementType.TYPE)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface AnimalClassParameters {
    int maxCount();
    int maxSpeed();
    float maxSatiety();
    float animalWeight();
}
