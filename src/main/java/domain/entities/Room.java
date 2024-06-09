package domain.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class Room extends PanacheEntity{
    public String name;
}
