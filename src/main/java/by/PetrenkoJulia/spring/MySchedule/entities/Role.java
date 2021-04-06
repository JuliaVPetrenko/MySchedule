package by.PetrenkoJulia.spring.MySchedule.entities;

import com.sun.javafx.beans.IDProperty;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table (name = "roles")
public class Role {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

}
