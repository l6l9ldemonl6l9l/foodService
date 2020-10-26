package distributedsystems.foodService.api.restControllers;

import distributedsystems.foodService.api.payload.FoodPayload;
import distributedsystems.foodService.services.models.Food;
import distributedsystems.foodService.services.IService.FoodIService;
import distributedsystems.foodService.FoodApplication;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/food")
@AllArgsConstructor
@NoArgsConstructor
public final class FoodController {
    static final Logger log = LoggerFactory.getLogger(FoodApplication.class);

    @Autowired
    private FoodIService FoodService;

    @GetMapping
    public ResponseEntity<List<Food>> index() {
        return ResponseEntity.ok(FoodService.findAll());
    }

    @PostMapping
    public ResponseEntity<Food> create(@RequestBody FoodPayload payload) {
        Food newFood = new Food(payload.getTaste(),payload.getKindFood());
        return ResponseEntity.ok(FoodService.save(newFood));
    }

    @GetMapping("{FoodId}")
    public ResponseEntity<Food> show(@PathVariable UUID FoodId) throws NotFoundException {
        return ResponseEntity.ok(FoodService.getById(FoodId));
    }

    @DeleteMapping("{FoodId}")
    public ResponseEntity<Void> delete(@PathVariable UUID FoodId) throws NotFoundException {
        FoodService.deleteById(FoodId);
        return ResponseEntity.noContent().build();
    }
}