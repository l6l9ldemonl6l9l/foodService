package distributedsystems.foodService.services.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@EnableAutoConfiguration
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Food {

    @Id
    @GeneratedValue
    private UUID id;
    @Column(unique = true)
    private int taste;
    private String kindFood;
    @GeneratedValue
    private Date birthday;


    public Food(int taste, String kindFood) {
        this.taste = taste;
        this.kindFood = kindFood;
        this.birthday = new Date();
        this.id = UUID.randomUUID();
    }

    public void showInformationAboutFood() {
        System.out.println("Еда : " + kindFood + ". Дата создания: " + birthday + ". Вкус: " + taste + ".\n");
    }

    public UUID getId() {
        return id;
    }

    public int getTaste() {
        return taste;
    }

}
