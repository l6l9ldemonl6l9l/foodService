package distributedsystems.foodService.services.repository;

import distributedsystems.foodService.services.models.Food;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface FoodRepository extends CrudRepository <Food, Long > {
    Optional<Food> findById(UUID id);
}
