package distributedsystems.foodService.services.IService;

import distributedsystems.foodService.services.models.Food;
import javassist.NotFoundException;
import java.util.List;
import java.util.UUID;

public interface FoodIService{
    List<Food> findAll();

    Food save(Food foodForSave);

    Food getById(UUID id) throws NotFoundException;

    void deleteById(UUID id) throws NotFoundException;
}
