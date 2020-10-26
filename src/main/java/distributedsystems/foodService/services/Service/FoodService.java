package distributedsystems.foodService.services.Service;

import distributedsystems.foodService.services.models.Food;
import distributedsystems.foodService.services.repository.FoodRepository;
import distributedsystems.foodService.services.IService.FoodIService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class FoodService implements FoodIService {
    @Autowired
    private FoodRepository repository;

    @Override
    public List<Food> findAll() {
        return (List<Food>) repository.findAll();
    }

    @Override
    public Food save(Food FoodForSave) {
        return repository.save(FoodForSave);
    }

    @Override
    public Food getById(UUID id) throws NotFoundException {
        Optional<Food> tempFood = repository.findById(id);
        if (tempFood.isPresent())
            return repository.findById(id).get();
        else
            throw new NotFoundException(String.format("Food with id %s does not exist", id));
    }

    @Override
    public void deleteById(UUID id) throws NotFoundException {
        repository.delete(getById(id));
    }
}