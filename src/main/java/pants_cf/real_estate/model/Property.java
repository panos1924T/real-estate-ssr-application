package pants_cf.real_estate.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * The Property class represents a real estate property and serves as an entity in the persistence context.
 * It includes fields for essential property details such as title, location, price, size, and availability.
 * This class is mapped to the "properties" table in the database.
 */

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "properties")
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, updatable = false)
    private UUID uuid;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private int squareMeters;

    private String propertyType;

    @Column(nullable = false)
    private boolean available;

    @PrePersist
    public void initializeUuid() {
        if (uuid == null) uuid = UUID.randomUUID();
    }
}
